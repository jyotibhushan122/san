package org.movie.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.movie.constent.ScreenConstent;
import org.movie.constent.SeatStatus;
import org.movie.constent.SeatType;
import org.movie.constent.TimeConstent;
import org.movie.util.AuditModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_seat")
public class SeatDTO extends AuditModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int number;
	private SeatType seatType;
	private String series;
	private Integer ammount;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "screen_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ScreenDTO screenId;
	private SeatStatus seatStatus;
	private LocalDate slotDate;
	@Column(name = "is_seat_booked")
	private boolean isBooked;
	private ScreenConstent screen;
	private TimeConstent showProfile;
	private Long seatId;
	private boolean bookedStatus;
	private LocalDate bookedDate;
	private String txId;
	

	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}

	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}

	/**
	 * @return the bookedDate
	 */
	public LocalDate getBookedDate() {
		return bookedDate;
	}

	/**
	 * @param bookedDate the bookedDate to set
	 */
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	/**
	 * @return the seatId
	 */
	public Long getSeatId() {
		return seatId;
	}

	/**
	 * @param seatId the seatId to set
	 */
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	/**
	 * @return the bookedStatus
	 */
	public boolean isBookedStatus() {
		return bookedStatus;
	}

	/**
	 * @param bookedStatus the bookedStatus to set
	 */
	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	/**
	 * @return the seatStatus
	 */
	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	/**
	 * @param seatNotBooked the seatStatus to set
	 */
	public void setSeatStatus(SeatStatus seatNotBooked) {
		this.seatStatus = seatNotBooked;
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

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType normal) {
		this.seatType = normal;
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

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public LocalDate getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}

	public ScreenConstent getScreen() {
		return screen;
	}

	public void setScreen(ScreenConstent screen) {
		this.screen = screen;
	}

	public TimeConstent getShowProfile() {
		return showProfile;
	}

	public void setShowProfile(TimeConstent timeConstent) {
		this.showProfile = timeConstent;
	}

}
