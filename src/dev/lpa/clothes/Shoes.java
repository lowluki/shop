package dev.lpa.clothes;

public class Shoes implements Item{
    private String brand;
    private String size;
    private double price;

    public Shoes(String brand, String size, double price) {
        this.brand = brand;
        this.size = size;
        this.price = price + 110.0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getType() {
        return "SHOES";
    }

    @Override
    public String toString() {
        return String.format("\tSHOES:% - BRAND: %-15s| SIZE: %-4s| PRICE: %.2f$", -10, getBrand(), getSize(), getPrice());
    }
}
