package dev.lpa.clothes;

public interface Item {
    double getPrice();

    String getSize();

    String getBrand();

    String getType();

    default void showItem() {
        System.out.format("%-8s | BRAND: %-13s | SIZE: %-5s | PRICE: %.2f$\n", this.getType(), this.getBrand(),
                this.getSize(), this.getPrice());
    }

    default void showItem(int counter) {
        System.out.format("%2d. %-8s | BRAND: %-13s | SIZE: %-5s | PRICE: %.2f$\n", counter, this.getType(),
                this.getBrand(), this.getSize(), this.getPrice());
    }
}
