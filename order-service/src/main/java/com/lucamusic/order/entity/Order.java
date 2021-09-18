package com.lucamusic.order.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders") @NoArgsConstructor @AllArgsConstructor
public class Order implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	//User user;
	//Event event;
	
	private String status;
}
