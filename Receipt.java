/* 
* Chase Batchelor
* CPSC-39
* Formats and displays the final receipt for a completed order.
* Provides a clean summary including items, total cost, and estimated preparation time.
*/

public class Receipt {
    public static void print(Order order) {
        System.out.println("\n==============================");
        System.out.println("      FINAL RECEIPT        ");
        System.out.println("==============================");

        System.out.println("Order #" + order.getOrderNumber());
        System.out.println();

        order.displayOrder();
        
        System.out.println("\n------------------------------");
        System.out.printf("TOTAL COST: $%.2f%n", order.calculateTotal());
        System.out.println("ESTIMATED TIME: " + order.calculatePrepTime() + " mins");
        
        System.out.println("==============================");
    }
}