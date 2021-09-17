package com.lucamusic.order.entity;

import javax.persistence.Entity;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.User;

import lombok.Data;

@Entity
@Data
public class Order {
	Long id;
	User user;
	Event event;
	private String status;
}
