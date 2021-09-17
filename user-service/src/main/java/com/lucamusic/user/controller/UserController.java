package com.lucamusic.user.controller;

import javax.validation.Valid;

import com.lucamusic.user.service.UserService;
import com.lucamusic.user.utils.Utils;
import com.lucamusic.user.controller.error.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.user.entity.User;
import org.springframework.web.server.ResponseStatusException;

/**
 * Nombre de la clase: UserControl
 * Esta clase se encarga de poner en uso los eventos de UserRepository
 * @author Emanuel
 * @version 14/09/2021/v1
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired 
	private UserService userServ;

	/**
	 * Método para añadir un usuario
	 * @param user Usuario a crear
	 * @param result resultado de las validaciones
	 * @return Usuario creado, respuesta 201 o bad_request si la solicitud es incorrecta
	 */
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody  User user, BindingResult result){
		log.info("Creating User: {}", user);
		//si hay un error, debe saltar una excepción antes de entrar
		//que captura el CustomGlobalExceptionHandler
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		User userDB = userServ.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDB);
	}

	/**
	 * Método para obtener la información de un usuario
	 * @param id Id del usuario
	 * @return Usuario + status 200, 404 si no existe
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		log.info("Fetching User with id {}", id);
		
		User user = userServ.findByID(id);
		if(user == null){
			log.error("User with id {} not found", id);
//			return ResponseEntity.notFound().build();
			throw new UserNotFoundException();
		}
		return ResponseEntity.ok(user);
	}
}
