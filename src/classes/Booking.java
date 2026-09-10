package classes;
public class Booking {
    private int bookingId;
    private Guest guest;
    private Room room;
    private int numberOfNights;

    //Constructor
    
    public Booking(int bookingId, Guest guest, Room room, int numberOfNights) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
    }

    //Getter Methods

    public int getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    //Setter Methods

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
    
    //public String toString(){}

    
}
