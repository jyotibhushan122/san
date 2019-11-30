package org.movie.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.constent.ScreenConstent;
import org.movie.constent.SeatStatus;
import org.movie.constent.SeatType;
import org.movie.constent.TimeConstent;
import org.movie.dao.ScreenDAO;
import org.movie.dao.SeatDao;
import org.movie.dao.TheaterDAO;
import org.movie.dto.ScreenDTO;
import org.movie.dto.SeatDTO;
import org.movie.dto.TheaterDTO;
import org.movie.service.TheaterService;
import org.movie.vo.TheaterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;
	@Autowired
	private ScreenDAO screenDao;
	@Autowired
	private SeatDao seatDao;

	@Override
	public List<TheaterVO> getTheaters() {
		List<TheaterVO> theatersVO = new ArrayList<>();
		List<TheaterDTO> theaters = theaterDAO.findAll();
		BeanUtils.copyProperties(theaters, theatersVO);
		return theatersVO;
	}

	private ScreenDTO screenSave = null;

	@Override
	public void addScreen() {
		theaterDAO.findAll().forEach(t -> {
			Arrays.asList(ScreenConstent.values()).forEach(s -> {

				time().forEach((k, v) -> {
					ScreenDTO screen = new ScreenDTO();

					screen.setTheaterId(t);
					screen.setScreenName(s.toString());
					screen.setScreen(s);
					screen.setShowProfile(k);
					screen.setTime(v);
					screenSave = screenDao.save(screen);

				});
				genSeat(t, s, screenSave);
			});
		});
	}

	private void genSeat(TheaterDTO t, ScreenConstent s, ScreenDTO screen) {
		List<SeatDTO> listOfSeatDTO = new ArrayList<>();
		for (int i = 0; i < t.getSeatNumber(); i++) {
			SeatDTO seatDto = new SeatDTO();
			seatDto.setScreenId(screen);
			seatDto.setSeatStatus(SeatStatus.SEAT_NOT_BOOKED);
			seatDto.setNumber(i);
			setSeatType(i, seatDto);
			listOfSeatDTO.add(seatDto);
		}
		seatDao.saveAll(listOfSeatDTO);

	}

	public void setSeatType(int i, SeatDTO seatDto) {
		if (0 <= i && i >= 10) {
			seatDto.setSeries("A");
			seatDto.setSeatType(SeatType.NORMAL.toString());
			seatDto.setAmmount(SeatType.NORMAL.getPrice());
		} else if (11 <= i && i >= 20) {
			seatDto.setSeries("B");
			seatDto.setSeatType(SeatType.EXECUTIVE.toString());
			seatDto.setAmmount(SeatType.EXECUTIVE.getPrice());
		} else if (21 <= i && i >= 30) {
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

}
