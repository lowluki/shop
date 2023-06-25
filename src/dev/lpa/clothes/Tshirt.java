package dev.lpa.clothes;

public class Tshirt implements Item{
    private String brand;
    private String size;
    private double price;

    public Tshirt(String brand, String size, double price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
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
        return "T-SHIRT";
    }
}
