package com.lucamusic.user.service;

import java.util.List;

import com.lucamusic.user.entity.User;
/**
* Nombre de la clase: UserService
 * Esta interfaz es la encargada de llevar a cabo los metodos del UserRepository
 * @author:Emanuel
 * @version: 14/09/2021/v1
 */

public interface UserService {
	public User findByID(Long id);
	public User createUser(User user);
}
