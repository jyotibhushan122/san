package org.movie.dto;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_reservation")
public class ReservationDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String personName;
	private Integer noOfSeatBooked;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "screen_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ScreenDTO screen;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getNoOfSeatBooked() {
		return noOfSeatBooked;
	}
	public void setNoOfSeatBooked(Integer noOfSeatBooked) {
		this.noOfSeatBooked = noOfSeatBooked;
	}
	public ScreenDTO getScreen() {
		return screen;
	}
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}
	
}
