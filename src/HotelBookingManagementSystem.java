import java.util.*;

public class HotelBookingManagementSystem {

    // UC2 — Room Inventory
    static HashMap<String, Integer> roomInventory = new HashMap<>();

    // UC5 — Booking Request Queue
    static Queue<String> bookingRequests = new LinkedList<>();

    public static void main(String[] args) {

        // UC1 — Application Entry
        System.out.println("======================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.\n");

        // UC2 — Initialize Rooms
        initializeRooms();

        // UC2 — Display Inventory
        displayRooms();

        // UC4 — Room Search
        System.out.println("\nRoom Search:");
        searchRoom("Suite");

        // UC5 — Add Booking Requests
        System.out.println("\nAdding Booking Requests...");
        addBookingRequest("Single Room");
        addBookingRequest("Deluxe Room");
        addBookingRequest("Suite");

        // Process Requests
        System.out.println("\nProcessing Booking Requests...");
        processBookingRequests();

        // Final Inventory
        System.out.println("\nUpdated Room Inventory:");
        displayRooms();
    }

    // UC2 — Initialize Rooms
    static void initializeRooms() {

        roomInventory.put("Single Room", 10);
        roomInventory.put("Double Room", 7);
        roomInventory.put("Deluxe Room", 5);
        roomInventory.put("Suite", 2);

        System.out.println("Room inventory initialized.\n");
    }

    // UC2 — Display Inventory
    static void displayRooms() {

        System.out.println("Available Room Types:");

        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType) + " rooms available");
        }
    }

    // UC3 — Booking Logic
    static boolean bookRoom(String roomType) {

        if (!roomInventory.containsKey(roomType)) {
            return false;
        }

        int available = roomInventory.get(roomType);

        if (available > 0) {
            roomInventory.put(roomType, available - 1);
            return true;
        }

        return false;
    }

    // UC4 — Room Search
    static void searchRoom(String roomType) {

        if (!roomInventory.containsKey(roomType)) {
            System.out.println("Room type not found.");
            return;
        }

        int available = roomInventory.get(roomType);

        if (available > 0) {
            System.out.println(roomType + " available. Rooms left: " + available);
        } else {
            System.out.println(roomType + " fully booked.");
        }
    }

    // UC5 — Add Booking Request
    static void addBookingRequest(String roomType) {

        bookingRequests.add(roomType);
        System.out.println("Booking request added for: " + roomType);
    }

    // UC5 — Process Booking Requests
    static void processBookingRequests() {

        while (!bookingRequests.isEmpty()) {

            String request = bookingRequests.poll();

            System.out.println("Processing request for: " + request);

            if (bookRoom(request)) {
                System.out.println("Booking successful for " + request);
            } else {
                System.out.println("Booking failed for " + request + " (No rooms available)");
            }
        }
    }
}