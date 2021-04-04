import java.util.ArrayList;

/*
 * This class is used to create reservations for Boat items. It inherits from Reservation, and has
 * an instance ArrayList of Strings called "preference". It also has two constructors, one that 
 * takes and int and String, and another that is a copy constructor. It also has the methods
 * "getPreferences()" which returns a deep copy of the ArrayList preference, a "getPreferenceSize()"
 * method that returns an int  that is the length of preference, and finally a "addBoatPreference(String)"
 * to add the names of boats that the reservation would like. 
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class BoatReservation extends Reservation {
	private ArrayList<String> preference = new ArrayList<>();

	// Two argument constructor. Takes an int and String as arguments.
	public BoatReservation(int timeSlot, String customerName) {
		super(customerName, timeSlot);
	}

	// Copy constructor.
	public BoatReservation(BoatReservation other) {
		super(other.getCustomer(), other.getTime());
		for (int i = 0; i < other.preference.size(); i++) {
			this.preference.add(other.preference.get(i));
		}
	}

	// Returns a deep copy of the ArrayList preference.
	public ArrayList<String> getPreferences() {
		ArrayList<String> returnArray = new ArrayList<>();
		for (int i = 0; i < preference.size(); i++) {
			returnArray.add(this.preference.get(i));
		}
		return returnArray;
	}

	// Returns the size of preference.
	public int getPreferenceSize() {
		return this.preference.size();
	}

	// Adds a string to the ArrayList preference.
	public void addBoatPreference(String boatName) {
		this.preference.add(boatName);
	}
}
