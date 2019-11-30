package org.movie.controller;

import org.movie.service.MovieUploadService;
import org.movie.util.GateWayResponse;
import org.movie.vo.MovieVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class MovieController {
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieUploadService service;

	@PostMapping(value = "/uploadData", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> uploadlFileNew(@ModelAttribute MovieVO upld) {

		try {
			service.uploadMovie(upld);
			logger.info("UPLOAD SUCCESS with referenece NUMBER [{}]");
			return new GateWayResponse<>(Boolean.TRUE, HttpStatus.OK, "Upload success");
		} catch (Exception e) {
			logger.info("Exception in FileUpload [{}]", e);
			return new GateWayResponse<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

}
