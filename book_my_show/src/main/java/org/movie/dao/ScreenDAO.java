package org.movie.dao;

import java.util.List;
import java.util.Optional;

import org.movie.dto.ScreenDTO;
import org.movie.dto.TheaterDTO;
import org.movie.vo.ScreenVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenDAO extends CrudRepository<ScreenDTO, ScreenVO> {
	boolean existsById(Long id);

	Optional<ScreenDTO> findById(Long id);

	List<ScreenDTO> findAllByTheaterIdAndMovieId(TheaterDTO dto, Long movieId);
}
