package org.movie.service;

import java.util.List;
import java.util.Map;

import org.movie.vo.TheaterVO;

public interface TheaterService {
	void addTheater(TheaterVO vo) throws Exception;

	List<TheaterVO> getTheaters();

	public Map<String, String> time();

	void addScreen();

}
