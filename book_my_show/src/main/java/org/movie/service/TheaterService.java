package org.movie.service;

import java.util.List;
import java.util.Map;

import org.movie.vo.TheaterVO;

public interface TheaterService {

	List<TheaterVO> getTheaters();

	public Map<String, String> time();
	void addScreen();

}
