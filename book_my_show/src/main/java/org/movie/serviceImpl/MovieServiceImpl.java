package org.movie.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.movie.constent.SeatStatus;
import org.movie.dao.MovieDAO;
import org.movie.dao.SeatDao;
import org.movie.dto.MovieDTO;
import org.movie.dto.SeatDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.MovieService;
import org.movie.vo.MovieVO;
import org.movie.vo.ReportVo;
import org.movie.vo.SeatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper mapper;
	
	@Autowired
	private MovieDAO movieDAO; 
	
	@Autowired
	private SeatDao seatDAO;
	
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
	public SeatVo updateStatus(MovieVO movieVo) {
		Optional<SeatDTO> seatDTO = seatDAO.findBySeatId(movieVo.getSeatId());
		if (seatDTO.get().isBookedStatus()) 
			throw new Exception("seat already booked");
		seatDTO.get().setTxId(UUID.randomUUID().toString());
		seatDTO.get().setBookedStatus(Boolean.TRUE);
		seatDTO.get().setSeatStatus(SeatStatus.SEAT_BOOKED);
		seatDTO.get().setBookedDate(LocalDate.now());
		seatDAO.save(seatDTO.get());
		return mapper.getMapSeatDtoToVo(seatDTO.get());
	}

	@Override
	public List<ReportVo> genReport(LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
