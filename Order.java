// Chase Batchelor
// CPSC-39
// This file stores items in an order, and operations regarding order number, total price, and prep time.

import java.util.ArrayList;

public class Order {
    
    private int orderNumber;
    private ArrayList<MenuItem> items;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
   }

   public double calculateTotal() {
    double total = 0;
    for (MenuItem item : items) {
        total += item.getPrice();
    }
    return total;
   }

   public int calculatePrepTime() {
    int time = 0;
    for (MenuItem item : items) {
        time += item.getPrepTime();
    }
    return time;
   }

   public void displayOrder() {
    System.out.println("Order #" + orderNumber);
    for (int i = 0; i < items.size(); i++) {
        System.out.println((i + 1) + ". " + items.get(i));
    }
    System.out.println("Total: $" + calculateTotal());
    System.out.println("Estimated Time: " + calculatePrepTime() + " minutes");
   }

   public int getOrderNumber() {
    return orderNumber;
   }
}