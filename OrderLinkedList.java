/* 
* Chase Batchelor
* CPSC-39
* Custom linked list implementation used to store order items dynamically.
* It handles insertion, removal, and calculations like total cost, and prepartion time.
*/

public class OrderLinkedList {
    // Data Structure #3: Custom Linked List (Order Storage)
    private Node head;

    public OrderLinkedList() {
        head = null;
    }

    /*
     * Algorithm #1: Linked List Insertion
     * - Traverses to end and adds new node
     * - Time Complexity: O(n)
     */

    public void addItem(MenuItem item, int quantity) {
        Node newNode = new Node(item, quantity);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /*
     * Algorithm #2: Search + Deletion
     * - Finds node by name and removes it by pointer reassignment
     * - Time Complexity: O(n)
     */

    public void removeItem(String name) {
        if (head == null) {
            System.out.println("Order is empty.");
            return;
        }

        if (head.getItem().getName().equalsIgnoreCase(name)) {
            head = head.getNext();
            System.out.println("Item removed.");
            return;
        }

        Node current = head;

        while (current.getNext() != null) {
            if (current.getNext().getItem().getName().equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                System.out.println("Item removed.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Item not found.");
    }

    /**
     * Algorithm #3: Iterative Sum (Total Calculation)
     * - Iterates through all nodes and computes total price
     * - Time Complexity: O(n)
     */

    public double calculateTotal() {
        double total = 0;
        Node current = head;

        while (current != null) {
            total += current.getItem().getPrice() * current.getQuantity();
            current = current.getNext();
        }
        return total;
    }

    public int calculatePrepTime() {
        int time = 0;
        Node current = head;

        while (current != null) {
            time += current.getItem().getPrepTime() * current.getQuantity();
            current = current.getNext();
        }
        return time;
    }

    public void displayOrder() {
        Node current = head;
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.getItem().getName() + " x" + current.getQuantity());
            current = current.getNext();
            i++;
        }
        System.out.printf("Total: $%.2f%n", calculateTotal());
        System.out.println("Estimated Time: " + calculatePrepTime() + " mins");
    }

    public void updateItem(String name, int quantity) {
        Node current = head;

        while (current != null) {
            if (current.getItem().getName().equalsIgnoreCase(name)) {
                current.setQuantity(quantity);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Item not found.");
    }
}