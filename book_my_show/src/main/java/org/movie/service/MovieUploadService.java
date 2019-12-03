package org.movie.service;

import java.util.List;

import org.movie.vo.MovieVO;

public interface MovieUploadService {

	public long uploadMovie(MovieVO vo) throws Exception;

	public List<MovieVO> getAllMovie(String field);

	public void bookMovie();

	public void addMovieToScreen(MovieVO vo) throws Exception;
}
