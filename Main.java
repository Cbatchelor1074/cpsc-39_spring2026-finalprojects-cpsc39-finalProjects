/* 
* Chase Batchelor
* CPSC-39
* Entry point of the program. It handles user interaction through a scanner-based system.
* It processes input commands, and coordinates actions between the menu system and the Order class.
*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();

        // Data Structure #2: HashMap (Menu Storage)
        HashMap<String, MenuItem> menu = new HashMap<>();

        //Menu Items
        menu.put("taco", new MenuItem("Taco", 2.50, 3));
        menu.put("burrito", new MenuItem("Burrito", 6.00, 8));
        menu.put("quesadilla", new MenuItem("Quesadilla", 9.00, 2));
        menu.put("pupusa", new MenuItem("Pupusa", 3.00, 6));
        menu.put("nachos", new MenuItem("Nachos", 8.00, 4));
        menu.put("pozole", new MenuItem("Pozole", 12.00, 4));
        menu.put("soda", new MenuItem("Soda", 1.50, 1));

        Order order = new Order(rand.nextInt(100, 500));

        boolean running = true;
        /*
        * Algorithm #1: Input Processing Loop
        * - Continuously reads user input and routes actions
        * - Acts as decision-making control structure
        * - Time Complexity: O(n)
        */

        while (running) {
            System.out.println("==================================");
            System.out.println("\n----- MENU -----");
            
            /*
            * Algorithm #2: Menu Lookup (HashMap)
            * - Retrieves menu items using key lookup
            * - Time Complexity: O(1)
            */

            for (String key : menu.keySet()) {
                MenuItem item = menu.get(key);
                System.out.printf("%-10s $%.2f%n", item.getName(), item.getPrice());
            }

            System.out.println("\nType item name to add");
            System.out.println("Type 'remove' to remove an item");
            System.out.println("Type 'edit' to change quantity");
            System.out.println("Type 'view' to see order");
            System.out.println("Type 'exit' to finish");
            System.out.print("\nEnter item (or view/exit): ");

            String choice = scnr.next().trim().toLowerCase();

            if (choice.equals("view")) {
                order.displayOrder();
            } else if (choice.equals("exit")) {
                order.completeOrder();
                running = false;
            } else if (menu.containsKey(choice)) {
                
                /*
                * Algorithm #3: Order Building Logic
                * - Accepts user input and adds items to linked list via Order Class
                * - Delegates insertion to OrderLinkedList
                */
                
                System.out.print("Quantity: ");
                int quantity = scnr.nextInt();
                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Must be greater than 0.");
                    continue;
                }

                order.addItem(menu.get(choice), quantity);
                System.out.println("Item added successfully.\n");
            } else if (choice.equals("remove")) {
                System.out.print("Enter item name to remove: ");
                String itemName = scnr.next().trim().toLowerCase();
                order.removeItem(itemName);
            } else if (choice.equals("edit")) {
                System.out.print("Enter item name to edit: ");
                String itemName = scnr.next().trim().toLowerCase();
                System.out.print("New quantity: ");
                int newQuantity = scnr.nextInt();
                order.updateItem(itemName, newQuantity);
            } else {
                System.out.println("Invalid option. Try again.");
                System.out.println();
            }
        }

        System.out.println("\n--- FINAL RECEIPT ---");
        Receipt.print(order);

        order.displayOrderHistory();

        System.out.println("Thank you for your order!");
        
        int rating;
        do {
            System.out.println("Rate your experience (1-5): ");
            rating = scnr.nextInt();
        } while (rating < 1 || rating > 5);

        FeedbackManager.addRating(rating);
        FeedbackManager.displayStats();
        
        scnr.close();
    }
}