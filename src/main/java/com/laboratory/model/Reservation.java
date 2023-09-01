package com.laboratory.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	@Column(name="title")
	private String title;
	@Column(name="message")
	private String message;
	@Column(name="reservationDate")
	private LocalDateTime reservationDate;
	@Column(name="reservationTime")
	private LocalTime reservationTime;
	@Column(name="creationDate")
	private LocalDateTime creationDate;
	@OneToOne(targetEntity = ReservationState.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name="id_state")
	private ReservationState reservationState;
	
}
