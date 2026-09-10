package interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import classes.Booking;
import classes.Guest;

/**
 * HotelOperations
 */
public interface HotelOperations {

    List<String> getGuestNamesContaining(List<Guest> guests, String keyword);

    Set<String> getGuestEmailDomains(List<Guest> guests);

    String getGuestName(List<Guest> guests, int age);

    Map <String, Long> countBookingByRoomType(List<Booking> bookings);

    Map <String, List<Guest>> groupGuestByCity(List<Guest> guests);

}

//concurrent hash map