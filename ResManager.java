import java.util.ArrayList;

/*
 * The purpose of this class it to manage both the available reservable items, as well as
 * the reservations that have been placed by guests. ResManager is a generic class that
 * lets you define an ItemType which extends ReservableItem, as well as defining a ResType
 * which is extended from Reservation. It has two ArrayLists for instance variables. The
 * first one is an ArrayList of type ItemType, its name is "items". The second ArrayList is
 * of type ResType and is named "reservations". This class also has a no argument constructor,
 * as well as the methods "addReservableItem(ItemType)" which returns void, "makeReservations(ResType)"
 * which returns an object of type Reservation. "sortReservations()" which will sort the elements
 * in the reservations ArrayList by name the reservation is associated with. And finally an override
 * "toString()" method which is used to print out the items in reservations.
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class ResManager<ItemType extends ReservableItem, ResType extends Reservation> {

	private ArrayList<ItemType> items = new ArrayList<>();
	private ArrayList<ResType> reservations = new ArrayList<>();

	// No argument constructor
	public ResManager() {
	}

	// Adds the reservable item "ItemType" to the ArrayList items.
	public void addReservable(ItemType item) {
		items.add(item);
	}

	/*
	 * Used to create a new reservation. First an array of type int is created
	 * called "avalibleObjects". than an int is created called "avalibleIndex" and
	 * is set equal to 0. This array will hold the index of available objects in
	 * ArrayList items at a specific time. items is then looped through and whenever
	 * an available object is found (their time is set to "false" meaning they are
	 * not scheduled at that time) their index in items is added to avalibleObjects
	 * and avalibleIndex is increased by one. After that another int called
	 * "bestItemIndex" is created and set equal to the size of items. Another int
	 * called "bestFit" is set to 100. Then a for loop is used to go through all of
	 * the avalibleObjects, and get a fitness value which is then compared to the
	 * stored fitness value. It the new fitness value is better than the bestFit int
	 * is updated to this score, and the bestItemIndex is set equal to where the
	 * item was found in ArrayList items. Once this has been done and the best fit
	 * is found, the program continues to an if loop. if bestItemIndex is still set
	 * equal to the size of items, then the if block is skipped, and an
	 * "Unsuccessful reservation..." message is printed. This is because no item was
	 * found that would match the criteria of being an item usable for the
	 * reservation. After this a null object is returned. If an item was found then
	 * the method "timeTaken(int)" is called on the object and its time value is set
	 * to "true" to show that this spot is now reserved. The reservations resourceID
	 * is also changed to the name of the reserved item, and is then added to the
	 * ArrayList reservations. An object of type Reservation is then returned using
	 * trialRes as an argument for a copy constructor.
	 */

	public Reservation makeReservation(ResType trialRes) {
		int[] avalibleObjects = new int[items.size()];
		int avalibleIndex = 0;
		for (int i = 0; i < items.size(); i++) {
			if ((items.get(i).getTimeArray())[trialRes.getTime()] == false) {
				avalibleObjects[avalibleIndex] = i;
				avalibleIndex++;
			}
		}

		int bestItemIndex = items.size();
		int bestFit = 100;
		for (int i = 0; i < avalibleIndex; i++) {
			int tester = items.get(avalibleObjects[i]).getFitnessValue(trialRes);
			if (tester < bestFit && tester >= 0) {
				bestItemIndex = avalibleObjects[i];
				bestFit = tester;
			}
		}

		if (!(bestItemIndex == items.size())) {
			items.get(bestItemIndex).timeTaken(trialRes.getTime());
			trialRes.setResourceID(items.get(bestItemIndex).getId());
			reservations.add(trialRes);
			return new Reservation(trialRes);

		} else {
			System.out.println("Unsuccessful reservation: " + trialRes.toString());
			return null;
		}
	}

	/*
	 * Using a bubble sort, sorts the reservations based on the Name they are placed
	 * under. This is done by comparing two objects, and if the left object is
	 * larger then the right one, they are swapped, until the largest object is at
	 * the top. Once this is done the process repeats itself, excluding the top most
	 * object as it is already in place. This is repeated until the ArrayList
	 * reservations is sorted by the name that the reservation is associated with.
	 */
	public void sortReservations() {
		for (int i = reservations.size() - 1; i > 0; i--) {
			for (int k = 0; k < i; k++) {
				if (reservations.get(k).compareTo(reservations.get(k + 1)) > 0) {
					ResType temp = reservations.get(k);
					reservations.set(k, reservations.get(k + 1));
					reservations.set(k + 1, temp);
				}
			}
		}
	}

	/*
	 * This is an Override toString method used to print out the contents of all of
	 * the reservations in the ResManager object. This is done by creating a String
	 * called "returnString" and setting it equal to "". It is then appended with
	 * the information for each object of reservations with a "\n" so that each
	 * reservation is on a new line. It then returns returnString.
	 */
	@Override
	public String toString() {
		String returnString = "";
		for (int i = 0; i < reservations.size(); i++) {
			returnString += reservations.get(i).toString() + "\n";
		}
		return returnString;
	}
}
