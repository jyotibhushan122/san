package org.movie.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScreenVO screen;
	private List<SeatVo> seatVo;

	

	public List<SeatVo> getSeatVo() {
		return seatVo;
	}

	public void setSeatVo(List<SeatVo> seatVo) {
		this.seatVo = seatVo;
	}

	public ScreenVO getScreen() {
		return screen;
	}

	public void setScreen(ScreenVO screen) {
		this.screen = screen;
	}

}
