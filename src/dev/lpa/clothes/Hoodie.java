package dev.lpa.clothes;

public class Hoodie implements Item{
    private String brand;
    private String size;
    private double price;

    public Hoodie(String brand, String size, double price) {
        this.brand = brand;
        this.size = size;
        this.price = price + 23.0;
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
        return "HOODIE";
    }
}
