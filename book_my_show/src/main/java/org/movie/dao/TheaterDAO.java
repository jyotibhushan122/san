package org.movie.dao;

import java.util.Optional;

import org.movie.dto.TheaterDTO;
import org.movie.vo.TheaterVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterDAO extends JpaRepository<TheaterDTO, TheaterVO> {
	boolean existsById(Long id);

	Optional<TheaterDTO> findById(long id);
}
