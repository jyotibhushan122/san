package org.movie.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.movie.constent.ScreenConstent;
import org.movie.constent.SeatStatus;
import org.movie.constent.SeatType;
import org.movie.constent.TimeConstent;
import org.movie.dao.MovieDAO;
import org.movie.dao.ScreenDAO;
import org.movie.dao.SeatDao;
import org.movie.dao.TheaterDAO;
import org.movie.dto.MovieDTO;
import org.movie.dto.ScreenDTO;
import org.movie.dto.SeatDTO;
import org.movie.dto.TheaterDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.TheaterService;
import org.movie.util.DateUtil;
import org.movie.vo.MovieVO;
import org.movie.vo.ResponseVo;
import org.movie.vo.SeatVo;
import org.movie.vo.TheaterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;
	@Autowired
	private ScreenDAO screenDao;
	@Autowired
	private SeatDao seatDao;
	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private MovieDAO movieDao;
	@Autowired
	private DateUtil dateUtil;

	@Override
	public List<TheaterVO> getTheaters() {
		return theaterDAO.findAll().stream().map(r -> movieMapper.thaterMapperDtoToVo(r)).collect(Collectors.toList());
	}

	@Override
	public void addScreen(MovieVO vo, TheaterDTO dto, List<ScreenConstent> screenContent) {
		Arrays.asList(dto).forEach(t -> {
			screenContent.forEach(s -> {

				time().forEach((k, v) -> {
					ScreenDTO screen = new ScreenDTO();

					screen.setTheaterId(t);
					screen.setScreenName(s.toString());
					screen.setScreen(s);
					screen.setShowProfile(k);
					screen.setMovieId(vo.getId());
					screen.setTime(v);
					screen.setValidFrom(vo.getValidFrom());
					screen.setValidTo(vo.getValidTo());
					ScreenDTO screenSave = screenDao.save(screen);
					genSeat(t, screenSave);
				});
			});
		});
	}

	private void genSeat(TheaterDTO t, ScreenDTO screen) {
		List<SeatDTO> listOfSeatDTO = new ArrayList<>();

		for (long date = 0; date < dateUtil.getGapBetweenTwoDays(screen.getValidFrom(), screen.getValidTo()); date++) {
			for (int i = 0; i < t.getSeatNumber(); i++) {
				SeatDTO seatDto = new SeatDTO();
				seatDto.setScreenId(screen);
				seatDto.setSeatStatus(SeatStatus.SEAT_NOT_BOOKED.toString());
				seatDto.setNumber(i);
				seatDto.setBooked(Boolean.FALSE);
				setSeatType(i, seatDto);
				seatDto.setSlotDate(screen.getValidFrom().plusDays(date));
				seatDto.setCreadtedDate(LocalDateTime.now());
				seatDto.setShowProfile(screen.getShowProfile());
				seatDto.setScreen(screen.getScreen());
				listOfSeatDTO.add(seatDto);
			}
		}

		seatDao.saveAll(listOfSeatDTO);

	}

	public void setSeatType(int i, SeatDTO seatDto) {
		if (0 <= i && i < 10) {
			seatDto.setSeries("A");
			seatDto.setSeatType(SeatType.NORMAL.toString());
			seatDto.setAmmount(SeatType.NORMAL.getPrice());
		} else if (11 <= i && i < 20) {
			seatDto.setSeries("B");
			seatDto.setSeatType(SeatType.EXECUTIVE.toString());
			seatDto.setAmmount(SeatType.EXECUTIVE.getPrice());
		} else if (21 <= i && i < 30) {
			seatDto.setSeries("C");
			seatDto.setSeatType(SeatType.PREMIUM.toString());
			seatDto.setAmmount(SeatType.PREMIUM.getPrice());
		} else {
			seatDto.setSeries("D");
			seatDto.setSeatType(SeatType.VIP.toString());
			seatDto.setAmmount(SeatType.VIP.getPrice());
		}

	}

	@Override
	public Map<String, String> time() {
		Map<String, String> time = new HashMap<>();
		Arrays.asList(TimeConstent.values()).forEach(r -> {
			time.put(r.toString(), r.getStartTime() + " - " + r.getEndTime());
		});

		return time;
	}

	@Override
	public void addTheater(TheaterVO vo) throws Exception {
		theaterDAO.save(movieMapper.thaterMapperVoToDto(vo));
	}

	@Override
	public void addMovieToScreen(MovieVO vo) throws Exception {
		Optional<TheaterDTO> theaterDto = theaterDAO.findById(vo.getTheaterId());
		Optional<MovieDTO> dto = movieDao.findById(vo.getId());
		List<ScreenConstent> screenContent = Arrays.asList(ScreenConstent.values()).stream()
				.filter(s -> s.toString().equals(vo.getScreenName())).collect(Collectors.toList());

		if (theaterDto.isPresent() && dto.isPresent() && !CollectionUtils.isEmpty(screenContent))
			addScreen(vo, theaterDto.get(), screenContent);
		else {
			throw new Exception("Please pass valid data");
		}

	}

	@Override
	public List<ResponseVo> getScreenForBooked(MovieVO vo) throws Exception {
		Optional<TheaterDTO> thDto = theaterDAO.findById(vo.getTheaterId());
		if (!thDto.isPresent())
			throw new Exception("Theater Data not valid");
		List<ScreenDTO> dto = screenDao.findAllByTheaterIdAndMovieId(thDto.get(), vo.getId());
		List<SeatDTO> seatDto = seatDao
				.findAllByScreenIdIn(screenDao.findAllByTheaterIdAndMovieId(thDto.get(), vo.getId()));

		if (CollectionUtils.isEmpty(dto))
			throw new Exception("Screens Not find");
		if (CollectionUtils.isEmpty(seatDto))
			throw new Exception("Seat Not found");
		List<ResponseVo> responseVo = new ArrayList<>();
		dto.forEach(r -> {
			ResponseVo response = new ResponseVo();
			response.setScreen(movieMapper.getMapScreenDtoToVo(r));
			List<SeatVo> seat = seatDto.stream().filter(f -> f.getScreenId().getId() == r.getId())
					.map(m -> movieMapper.getMapSeatDtoToVo(m)).collect(Collectors.toList());
			response.setSeatVo(seat);
			responseVo.add(response);
		});
		return responseVo;
	}

}
