package org.movie.controller;

import java.time.LocalDate;
import java.util.List;

import org.movie.service.MovieService;
import org.movie.service.TheaterService;
import org.movie.util.GateWayResponse;
import org.movie.vo.MovieVO;
import org.movie.vo.ReportVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@CrossOrigin
public class Citizen {
	// getScreenForBooked
	private Logger logger = LoggerFactory.getLogger(Citizen.class);

	@Autowired
	private TheaterService theaterService;
	@Autowired
	private MovieService movieService;

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

	}// genReport

	@GetMapping(value = "/genReport", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> genReport(
			@RequestParam(name = "fromDate") @JsonFormat(pattern = "yyyy-MM-dd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam(name = "toDate") @JsonFormat(pattern = "yyyy-MM-dd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {

		try {

			List<ReportVo> report = movieService.genReport(fromDate, toDate);
			return (CollectionUtils.isEmpty(report)) ? new GateWayResponse<>(HttpStatus.NO_CONTENT, "No_CONTENT")
					: new GateWayResponse<>(HttpStatus.OK, report, "SUCCES");

		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

}
