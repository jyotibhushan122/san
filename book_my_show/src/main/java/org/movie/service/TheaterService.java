package org.movie.service;

import java.util.List;
import java.util.Map;

import org.movie.constent.ScreenConstent;
import org.movie.dto.TheaterDTO;
import org.movie.vo.MovieVO;
import org.movie.vo.ResponseVo;
import org.movie.vo.TheaterVO;

public interface TheaterService {
	void addTheater(TheaterVO vo) throws Exception;

	List<TheaterVO> getTheaters();

	public Map<String, String> time();

	void addScreen(MovieVO vo, TheaterDTO dto, List<ScreenConstent> screenContent);

	void addMovieToScreen(MovieVO vo) throws Exception;

	public List<ResponseVo> getScreenForBooked(MovieVO vo) throws Exception;

}
