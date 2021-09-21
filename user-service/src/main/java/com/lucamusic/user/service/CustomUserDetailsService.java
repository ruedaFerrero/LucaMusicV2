/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucamusic.user.service;


import com.lucamusic.user.entity.DAOUser;
import com.lucamusic.user.repository.UserRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author miso
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles=null;
        
        DAOUser user = userDao.findByEmail(email);
        if (user != null) {
                roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
                return new User(user.getEmail(), user.getPassword(), roles);
        }
        
        throw new UsernameNotFoundException("User not found with username: " + email);
    }
    
    public DAOUser save(DAOUser user) {
        DAOUser userDB = userDao.findByEmail(user.getEmail());
        if(userDB != null) {
                 return userDB;
        }
        DAOUser newUser = new DAOUser();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        newUser.setStatus("CREATED");
        newUser.setRegisterDate(LocalDate.now());
        System.out.println("########################: "+newUser);
        return userDao.save(newUser);
    }
    
    public DAOUser findByID(Long id) {
            return userDao.findById(id).orElse(null);
    }

}