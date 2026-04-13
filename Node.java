// Chase Batchelor
// CPSC-39
// This file stores a MenuItem, quantity, and points to the next node.

public class Node {
    private MenuItem item;
    private int quantity;
    private Node next;

    public Node(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.next = null;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public Node getNext() {
        return next;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}