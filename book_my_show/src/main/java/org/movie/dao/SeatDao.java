package org.movie.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.movie.constent.QueryReport;
import org.movie.dto.ScreenDTO;
import org.movie.dto.SeatDTO;
import org.movie.vo.SeatVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDao extends CrudRepository<SeatDTO, SeatVo> {

	List<SeatDTO> findAllByScreenIdInAndSlotDate(List<ScreenDTO> dto, LocalDate slotDate);

	@Query(value = QueryReport.REPORT_GEN, nativeQuery = true)
	List<Object[]> genReport(LocalDate fromDate, LocalDate toDate);

	Optional<SeatDTO> findById(Long id);
}
