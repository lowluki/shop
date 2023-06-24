package dev.lpa.data;

public class Country {

    String name;
    double distance;
    double ship;

    public Country(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getShip() {
        ship = distance/250;
        return ship;
    }

    @Override
    public String toString() {
        return "Country: " + name + ", ship: " + ship;
    }
}
