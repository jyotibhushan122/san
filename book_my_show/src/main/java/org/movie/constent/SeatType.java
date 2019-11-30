package org.movie.constent;

public enum SeatType {
	NORMAL(150), EXECUTIVE(200), PREMIUM(250), VIP(500);
	int price;

	private SeatType(int price) {
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
