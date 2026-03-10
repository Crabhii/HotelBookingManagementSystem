import java.util.HashMap;

public class HotelBookingManagementSystem {

    // UC2 — Room Inventory Data Structure
    static HashMap<String, Integer> roomInventory = new HashMap<>();

    public static void main(String[] args) {

        // UC1 — Application Entry & Welcome Message
        System.out.println("======================================");
        System.out.println("   HOTEL BOOKING MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.\n");

        // UC2 — Initialize Room Inventory
        initializeRooms();

        // Display Available Rooms
        displayRooms();
    }

    // UC2 — Initialize Room Types
    static void initializeRooms() {

        roomInventory.put("Single Room", 10);
        roomInventory.put("Double Room", 7);
        roomInventory.put("Deluxe Room", 5);
        roomInventory.put("Suite", 2);

        System.out.println("Room inventory initialized successfully.\n");
    }

    // UC2 — Display Room Availability
    static void displayRooms() {

        System.out.println("Available Room Types:");

        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType) + " rooms available");
        }
    }
}