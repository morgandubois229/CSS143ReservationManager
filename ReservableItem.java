import java.util.Scanner;

/*
 * This  abstract class is used to represent an Item that can be reserved. It has the instance variable 
 * String called "id" as well as the boolean array called "times". id is used to represent the objects name,
 * and times is an array that is always initialized with a length of 10 spaces, all set to false. times
 * is then updates at specific indexes to true if that position is taken. This class has two constructors,
 * a no argument constructor and a constructor that takes a scanner object in as an argument. It also has
 * "getId()" which returns the id of the object, an abstract method "getFitnessValue()" which is further
 * defined in classes that inherits from this one, a "getTimeArray()" that returns a deep copy of times
 * so that it can be searched without any data accidentally being changed. A "timeTaken(int)" to change
 * a specific index of times from "false" to "true". And finally a "setID(String)" to set the id of the
 * object.
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public abstract class ReservableItem {
	private String id;
	private boolean[] times = new boolean[10];

	// No argument constructor. Sets the values of times to false.
	public ReservableItem() {
		for (boolean element : times) {
			element = false;
		}
	}

	// Constructor with Scanner as argument. Sets id and fills time array with
	// "false".
	public ReservableItem(Scanner fileIn) {
		for (boolean element : times) {
			element = false;
		}
		this.id = fileIn.next();
	}

	// Returns id.
	public String getId() {
		return this.id;
	}

	// Abstract method to return fitness value. Defined in subclasses.
	abstract int getFitnessValue(Reservation res);

	// Returns a deep copy of the times array.
	public boolean[] getTimeArray() {
		boolean[] returnArray = new boolean[10];
		for (int i = 0; i < 10; i++) {
			returnArray[i] = this.times[i];
		}
		return returnArray;
	}

	// Sets the value of a specific index of times to true.
	public void timeTaken(int index) {
		times[index] = true;
	}

	// Sets the instance variable id to a given String.
	public void setID(String s) {
		this.id = s;
	}

}
