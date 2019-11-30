package org.movie.dao;

import org.movie.dto.MovieDTO;
import org.movie.vo.MovieVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends JpaRepository<MovieDTO, MovieVO> {

}
