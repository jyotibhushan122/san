package org.movie.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class ReportVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long seat_booked;
	private Long seat_not_booked;
	private Long total_revenue;
	private Long total_loss;
	private LocalDate bookingDate;

	public Long getSeat_booked() {
		return seat_booked;
	}

	public void setSeat_booked(Long seat_booked) {
		this.seat_booked = seat_booked;
	}

	public Long getSeat_not_booked() {
		return seat_not_booked;
	}

	public void setSeat_not_booked(Long seat_not_booked) {
		this.seat_not_booked = seat_not_booked;
	}

	public Long getTotal_revenue() {
		return total_revenue;
	}

	public void setTotal_revenue(Long total_revenue) {
		this.total_revenue = total_revenue;
	}

	public Long getTotal_loss() {
		return total_loss;
	}

	public void setTotal_loss(Long total_loss) {
		this.total_loss = total_loss;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

}
