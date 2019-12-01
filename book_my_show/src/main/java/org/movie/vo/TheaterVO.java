package org.movie.vo;

import java.io.Serializable;

public class TheaterVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theaterName;
	private String address;
	private Integer seatNumber;

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
