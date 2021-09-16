package com.lucamusic.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.user.entity.User;

import java.util.List;

/**
* Nombre de la clase: UserRepository
 * Esta Interfaz es la encargada de llamar a los metodos(save, delete, findById...)
 * @author Emanuel
 * @version 14/09/2021/v1
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public User findByEmail(String email);
}