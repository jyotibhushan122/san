package org.movie.dao;

import java.util.Optional;

import org.movie.dto.MovieDTO;
import org.movie.vo.MovieVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends JpaRepository<MovieDTO, MovieVO> {

	Optional<MovieDTO> findByMovieName(String movieName);

	Optional<MovieDTO> findById(Long id);

}
