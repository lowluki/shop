package dev.lpa.bill;

import dev.lpa.clothes.*;

import java.util.*;

public class Bill {
    private List<Item> basket;
    private List<Item> basketOfTshirts;
    private List<Item> basketOfPants;
    private List<Item> basketOfHoodies;
    private List<Item> basketOfShoes;

    public Bill(List<Item> basket,List<Item> basketOfTshirts, List<Item> basketOfPants, List<Item> basketOfHoodies, List<Item> basketOfShoes) {
        this.basket = basket;
        this.basketOfTshirts = basketOfTshirts;
        this.basketOfPants = basketOfPants;
        this.basketOfHoodies = basketOfHoodies;
        this.basketOfShoes = basketOfShoes;

    }

    public void showBill() {
        double sumOfAll = 0;
        double sumOfTshirts = 0;
        double sumOfPants = 0;
        double sumOfHoodies = 0;
        double sumOfShoes = 0;
        double discountsOfTshirts = 0;
        double discountsOfPants = 0;
        double discountsOfHoodies = 0;
        double discountsOfShoes = 0;
        double sumOfDiscounts = 0;
        String type = null;
        for(Item b : basket) {
            if(b instanceof Tshirt) {
                type = "T-SHIRT";
                sumOfTshirts += b.getPrice();
                basketOfTshirts.add(b);
            } else if (b instanceof Pants) {
                type = "PANTS";
                sumOfPants += b.getPrice();
                basketOfPants.add(b);
            }else if (b instanceof Hoodie) {
                type = "HOODIE";
                sumOfHoodies += b.getPrice();
                basketOfHoodies.add(b);
            }else if (b instanceof Shoes) {
                type = "SHOES";
                sumOfShoes += b.getPrice();
                basketOfShoes.add(b);
            }
            System.out.println(String.format("%-10s - BRAND: %-15s| SIZE: %-4s| PRICE: %.2f$", type, b.getBrand(), b.getSize(), b.getPrice()));
            System.out.println("-------------------------------------------------------");
        }
        Collections.sort(basketOfTshirts, comparator);
        Collections.sort(basketOfPants, comparator);
        Collections.sort(basketOfHoodies, comparator);
        Collections.sort(basketOfShoes, comparator);
        if(basketOfTshirts.size() >= 3) {
            for(int i = 0; i < 3; i++) {
                discountsOfTshirts += basketOfTshirts.get(i).getPrice();
            }
            discountsOfTshirts *= 0.3;
            sumOfTshirts -= discountsOfTshirts;
            System.out.println(String.format("Discounts for T-shirts is %.2f$", discountsOfTshirts));
        }
        if (basketOfPants.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                discountsOfPants += basketOfPants.get(i).getPrice();
            }
            discountsOfPants *= 0.4;
            sumOfPants -= discountsOfPants;
            System.out.println(String.format("Discounts for Pants is %.2f$", discountsOfPants));
        }
        if (basketOfHoodies.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                discountsOfHoodies += basketOfHoodies.get(i).getPrice();
            }
            discountsOfHoodies *= 0.2;
            sumOfHoodies -= discountsOfHoodies;
            System.out.println(String.format("Discounts for Hoodies is %.2f$", discountsOfHoodies));
        }
        if (basketOfShoes.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                discountsOfShoes += basketOfShoes.get(i).getPrice();
            }
            discountsOfShoes *= 0.2;
            sumOfShoes -= discountsOfShoes;
            System.out.println(String.format("Discounts for Shoes is %.2f$", discountsOfShoes));
        }
        sumOfDiscounts = discountsOfShoes + discountsOfPants + discountsOfHoodies + discountsOfTshirts;
        sumOfAll = sumOfTshirts + sumOfPants + sumOfHoodies + sumOfShoes;
        System.out.println("------------------------------------------------------------");
        System.out.println(String.format("                                          TOTAL DISCOUNT: %.2f$", sumOfDiscounts));
        System.out.println(String.format("                                          TOTAL COST:     %.2f$", sumOfAll));
    }

    Comparator<Item> comparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getPrice() > (o2.getPrice()) ? -1 : 1;
        }
    };
}
