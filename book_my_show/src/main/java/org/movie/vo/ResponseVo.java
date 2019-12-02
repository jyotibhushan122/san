package org.movie.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScreenVO vo;
	private List<SeatVo> satVo;

	public ScreenVO getVo() {
		return vo;
	}

	public void setVo(ScreenVO vo) {
		this.vo = vo;
	}

	public List<SeatVo> getSatVo() {
		return satVo;
	}

	public void setSatVo(List<SeatVo> satVo) {
		this.satVo = satVo;
	}

}
