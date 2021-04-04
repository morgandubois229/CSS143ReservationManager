import java.util.Scanner;

/*
 * This class inherits from ReservableItem and is used to represent a Table. It has
 * an instance variable of type int called "numSeats" as well as a constructor that
 * takes a Scanner object as an argument, and the methods "getNumSeats()" which represents
 * the number of seats a Table object has, as well as the "getFitnessValue(Reservation)"
 * which returns an int value describing how well the calling object matches the requirements
 * for the Reservation object used as an argument. 
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class Table extends ReservableItem {
	private int numSeats;

	// Constructor which uses Scanner object as argument.
	public Table(Scanner inFile) {
		super(inFile);
		this.numSeats = inFile.nextInt();
	}

	// Returns the number of seats.
	public int getNumSeats() {
		return numSeats;
	}

	/*
	 * Returns the fitness value of the item. It first makes sure that the
	 * Reservation object is not null, and it is an instance of
	 * RestaurantReservation. It throws a ClassCastException if either of these two
	 * things are true. If they are not then it casts res to RestaurantReservation
	 * and uses it as an argument for a copy constructor of class
	 * RestaurantReservation called theRes. Then the number of seats needed by
	 * theRed is subtracted from the calling object numSeats, and that value is
	 * returned.
	 */
	public int getFitnessValue(Reservation res) throws ClassCastException {
		if (res == null || !(res instanceof RestaurantReservation)) {
			throw new ClassCastException();
		} else {
			RestaurantReservation theRes = new RestaurantReservation((RestaurantReservation) res);
			return this.numSeats - theRes.getNumSeatsNeeded();
		}
	}
}
