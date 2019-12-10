package org.movie.serviceImpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.movie.dao.MovieDAO;
import org.movie.dao.SeatDao;
import org.movie.dto.MovieDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.MovieService;
import org.movie.vo.MovieVO;
import org.movie.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper mapper;

	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private SeatDao seatDao;

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

	@Override
	public List<ReportVo> genReport(LocalDate fromDate, LocalDate toDate) {
		List<Object[]> listDate = seatDao.genReport(fromDate, toDate);
		List<ReportVo> reportList = new ArrayList<>();
		listDate.forEach(r -> {
			ReportVo vo = new ReportVo();
			if (r[0] != null)
				vo.setSeat_booked(new BigInteger(r[0].toString()).longValue());
			if (r[1] != null)
				vo.setSeat_not_booked(new BigInteger(r[1].toString()).longValue());
			if (r[2] != null)
				vo.setTotal_revenue(new BigInteger(r[2].toString()).longValue());
			if (r[3] != null)
				vo.setTotal_loss(new BigInteger(r[3].toString()).longValue());
			if (r[4] != null)
				vo.setBookingDate(LocalDate.parse(r[4].toString()));
			reportList.add(vo);
		});
		return reportList;

	}

}
