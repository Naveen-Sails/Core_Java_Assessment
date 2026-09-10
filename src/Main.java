import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Booking;
import classes.Database;
import classes.Guest;
import classes.HotelOperationsImpl;
import classes.Room;

public class Main {
    public static void main(String[] args) {
        
        Guest guest1 = new Guest(01, "Naveen kumar", "naveen123@gmail.com", "Amalapuram", 21);
        Guest guest2 = new Guest(02, "Sunil", "sunil456@hotmail.com", "Vijayawada", 25);
        Guest guest3 = new Guest(03, "kalyan", "kalyan789@gmail.com", "Amalapuram", 15);
        Guest guest4 = new Guest(04, "Hemanth kumar", "hemanth@yahoo.com", "Eluru", 22);

        List<Guest> guestList = new ArrayList<>();

        //Assigning all the objects into a list
        Collections.addAll(guestList, guest1, guest2, guest3,guest4);

        HotelOperationsImpl HotelObj = new HotelOperationsImpl();
        // Print guest names that contain the word "kumar".
        System.out.println(HotelObj.getGuestNamesContaining(guestList, "kumar"));

        // Print the unique email domains of all guests.
        System.out.println(HotelObj.getGuestEmailDomains(guestList));

        // Print the second alphabetically sorted guest name whose age is above 20.
        System.out.println(HotelObj.getGuestName(guestList, 20));

        Room room1 = new Room(201, "Normal", 500);
        Room room2 = new Room(202, "Deluxe", 1000);
        Room room3 = new Room(203, "Super Deluxe", 2000);
        Room room4 = new Room(204, "Normal", 500);
        Room room5 = new Room(205, "Super Deluxe", 2000);
       
        List<Booking> bookingList = new ArrayList<>();

        Booking booking1 = new Booking(101, guest1, room1, 2);
        Booking booking2 = new Booking(102, guest2, room2,1);
        Booking booking3 = new Booking(103, guest3, room3, 4);
        Booking booking4 = new Booking(104, guest4, room4, 3);
        Booking booking5 = new Booking(105, guest1, room5, 1);

        Collections.addAll(bookingList, booking1,booking2,booking3,booking4,booking5);

        // Print the number of bookings for each room type.
        System.out.println(HotelObj.countBookingByRoomType(bookingList));

        // Print guests grouped by their city.
        System.out.println(HotelObj.groupGuestByCity(guestList));

        // Print the selected guest field, which is "name" in this example.
        System.out.println(HotelObj.extractGuestField(guestList, "name"));

        Database dbObj = new Database(bookingList);
        dbObj.saveBooking(booking5);
        dbObj.saveBooking(booking4);
        dbObj.saveBooking(booking3);
        dbObj.saveBooking(booking2);
        // dbObj.printBookings();
        
        Booking result = dbObj.getBookingByGuest(guest1);
        // Print the booking ID found for guest1.
        System.out.println("Found match: booking id is " + result.getBookingId());



    }
}
