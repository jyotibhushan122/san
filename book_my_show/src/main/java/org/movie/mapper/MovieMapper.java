package org.movie.mapper;

import java.io.IOException;

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
}
