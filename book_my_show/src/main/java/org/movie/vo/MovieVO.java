package org.movie.vo;

import java.io.Serializable;
import java.util.List;

public class MovieVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String movieName;
	private String title;
	private String description;
	private List<String> cast;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

}
