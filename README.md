# Core Java Hotel Booking Management System

## Project Overview

This project is a simple hotel booking management system written in core Java.
It demonstrates how to create Java classes, use interfaces, store objects in collections, and perform common operations on guest and booking data.

The program runs from the console. The `Main` class creates sample guests, rooms, and bookings, then displays the results of different hotel operations.

## Main Features

The project can:

- Find guest names that contain a given keyword.
- Find the email domains used by guests.
- Find the second guest name after filtering guests by age and sorting their names.
- Count bookings for each room type.
- Group complete guest objects by city.
- Extract guest names, email addresses, or cities by field name.
- Save bookings in a simple in-memory database.
- Find a booking by the guest ID.

## Project Structure

```text
src/
├── Main.java
├── classes/
│   ├── Booking.java
│   ├── Database.java
│   ├── Guest.java
│   ├── HotelOperationsImpl.java
│   └── Room.java
└── interfaces/
	└── HotelOperations.java

bin/
└── classes/       Compiled Java class files

```

## Main Classes

### `Guest`

Represents a hotel guest. It stores:

- Guest ID
- Name
- Email address
- City
- Age

The class provides a constructor, getter methods, setter methods, and a readable `toString()` method.

### `Room`

Represents a hotel room. It stores:

- Room number
- Room type
- Price per night

The class provides a constructor, getter methods, and setter methods.

### `Booking`

Represents a booking made by a guest. It stores:

- Booking ID
- Guest object
- Room object
- Number of nights

The class provides a constructor, getter methods, and setter methods.

### `HotelOperations`

This interface defines the main hotel operations that must be implemented by `HotelOperationsImpl`:

- `getGuestNamesContaining`: returns names that contain a keyword.
- `getGuestEmailDomains`: returns unique email domains.
- `getGuestName`: returns the second alphabetically sorted name from guests older than the given age.
- `countBookingByRoomType`: returns the booking count for each room type.
- `groupGuestByCity`: returns a map where each city is linked to its guest objects.

### `HotelOperationsImpl`

This class implements the `HotelOperations` interface. It also provides the additional `extractGuestField` method.

The `extractGuestField` method accepts `name`, `email`, or `city` as the field name and returns the matching values for all guests.

### `Database`

This class provides a simple in-memory list of bookings. It can:

- Save a booking with `saveBooking`.
- Find the first booking belonging to a guest with `getBookingByGuest`.
- Print stored booking IDs with `printBookings`.

The data is stored only while the program is running. It is not saved to a file or a real database.

## How to Compile

Open a terminal in the project folder and run:

```text
javac -d bin/classes src/Main.java src/classes/*.java src/interfaces/*.java
```

The compiled class files will be placed in `bin/classes`.

## How to Run

After compiling, run:

```text
java -cp bin/classes Main
```

## Sample Program Flow

The `Main` class:

1. Creates four guest objects.
2. Stores the guests in a list.
3. Creates five room objects and five booking objects.
4. Runs the hotel operations on the sample data.
5. Creates a database object and saves bookings.
6. Finds a booking for the first guest.
7. Prints the operation results to the console.

## Requirements

- Java Development Kit (JDK) 8 or newer
- Visual Studio Code with Java support, or another Java IDE
- A terminal for compiling and running the program

No external libraries are required for this project.
