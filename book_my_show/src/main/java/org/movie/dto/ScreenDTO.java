package org.movie.dto;

import java.io.Serializable;
import java.time.LocalDate;

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
import org.movie.constent.TimeConstent;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_screen")
public class ScreenDTO implements Serializable {

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String screenName;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "theater_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TheaterDTO theaterId;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "movie_id", unique = true, nullable = true, insertable =
	 * true, updatable = true)
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE)
	 * 
	 * private MovieDTO movieId;
	 */

	private long movieId;

	private ScreenConstent screen;
	private TimeConstent showProfile;
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

	public LocalDate getBookedShowDate() {
		return bookedShowDate;
	}

	public void setBookedShowDate(LocalDate bookedShowDate) {
		this.bookedShowDate = bookedShowDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public TheaterDTO getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(TheaterDTO theaterId) {
		this.theaterId = theaterId;
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

	public void setShowProfile(TimeConstent k) {
		this.showProfile = k;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
