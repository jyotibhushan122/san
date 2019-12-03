package org.movie.controller;

import java.util.List;

import org.movie.service.MovieService;
import org.movie.service.MovieUploadService;
import org.movie.service.TheaterService;
import org.movie.util.GateWayResponse;
import org.movie.vo.MovieVO;
import org.movie.vo.TheaterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin_page")
@CrossOrigin
public class MovieController {
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieUploadService service;
	@Autowired
	private TheaterService theaterService;

	@Autowired
	private MovieService movieService;

	@PostMapping(value = "/addMovie", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> uploadlFileNew(@ModelAttribute MovieVO upld) {

		try {
			logger.info("UPLOAD SUCCESS with referenece NUMBER [{}]");
			return new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, service.uploadMovie(upld));
		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}// getAllMovie

	@GetMapping(value = "/getListOfMovie", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> getListOfMovie(@RequestParam(name = "field", required = false) String field) {

		try {
			List<MovieVO> list = service.getAllMovie(field);

			return (CollectionUtils.isEmpty(list)) ? new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, "NO_CONTENT")
					: new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, list);

		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PostMapping("/addTheatre")
	public GateWayResponse<?> addTheatres(@RequestBody TheaterVO vo) {
		try {
			theaterService.addTheater(vo);
			return new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, "Upload success");
		} catch (Exception e) {
			logger.info("Exception in addTheatres [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PostMapping("/mapMovieToScreen")
	public GateWayResponse<?> mapTheaterToIndex(@RequestBody MovieVO vo) {
		try {
			theaterService.addMovieToScreen(vo);
			return new GateWayResponse<>(HttpStatus.OK, "add success");
		} catch (Exception e) {
			logger.info("Exception in addTheatres [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/deleteMovie")
	public GateWayResponse<?> deleteMovie(@RequestParam("movieName") String movieName) {
		movieService.deleteMovie(movieName);
		return new GateWayResponse<>(HttpStatus.OK, "delete success");
	}

}
