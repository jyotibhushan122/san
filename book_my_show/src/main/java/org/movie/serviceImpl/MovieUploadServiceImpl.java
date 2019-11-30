package org.movie.serviceimpl;

import java.util.Optional;

import org.movie.dao.MovieDAO;
import org.movie.dao.ScreenDAO;
import org.movie.dao.TheaterDAO;
import org.movie.dto.MovieDTO;
import org.movie.dto.ScreenDTO;
import org.movie.mapper.MovieMapper;
import org.movie.service.MovieUploadService;
import org.movie.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieUploadServiceImpl implements MovieUploadService {
	@Autowired
	private MovieDAO movierepo;
	@Autowired
	private TheaterDAO theaterDao;
	@Autowired
	private ScreenDAO screenDao;
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public void uploadMovie(MovieVO vo) throws Exception {
		Optional<ScreenDTO> screeData = screenDao.findById(vo.getScreenId());
		if (screeData.isPresent() && screeData.get().getTheaterId().getId() == vo.getTheaterId()) {
			MovieDTO dto = movierepo.save(movieMapper.mapMovieVoToMovieDTO(vo));
			screeData.get().setMovieId(dto);
			screenDao.save(screeData.get());
		} else {
			throw new Exception("Invalid screen");
		}
	}

	@Override
	public void bookMovie() {

	}

}
