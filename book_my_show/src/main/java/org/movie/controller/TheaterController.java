package org.movie.controller;

import org.movie.service.MovieService;
import org.movie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private MovieService movieService;

}
