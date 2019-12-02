package org.movie.vo;

import java.io.Serializable;
import java.time.LocalDate;

import org.movie.constent.ScreenConstent;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ScreenVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String screenName;
	private TheaterVO theaterId;
	private String movieId;

	private ScreenConstent screen;
	private String showProfile;
	private String time;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate bookedShowDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate validFrom;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate validTo;

	/**
	 * @return the screenName
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * @return the theaterId
	 */
	public TheaterVO getTheaterId() {
		return theaterId;
	}

	/**
	 * @param theaterId the theaterId to set
	 */
	public void setTheaterId(TheaterVO theaterId) {
		this.theaterId = theaterId;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getBookedShowDate() {
		return bookedShowDate;
	}

	public void setBookedShowDate(LocalDate bookedShowDate) {
		this.bookedShowDate = bookedShowDate;
	}

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

}
