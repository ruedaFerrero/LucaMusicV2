package com.lucamusic.user.service;

import com.lucamusic.user.entity.User;
import com.lucamusic.user.repository.UserRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles=null;
        
        User user = userRepository.findByEmail(email);
        if (user != null) {
                roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
                return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
        }
        
        throw new UsernameNotFoundException("User not found with username: " + email);
    }
    
    public User save(User user) {
        User userDB = userRepository.findByEmail(user.getEmail());
        if(userDB != null) {
            return userDB;
        }

        userDB = User.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(bcryptEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .status("CREATED")
                .registerDate(LocalDate.now()).build();

        return userRepository.save(userDB);
    }
    
    public User findByID(Long id) {
        return findByIdNotDeleted(id);
    }

    private User findByIdNotDeleted(Long id){
        return userRepository.findByIdAndStatusNotContains(id, "DELETED").orElse(null);
    }
}