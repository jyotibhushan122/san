package org.movie.mapper;

import java.io.IOException;
import java.util.function.Consumer;

import org.movie.dto.MovieDTO;
import org.movie.vo.MovieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

	public MovieDTO mapMovieVoToMovieDTO(MovieVO vo) throws Exception {
		MovieDTO dto = new MovieDTO();
		BeanUtils.copyProperties(vo, dto);
		try {
			if (vo.getImg() == null || !vo.getImg().getContentType().startsWith("image"))
				throw new Exception("please pass movie image");

			dto.setData(vo.getImg().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public MovieDTO convertVO(MovieVO vo) {
		MovieVO movieVO = new MovieVO();
		MovieDTO dto = new MovieDTO();
		funPoint(vo.getMovieName(), dto::setMovieName);
		funPoint(vo.getDescription(), dto::setDescription);
		funPoint(vo.getTitle(), dto::setTitle);
		return dto;
	}

	public <T> void funPoint(T value, Consumer<T> consumer) {
		if (value != null) {
			consumer.accept(value);
		}

	}
}
