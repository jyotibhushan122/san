package org.movie.constent;

public class QueryReport {

	public static final String REPORT_GEN = "select count(case when t1.is_seat_booked=true then 1 else null end) as seat_booked,\r\n"
			+ "count(case when t1.is_seat_booked=false then 1 else null end) as seat_not_booked,\r\n"
			+ "sum(case when t1.is_seat_booked=true then 1 else null end * t1.ammount) as total_revenue,\r\n"
			+ "sum(case when t1.is_seat_booked=false then 1 else null end * t1.ammount) as total_loss,t1.slot_date\r\n"
			+ "from tbl_seat t1 where t1.slot_date between ? and ? group by t1.slot_date;";
}
