package org.movie.service;

import org.movie.vo.MovieVO;

public interface MovieService {

	void addMovie(MovieVO vo);

	void deleteMovie( String movieName);

	

}
