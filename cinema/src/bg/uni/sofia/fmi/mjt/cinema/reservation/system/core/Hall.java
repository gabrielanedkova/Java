package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

public class Hall {

	private int number;
	private int rows;
	private int rowSeats;

	public Hall(int number, int rows, int rowSeats) {
		this.number = number;
		this.rows = rows;
		this.rowSeats = rowSeats;
	}

	public int getRows() {
		return rows;
	}

	public int getRowSeats() {
		return rowSeats;
	}

	public boolean hasSeat(Seat seat) {
		return (seat.getRow() <= rows && seat.getSeat() <= rowSeats);

	}

	public int getSeats() {
		return rows * rowSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		if (number != other.number)
			return false;
		return true;
	}
}
