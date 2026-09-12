package classes;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Booking> bookings;

    public Database(List<Booking> bookings) {
        this.bookings = new ArrayList<>();
    }

    public void saveBooking(Booking booking){
        // Add the new booking to the database list.
        bookings.add(booking);
    }

    public Booking getBookingByGuest(Guest guest){
        //Using Traditional way of Programming

        // for(Booking booking : bookings){
        //     Guest guestObj = booking.getGuest();
        //     // Compare guest IDs to find the booking that belongs to this guest.
        //     if (guestObj.getId() == guest.getId()){
        //         return booking;
        //     }
        // }
        // return  null;

        //Using Functional Programming
        return bookings.stream()
                       .filter(booking -> booking.getGuest().getId() == guest.getId())
                       .findFirst()
                       .orElse(null);

    }
  
    public void printBookings(){
        // for (Booking booking : bookings) {
        //     // Print each booking ID stored in the database.
        //     System.out.println("booking Id = " + booking.getBookingId());
        // }

        bookings.stream()
            .forEach(booking -> System.out.println("booking Id = " + booking.getBookingId()));
    }

    

    
}
