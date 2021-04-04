import java.util.Scanner;

/*
 * This class represents a reservable item that is a boat. It has no instance variables, but it
 * does have a constructor that takes a Scanner object as an argument, as well as the method
 * "getFitnessValue(Reservation)" to return the fitness value between the calling Boat and the
 * argument Reservation.
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class Boat extends ReservableItem {

	// Constructor. Uses a Scanner object as an argument.
	public Boat(Scanner inFile) {
		super();
		super.setID(inFile.nextLine());
		System.out.println("Adding Boat type: " + this.getId());
	}

	/*
	 * This method is used to return a fitnessValue. First the argument is checked
	 * to make sure that it is not null and is an instance of BoatResevation. If it
	 * is not then a ClassCastException is thrown. If it is a good object, then it
	 * is cast to BoatReservation, and used as an argument for BoatReservation copy
	 * constructor which creates the object "other". After that the preferences are
	 * compared from other to the calling object. The number returned is based on
	 * where the calling object is on the preference list. If it is the first then
	 * zero is returned showing a perfect Fitness, if it is the second object on the
	 * list then a one is returned, etc. If it is not on the list them a bestFit
	 * value of 100 is returned, showing that this object is not a wanted Boat.
	 */
	public int getFitnessValue(Reservation res) throws ClassCastException {
		int bestFit = 100;
		if (res == null || !(res instanceof BoatReservation)) {
			throw new ClassCastException();
		} else {
			BoatReservation other = new BoatReservation((BoatReservation) res);

			for (int i = 0; i < other.getPreferenceSize(); i++) {
				if (this.getId().equals(other.getPreferences().get(i))) {
					bestFit = i;
				}
			}
		}
		return bestFit;
	}
}
