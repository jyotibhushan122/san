package org.movie.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.constent.ScreenConstent;
import org.movie.constent.TimeConstent;
import org.movie.dao.ScreenDAO;
import org.movie.dao.TheaterDAO;
import org.movie.dto.ScreenDTO;
import org.movie.dto.TheaterDTO;
import org.movie.service.TheaterService;
import org.movie.vo.TheaterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterDAO theaterDAO;
	@Autowired
	private ScreenDAO screenDao;

	@Override
	public List<TheaterVO> getTheaters() {
		List<TheaterVO> theatersVO = new ArrayList<>();
		List<TheaterDTO> theaters = theaterDAO.findAll();
		BeanUtils.copyProperties(theaters, theatersVO);
		return theatersVO;
	}

	@Override
	public void addScreen() {

		List<ScreenDTO> listOfScreen = new ArrayList<>();
		theaterDAO.findAll().forEach(t -> {
			Arrays.asList(ScreenConstent.values()).forEach(s -> {
				time().forEach((k, v) -> {
					ScreenDTO screen = new ScreenDTO();
					screen.setTheaterId(t);
					screen.setScreenName(s.toString());
					screen.setScreen(s);
					screen.setShowProfile(k);
					screen.setTime(v);
					listOfScreen.add(screen);
				});
			});
		});
		if (!CollectionUtils.isEmpty(listOfScreen)) {
			screenDao.saveAll(listOfScreen);
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
