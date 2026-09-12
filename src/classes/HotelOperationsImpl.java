package classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import interfaces.HotelOperations;

public class HotelOperationsImpl implements HotelOperations {
    
    public List<String> getGuestNamesContaining(List<Guest> guests, String keyword){
        //Using Traditional way of Programming

        // List<String> guestNameList = new ArrayList<>();
        // for( Guest guest : guests){
        //     String name = guest.getName();
        //     if(name.contains(keyword)){
        //         guestNameList.add(name);
        //     }  
        // }
        // return guestNameList;

        //Using Functional Programming
        return guests.stream()
                    .map(guest -> guest.getName())
                    .filter(name -> name.contains(keyword))
                    .collect(Collectors.toList());
    }

    public Set<String> getGuestEmailDomains(List<Guest> guests){
        // Using Traditional Way of Programming

        // Set<String> emailDomains = new HashSet<>();
        // for(Guest guest : guests){
        //     String email = guest.getEmail();
        //     String[] stringList = email.split("@");
        //     // Store domains in a set so duplicate domains appear only once.
        //     emailDomains.add(stringList[1]);
        // }
        // return emailDomains;

        //Using Functional Programming
        return guests.stream()
                      .map(guest -> guest.getEmail())
                      .map(email -> email.split("@")[1])
                      .collect(Collectors.toSet());
    }

    public String getGuestName(List<Guest> guests, int age){
        //Using Traditional way of Programming

        // List<String> guestNames = new ArrayList<>();
        // for(Guest guest : guests){
        //     if(guest.getAge() > age){
        //         guestNames.add(guest.getName());
        //     }
        //     // Keep the names in alphabetical order for the required result.
        //     guestNames.sort(null);
        // }
        // return  guestNames.get(1);

        //Using Fuctional Programming
        return guests.stream()
                     .filter(guest -> guest.getAge() > age)
                     .map(guest -> guest.getName())
                     .sorted()
                     .skip(1)
                     .findFirst()
                     .orElse(null);

    }

    public Map <String, Long> countBookingByRoomType(List<Booking> bookings){
        // Using Traditional way of Programming

        // Map<String, Long> bookingMap = new HashMap<>();
        // for(Booking booking : bookings){
        //     Room room = booking.getRoom();
        //     String roomType = room.getRoomType();
        //     // Increase the count for each booking with the same room type.
        //     if(bookingMap.containsKey(roomType)){
        //         bookingMap.put(roomType, bookingMap.get(roomType) + 1);
        //     }
        //     else{
        //         bookingMap.put(roomType, (long) 1);
        //     }
        // }

        // return bookingMap;
        
        //Using Functional Programming
        return bookings.stream()
                       .map(Booking :: getRoom)
                       //.map(room -> room.getRoomType())
                       .collect(Collectors.groupingBy(Room :: getRoomType, Collectors.counting()));
    }

    public Map <String, List<Guest>> groupGuestByCity(List<Guest> guests){
        // Using Traditional way of Programming

        // Map <String, List<Guest>> guestMapByCities = new HashMap<>();
        // for(Guest guest : guests){
        //     String guestCity = guest.getCity();
        //     // Each city maps to a list containing the complete Guest objects.
        //     if(guestMapByCities.containsKey(guestCity)){
        //         guestMapByCities.get(guestCity).add(guest);
            
        //     }
        //     else{
        //         ArrayList<Guest> newList = new ArrayList<>();
        //         newList.add(guest);
        //         guestMapByCities.put(guestCity , newList);
        //     }

        // }
        // return guestMapByCities;

        //Using Functional Programming
        return guests.stream()
                     .collect(Collectors.groupingBy(Guest :: getCity));


    }

    public List<String> extractGuestField(List<Guest> guests, String fieldName){
        //Using Traditional way of Programming

        // List<String> guestFieldList = new ArrayList<>();
        // // Select which Guest property should be copied into the result list.
        // if(fieldName.equals("name")){
        //     for(Guest guest : guests){
        //         guestFieldList.add(guest.getName());
        //     }
        // }
        // else if (fieldName.equals("email")) {
        //     for(Guest guest : guests){
        //         guestFieldList.add(guest.getEmail());
        //     }
        // }
        // else{
        //     for(Guest guest : guests){
        //         guestFieldList.add(guest.getCity());
        //     }
        // }

        // return guestFieldList;

        //Using Functional Programming
        return guests.stream()
                     .map( guest ->{
                        if("name".equals(fieldName)){
                            return guest.getName();
                        }
                        else if("email".equals(fieldName)){
                            return guest.getEmail();
                        }
                        else{
                            return guest.getCity();
                        }
                    })
                     .collect(Collectors.toList());
    }
    
}
