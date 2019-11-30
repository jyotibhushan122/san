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
import org.movie.constent.SeatStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_seat")
public class SeatDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private SeatStatus seatStatus;

	/**
	 * @return the seatStatus
	 */
	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	/**
	 * @param seatStatus the seatStatus to set
	 */
	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

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

}
