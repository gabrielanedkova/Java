package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

import java.time.LocalDateTime;

public class Projection {

	private Movie movie;
	private Hall hall;
	private LocalDateTime dateTime;
	private int freeSeats;

	public Projection(Movie movie, Hall hall, LocalDateTime date) {
		this.movie = movie;
		this.hall = hall;
		this.dateTime = date;
		freeSeats = hall.getSeats();
	}

	public Hall getHall() {
		return hall;
	}

	public Movie getMovie() {
		return movie;
	}

	public LocalDateTime getDate() {
		return dateTime;
	}

	public int getFreeSeatsNumber() {
		return freeSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
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
		Projection other = (Projection) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (hall == null) {
			if (other.hall != null)
				return false;
		} else if (!hall.equals(other.hall))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}

	public boolean hasSeat(Seat seat) {
		return hall.hasSeat(seat);
	}

	public void freeSeat() {
		++freeSeats;

	}

	public void takeSeat() {
		--freeSeats;

	}

}
