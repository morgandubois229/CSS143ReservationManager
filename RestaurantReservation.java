
/*
 * This class inherits from Reservation, and is used when creating a reservation for a Table.
 * It has the instance variable "numSeatsNeeded" of type int, which is used for how many seats
 * a reservation will need. It also has three constructors, The first two are both three argument
 * constructors, which take a String and two ints, but their signatures are different due to the driver
 * we were given calling them one way, and the assignment instructions giving the signature another. 
 * The third constructor is a copy constructor. This class also has the methods "getNumSeatsNeeded()"
 * which returns numSeatsNeeded, and an override "toString()" method, which prints out the reservation.
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class RestaurantReservation extends Reservation {

	private int numSeatsNeeded;

	// Constructor based on the signature given to us by the Word document.
	public RestaurantReservation(String name, int startTime, int numSeatsNeeded) {
		super(name, startTime);
		this.numSeatsNeeded = numSeatsNeeded;
	}

	// Constructor based on the signature used in the RestaurantDriver.
	public RestaurantReservation(int numSeatsNeeded, int startTime, String name) {
		super(name, startTime);
		this.numSeatsNeeded = numSeatsNeeded;
	}

	// Copy constructor.
	public RestaurantReservation(RestaurantReservation other) {
		super((Reservation) other);
		this.numSeatsNeeded = other.numSeatsNeeded;
	}

	// Returns number of seats needed by the reservation.
	public int getNumSeatsNeeded() {
		return this.numSeatsNeeded;
	}

	// Override toString. Prints out the numSeatsNeeded.
	@Override
	public String toString() {
		return super.toString() + " customer seats: " + numSeatsNeeded;
	}

}
