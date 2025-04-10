// Data.java

public class Data {

    private String name;
    private int price;
    private int size;
    private int quantity;

    // Singleton instance
    private static Data instance = null;

    // Private constructor prevents external instantiation
    private Data() {
    }

    // Public method to get the singleton instance
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // A method to clear/reset the data
    public void clearData() {
        name = null;
        price = 0;
        size = 0;
        quantity = 0;
    }
}
