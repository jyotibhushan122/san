package org.movie.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.movie.constent.ScreenConstent;
import org.movie.dto.ScreenDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SeatVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private int number;
	private String seatType;
	private String series;
	private Integer ammount;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "screen_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ScreenDTO screenId;
	private String seatStatus;
	private LocalDate slotDate;
	@Column(name = "is_seat_booked")
	private boolean isBooked;
	private ScreenConstent screen;
	private String showProfile;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public ScreenDTO getScreenId() {
		return screenId;
	}
	public void setScreenId(ScreenDTO screenId) {
		this.screenId = screenId;
	}
	public String getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
	public LocalDate getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public ScreenConstent getScreen() {
		return screen;
	}
	public void setScreen(ScreenConstent screen) {
		this.screen = screen;
	}
	public String getShowProfile() {
		return showProfile;
	}
	public void setShowProfile(String showProfile) {
		this.showProfile = showProfile;
	}
}
