package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

public class Ticket {

	private Projection projection;
	private Seat seat;
	private String owner;

	public Ticket(Projection projection, Seat seat, String owner) {
		this.projection = projection;
		this.seat = seat;
		this.owner = owner;
	}

	public Projection getProjection() {
		return projection;
	}

	public Seat getSeat() {
		return seat;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (projection == null) {
			if (other.projection != null)
				return false;
		} else if (!projection.equals(other.projection))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projection == null) ? 0 : projection.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}
}
