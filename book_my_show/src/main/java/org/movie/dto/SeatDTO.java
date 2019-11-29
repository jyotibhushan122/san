package org.movie.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_seat")
public class SeatDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private int row;
	private int number;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "screen_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ScreenDTO screenDTO;
	private boolean isBooked;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "reservation_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ReservationDTO reservationDTO;
}
