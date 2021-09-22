package com.lucamusic.order.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fullName;
	
	public static UserResponse of(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setFullName(user.getFullName());
		return userResponse;
	}
	
	

}
