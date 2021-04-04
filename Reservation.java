
/*
 * This class is used to represent a reservation from a customer. It has a String called "customer"
 * to store the customer name. An int "time" to store the requested time, and another String "resourceID"
 * to store the name of the reserved object that they receive, if they have a valid reservation. This
 * class has two constructors, One that takes a String and int as arguments, and another which is a copy
 * constructor. It also has the methods "getCustomer()" which returns customer, "getTime()" which returns
 * time, "getResourceID()" which returns resourceID, "setResourceID(String)" which sets the value of 
 * resourceID. Finally it has an override toString() method that prints out their name, time, and resourceID.
 * This method also implements the interface Comparable, so it also has the "compareTo(Object)" method.
 * 
 * @author Morgan Du Bois
 * @version 3/15/2019
 * CSS 143 B
 * Final Assignment - Reservations
 */

public class Reservation implements Comparable {

	private String customer;
	private int time;
	private String resourceID;

	// Constructor that takes String and int as arguments.
	public Reservation(String customerName, int timeSlot) {
		this.customer = customerName;
		this.time = timeSlot;
	}

	// Copy constructor.
	public Reservation(Reservation other) {
		this.customer = other.customer;
		this.time = other.time;
	}

	// Returns customer.
	public String getCustomer() {
		return this.customer;
	}

	// Returns time.
	public int getTime() {
		return time;
	}

	// Returns resourceID.
	public String getResourceID() {
		return this.resourceID;
	}

	// Sets the value of resourceID to passed in String ID.
	public void setResourceID(String ID) {
		this.resourceID = ID;
	}

	/*
	 * Override toString method. This will print out the name, time, and id of the
	 * reservation, but if the resourceID of the reservation is not set then instead
	 * of having it print out null, a white space is printed out.
	 */
	@Override
	public String toString() {
		if (resourceID == null) {
			return "Reservation name: " + customer + " time: " + time + " id: ";
		} else {
			return "Reservation name: " + customer + " time: " + time + " id: " + resourceID;
		}
	}

	/*
	 * Override compareTo method. Takes an object as a argument and then makes sure
	 * that the argument is not equal to null, or that it is of type Reservation. If
	 * it is null or is not an instance of reservation, then a ClassCastException is
	 * thrown. If the object is good, then it is cast to Reservation and used as an
	 * argument for a copy constructor, creating a new Reservation object called
	 * other. Once this is done other and the calling object are compared, and a
	 * value is returned based on the customer instance variable. If the calling
	 * object's customer comes before other's, then 1 is returned. If it is before
	 * then -1 is returned. If it is equal then a 0 is returned.
	 */
	@Override
	public int compareTo(Object o) throws ClassCastException {
		if (o == null || !(o instanceof Reservation)) {
			throw new ClassCastException();
		} else {
			Reservation other = new Reservation((Reservation) o);
			if (this.customer.compareTo(other.customer) > 0) {
				return 1;
			} else if (this.customer.compareTo(other.customer) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
