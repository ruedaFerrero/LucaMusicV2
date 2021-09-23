/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucamusic.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author miso
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}
