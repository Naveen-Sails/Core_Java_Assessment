package classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.HotelOperations;

public class HotelOperationsImpl implements HotelOperations {
    public List<String> getGuestNamesContaining(List<Guest> guests, String keyword){
        List<String> guestNameList = new ArrayList<>();
        for( Guest guest : guests){
            String name = guest.getName();
            if(name.contains(keyword)){
                guestNameList.add(name);
            }  
        }
        return guestNameList;
    }

    public Set<String> getGuestEmailDomains(List<Guest> guests){
        Set<String> emailDomains = new HashSet<>();
        for(Guest guest : guests){
            String email = guest.getEmail();
            String[] stringList = email.split("@");
            // Store domains in a set so duplicate domains appear only once.
            emailDomains.add(stringList[1]);
        }
        return emailDomains;
    }

    public String getGuestName(List<Guest> guests, int age){
        List<String> guestNames = new ArrayList<>();
        for(Guest guest : guests){
            if(guest.getAge() > age){
                guestNames.add(guest.getName());
            }
            // Keep the names in alphabetical order for the required result.
            guestNames.sort(null);
        }
        return  guestNames.get(1);

    }

    public Map <String, Long> countBookingByRoomType(List<Booking> bookings){

        Map<String, Long> bookingMap = new HashMap<>();
        for(Booking booking : bookings){
            Room room = booking.getRoom();
            String roomType = room.getRoomType();
            // Increase the count for each booking with the same room type.
            if(bookingMap.containsKey(roomType)){
                bookingMap.put(roomType, bookingMap.get(roomType) + 1);
            }
            else{
                bookingMap.put(roomType, (long) 1);
            }
        }

        return bookingMap;
    }

    public Map <String, List<Guest>> groupGuestByCity(List<Guest> guests){
        Map <String, List<Guest>> guestMapByCities = new HashMap<>();
        for(Guest guest : guests){
            String guestCity = guest.getCity();
            // Each city maps to a list containing the complete Guest objects.
            if(guestMapByCities.containsKey(guestCity)){
                guestMapByCities.get(guestCity).add(guest);
            
            }
            else{
                ArrayList<Guest> newList = new ArrayList<>();
                newList.add(guest);
                guestMapByCities.put(guestCity , newList);
            }

        }
        return guestMapByCities;
    }

    public List<String> extractGuestField(List<Guest> guests, String fieldName){

        List<String> guestFieldList = new ArrayList<>();
        // Select which Guest property should be copied into the result list.
        if(fieldName.equals("name")){
            for(Guest guest : guests){
                guestFieldList.add(guest.getName());
            }
        }
        else if (fieldName.equals("email")) {
            for(Guest guest : guests){
                guestFieldList.add(guest.getEmail());
            }
        }
        else{
            for(Guest guest : guests){
                guestFieldList.add(guest.getCity());
            }
        }

        return guestFieldList;
    }
    
}
