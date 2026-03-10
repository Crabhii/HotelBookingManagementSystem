import java.util.HashMap;

public class HotelBookingManagementSystem {

    // UC2 — Room Inventory
    static HashMap<String, Integer> roomInventory = new HashMap<>();

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

        // UC3 — Booking Simulation
        System.out.println("\nBooking Request: 1 Deluxe Room");

        if (bookRoom("Deluxe Room")) {
            System.out.println("Booking successful.");
        } else {
            System.out.println("Booking failed.");
        }

        // UC4 — Room Search
        System.out.println("\nRoom Search Result:");
        searchRoom("Suite");

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
            System.out.println("Invalid room type.");
            return false;
        }

        int availableRooms = roomInventory.get(roomType);

        if (availableRooms > 0) {
            roomInventory.put(roomType, availableRooms - 1);
            return true;
        }

        return false;
    }

    // UC4 — Room Search & Availability Check
    static void searchRoom(String roomType) {

        if (!roomInventory.containsKey(roomType)) {
            System.out.println("Room type not found.");
            return;
        }

        int available = roomInventory.get(roomType);

        if (available > 0) {
            System.out.println(roomType + " is available. Rooms left: " + available);
        } else {
            System.out.println(roomType + " is currently fully booked.");
        }
    }
}