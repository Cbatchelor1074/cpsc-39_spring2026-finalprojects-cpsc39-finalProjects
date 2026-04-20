public class OrderLinkedList {
    private Node head;

    public OrderLinkedList() {
        head = null;
    }

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

    public void removeItem(String name) {
        if (head == null) return;

        if (head.getItem().getName().equals(name)) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getItem().getName().equals(name)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

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
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Estimated Time: " + calculatePrepTime() + " mins");
    }
}