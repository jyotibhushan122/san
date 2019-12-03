package org.movie.serviceImpl;

import java.util.Optional;

import org.movie.dao.MovieDAO;
import org.movie.dto.MovieDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.MovieService;
import org.movie.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper mapper;

	@Autowired
	private MovieDAO movieDAO;

	@Override
	public void addMovie(MovieVO vo) {
		MovieDTO dto = new MovieDTO();
		dto = mapper.convertVO(vo);
		movieDAO.save(dto);

	}

	@Override
	public void deleteMovie(String movieName) {
		Optional<MovieDTO> movie = movieDAO.findByMovieName(movieName);
		if (movie.isPresent()) {
			movieDAO.delete(movie.get());
		}
	}

}
