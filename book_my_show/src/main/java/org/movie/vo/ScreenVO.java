package org.movie.vo;

public class ScreenVO {

	private String screenName;
	private TheaterVO theaterId;
	private String movieId;
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
	
}
