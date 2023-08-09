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
	
	@ManyToOne
	@JoinColumn(name="idSchedule", nullable=false,foreignKey =@ForeignKey(name="FK_schedule_reservation"))
	private Schedule schedule;
	public Integer getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ReservationState getReservationState() {
		return reservationState;
	}
	public void setReservationState(ReservationState reservationState) {
		this.reservationState = reservationState;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
