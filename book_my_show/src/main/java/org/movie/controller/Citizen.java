package org.movie.controller;

import org.movie.service.TheaterService;
import org.movie.util.GateWayResponse;
import org.movie.vo.MovieVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Citizen {
	// getScreenForBooked
	private Logger logger = LoggerFactory.getLogger(Citizen.class);

	@Autowired
	private TheaterService theaterService;

	@PostMapping(value = "/getListOfMovie", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> getListOfMovie(@RequestBody MovieVO vo) {

		try {
			return new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, theaterService.getScreenForBooked(vo));
		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}// getScreenForBooked

	@PostMapping(value = "/getScreenForBooked", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> getScreenForBooked(@RequestBody MovieVO vo) {

		try {
			return new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, theaterService.getScreenForBooked(vo));
		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

}
