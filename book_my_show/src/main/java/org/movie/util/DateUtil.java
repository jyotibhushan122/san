package org.movie.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {

	public long getGapBetweenTwoDays(LocalDate fromDate, LocalDate toDate) {
		return ChronoUnit.DAYS.between(fromDate, toDate);
	}
}
