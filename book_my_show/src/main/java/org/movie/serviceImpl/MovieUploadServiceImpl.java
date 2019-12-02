package org.movie.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.movie.dao.MovieDAO;
import org.movie.dao.ScreenDAO;
import org.movie.dto.MovieDTO;
import org.movie.dto.ScreenDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.MovieUploadService;
import org.movie.util.DateUtil;
import org.movie.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieUploadServiceImpl implements MovieUploadService {
	@Autowired
	private MovieDAO movierepo;
	@Autowired
	private ScreenDAO screenDao;
	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private DateUtil dateUtil;

	@Override
	public long uploadMovie(MovieVO vo) throws Exception {
		MovieDTO dto = movierepo.save(movieMapper.mapMovieVoToMovieDTO(vo));
		return dto.getId();
	}

	@Override
	public List<MovieVO> getAllMovie() {
		return movierepo.findAll().stream()
				.filter(f -> dateUtil.getGapBetweenTwoDays(LocalDate.now(), f.getValidTo()) > 1)
				.collect(Collectors.toList()).stream().map(m -> movieMapper.mapMovieDtoToVO(m))
				.collect(Collectors.toList());
	}

	@Override
	public void bookMovie() {

	}

	@Override
	public void addMovieToScreen(MovieVO vo) throws Exception {
		Optional<ScreenDTO> screen = screenDao.findById(vo.getScreenId());

		if (screen.isPresent() && screen.get().getTheaterId().getId() == vo.getTheaterId()) {
			Optional<MovieDTO> movie = movierepo.findById(vo.getId());
			screen.get().setMovieId(movie.get().getId());
			screen.get().setValidFrom(vo.getValidFrom());
			screen.get().setValidTo(vo.getValidTo());
			screenDao.save(screen.get());

		} else {
			throw new Exception("screen not valid.");
		}

	}

}
