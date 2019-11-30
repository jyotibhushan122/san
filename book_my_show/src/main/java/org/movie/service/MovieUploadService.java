package org.movie.service;

import org.movie.vo.MovieVO;

public interface MovieUploadService {

	public void uploadMovie(MovieVO vo) throws Exception;

	public void bookMovie();
}
