package org.movie.dao;

import java.util.List;

import org.movie.dto.ScreenDTO;
import org.movie.dto.SeatDTO;
import org.movie.vo.SeatVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDao extends CrudRepository<SeatDTO, SeatVo> {
	List<SeatDTO> findAllByScreenIdIn(List<ScreenDTO> dto);
}
