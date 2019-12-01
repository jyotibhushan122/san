package org.movie.service;

import java.util.List;

import org.movie.vo.MovieVO;

public interface MovieUploadService {

	public void uploadMovie(MovieVO vo) throws Exception;

	public List<MovieVO> getAllMovie();

	public void bookMovie();

	public void addMovieToScreen(MovieVO vo) throws Exception;
}
