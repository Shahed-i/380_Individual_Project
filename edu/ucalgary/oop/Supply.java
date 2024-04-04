package edu.ucalgary.oop;

public class Supply {
    private String type;
    private int quantity;

    public Supply(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public void setType(String type) { this.type = type; }
    
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public String getType() { return this.type; }
    
    public int getQuantity() { return this.quantity; }

    public void increaseQuantity() {
        this.quantity++;
    }
    
    public void decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
}
