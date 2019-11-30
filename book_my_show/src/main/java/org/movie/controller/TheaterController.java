package org.movie.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.constent.ScreenConstent;
import org.movie.constent.TimeConstent;
import org.movie.service.MovieService;
import org.movie.service.TheaterService;
import org.movie.vo.MovieVO;
import org.movie.vo.TheaterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private MovieService movieService;

	@GetMapping("/theatre")
	public List<TheaterVO> getAllTheatres() {
		List<TheaterVO> theaters = theaterService.getTheaters();
		return theaters;
	}

	@GetMapping("/screens")
	public List<String> getScreene() {
		return Arrays.asList(ScreenConstent.SCREEN1.toString(), ScreenConstent.SCRREN2.toString(),
				ScreenConstent.SCREEN3.toString(), ScreenConstent.SCREEN4.toString());
	}

	@GetMapping("/timings")
	public Map<String, String> getTimings() {
		return theaterService.time();
	}

	@PostMapping("/addMovie")
	public String addMovie(MovieVO vo) {
		movieService.addMovie(vo);
		return "sucess";

	}

	@GetMapping("/deleteMovie")
	public String deleteMovie(@RequestParam("movieName") String movieName) {
		movieService.deleteMovie(movieName);
		return "sucess";
	}

}
