package org.movie.dao;

import org.movie.dto.ScreenDTO;
import org.movie.vo.ScreenVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenDAO extends JpaRepository<ScreenDTO, ScreenVO> {

}
