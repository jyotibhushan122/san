package org.movie.service;

import java.time.LocalDate;
import java.util.List;

import org.movie.vo.MovieVO;
import org.movie.vo.ReportVo;
import org.movie.vo.SeatVo;

public interface MovieService {

	void addMovie(MovieVO vo);

	void deleteMovie(String movieName);

	public List<ReportVo>  genReport(LocalDate fromDate, LocalDate toDate);
	
	SeatVo updateStatus(MovieVO movieVo) throws Exception;

}
