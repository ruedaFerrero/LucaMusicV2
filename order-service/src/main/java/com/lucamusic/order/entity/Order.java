package com.lucamusic.order.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="orders")@NoArgsConstructor @AllArgsConstructor
public class Order implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	private Long userId;
	private String userName;
	private int ccv;
	private Long eventId;
	private String eventName;
	private String status;
}
