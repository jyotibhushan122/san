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
import org.movie.constent.ScreenConstent;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_screen")
public class ScreenDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String screenName;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "theater_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TheaterDTO theaterId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movie_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private MovieDTO movieId;
	private ScreenConstent screen;

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

	public MovieDTO getMovieId() {
		return movieId;
	}

	public void setMovieId(MovieDTO movieId) {
		this.movieId = movieId;
	}

	public ScreenConstent getScreen() {
		return screen;
	}

	public void setScreen(ScreenConstent screen) {
		this.screen = screen;
	}

}
