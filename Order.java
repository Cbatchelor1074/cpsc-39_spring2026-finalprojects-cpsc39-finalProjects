/* 
* Chase Batchelor
* CPSC-39
* Represents a customer's order and acts as a controller between the user interface, and data structures.
* It uses a linked list to store items and an ArrayList to maintain order history across sessions.
*/

import java.util.ArrayList;

public class Order {
    
    private int orderNumber;
    private OrderLinkedList items;
    
    // Data Structure #1 ArrayList (Order History Storage)
    private static ArrayList<Order> orderHistory = new ArrayList<>();

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new OrderLinkedList();
    }

    public void addItem(MenuItem item, int quantity) {
        items.addItem(item, quantity);
    }

    public void removeItem(String name) {
        items.removeItem(name);
    }

   /*
   * Algorithm #1: Total Calculation (Linked List Iteration)
   * - Iterates through the linked list and accumulates total cost
   * - Time Complexity: O(n)
   */

    public double calculateTotal() {
        return items.calculateTotal();
    }

    /*
    * Algorithm #2: Prep Time Calculation (Linked List Iteration)
    * - Iterates through all nodes and sums prep times
    * - Time complexity: O(n)
    */

    public int calculatePrepTime() {
        return items.calculatePrepTime();
    }

    public void displayOrder() {
        System.out.println("\n========== ORDER ==========");
        System.out.println("Order #" + orderNumber);
        items.displayOrder();
        System.out.println("==========================");
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    /*
     * Algorithm #3: Order History Storage
     * - Stores completed order in ArrayList
     * Time Complexity: O(1)
     */

    public void completeOrder() {
        orderHistory.add(this);
    }

    public static void displayOrderHistory() {
        System.out.println("\n--- ORDER HISTORY ---");
    
        for (Order o : orderHistory) {
            System.out.println("Order #" + o.getOrderNumber() + " | Total: $" + o.calculateTotal() + " | Time: " + o.calculatePrepTime() + " mins");
        }
    }

    public void updateItem(String name, int quantity) {
        items.updateItem(name, quantity);
    }
}