package org.movie.mapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import org.movie.dto.MovieDTO;
import org.movie.dto.ScreenDTO;
import org.movie.dto.SeatDTO;
import org.movie.dto.TheaterDTO;
import org.movie.vo.MovieVO;
import org.movie.vo.ScreenVO;
import org.movie.vo.SeatVo;
import org.movie.vo.TheaterVO;
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
			dto.setFileName(vo.getImg().getOriginalFilename());
			dto.setFileContentType(vo.getImg().getContentType());
			dto.setCreadtedDate(LocalDateTime.now());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public MovieVO mapMovieDtoToVO(MovieDTO dto, String field) {
		MovieVO vo = new MovieVO();

		BeanUtils.copyProperties(dto, vo);
		if (field == null)
			vo.setData(null);
		return vo;
	}

	public MovieDTO convertVO(MovieVO vo) {
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

	public TheaterDTO thaterMapperVoToDto(TheaterVO vo) {
		TheaterDTO dto = new TheaterDTO();
		BeanUtils.copyProperties(vo, dto);
		return dto;
	}

	public TheaterVO thaterMapperDtoToVo(TheaterDTO vo) {
		TheaterVO dto = new TheaterVO();
		BeanUtils.copyProperties(vo, dto);
		return dto;
	}

	public ScreenVO getMapScreenDtoToVo(ScreenDTO dto) {
		ScreenVO vo = new ScreenVO();
		BeanUtils.copyProperties(dto, vo);
		return vo;

	}

	public SeatVo getMapSeatDtoToVo(SeatDTO dto) {
		SeatVo vo = new SeatVo();
		BeanUtils.copyProperties(dto, vo);
		return vo;
	}
}
