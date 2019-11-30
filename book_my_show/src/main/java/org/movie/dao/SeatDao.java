package org.movie.dao;

import org.movie.dto.SeatDTO;
import org.movie.vo.SeatVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDao extends CrudRepository<SeatDTO, SeatVo> {

}
