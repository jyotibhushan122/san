package org.movie.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class TheaterVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theaterName;
	private String address;
	
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
