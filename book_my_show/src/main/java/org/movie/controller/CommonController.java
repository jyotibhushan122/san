package org.movie.controller;

import java.util.Arrays;
import java.util.List;

import org.movie.constent.ScreenConstent;
import org.movie.service.TheaterService;
import org.movie.util.GateWayResponse;
import org.movie.vo.MovieVO;
import org.movie.vo.ResponseVo;
import org.movie.vo.TheaterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/common_data")
@CrossOrigin
public class CommonController {
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	private TheaterService theaterService;

	@GetMapping("/getTheatre")
	public GateWayResponse<?> getAllTheatres() {
		try {
			List<TheaterVO> list = theaterService.getTheaters();
			return (CollectionUtils.isEmpty(list)) ? new GateWayResponse<>(HttpStatus.OK, "NO_CONTENT")
					: new GateWayResponse<>(HttpStatus.OK, list, "Upload success");

		} catch (Exception e) {
			logger.info("Exception in addTheatres [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/screens")
	public GateWayResponse<?> getScreene() {
		return new GateWayResponse<>(HttpStatus.OK,
				Arrays.asList(ScreenConstent.SCREEN1.toString(), ScreenConstent.SCRREN2.toString(),
						ScreenConstent.SCREEN3.toString(), ScreenConstent.SCREEN4.toString()),
				"success");
	}

	@GetMapping("/timings")
	public GateWayResponse<?> getTimings() {
		return new GateWayResponse<>(HttpStatus.OK, theaterService.time(), "success");

	}

	// getScreenForBooked

	@PostMapping("/getScreenForBooked")
	public GateWayResponse<?> getScreenForBooked(@RequestBody MovieVO vo) {

		try {
			List<ResponseVo> response = theaterService.getScreenForBooked(vo);
			return (CollectionUtils.isEmpty(response)) ? new GateWayResponse<>(HttpStatus.OK, "NO_CONTENT")
					: new GateWayResponse<>(HttpStatus.OK, response, "Upload success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GateWayResponse<>(HttpStatus.OK, theaterService.time(), "success");

	}
}
