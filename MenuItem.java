// Chase Batchelor
// CPSC-39
// This file handles items on the menu and its attributes such as name, price and prep time.

public class MenuItem {
    private String name;
    private double price;
    private int prepTime; // minutes

    public MenuItem(String name, double price, int prepTime) {
        this.name = name;
        this.price = price;
        this.prepTime = prepTime;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String toString() {
        return name + " - $" + price + " (" + prepTime + " mins)";
    }
}