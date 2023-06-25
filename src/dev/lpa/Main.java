package dev.lpa;

import dev.lpa.basket.RemoveItems;
import dev.lpa.bill.Bill;
import dev.lpa.clothes.*;
import dev.lpa.data.DataInitiator;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static String input;
    private static boolean flag = true;
   private static List<Item> basket = new ArrayList<>();
    private static List<Item> basketOfTshirt = new ArrayList<>();
    private static List<Item> basketOfPants = new ArrayList<>();
    private static List<Item> basketOfHoodies = new ArrayList<>();
    private static List<Item> basketOfShoes = new ArrayList<>();
   public static final String STRING_START = """
                1 - Add a T-shirt
                2 - Add a pants
                3 - Add a hoodie
                4 - Add an accessories
                5 - Add shoes
                6 - Check the bill
                7 - Remove some item(s) from basket
                8 - Pay and end
                """;
    public static final String BLOCK_TEXT= """
                -1 - Leave the shop
                0 - Go back to menu
                """;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(flag) {
            System.out.println(STRING_START);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println(BLOCK_TEXT);
                    addTshirt();
                }
                case "2" -> {
                    System.out.println(BLOCK_TEXT);
                    addPants();
                }
                case "3" -> {
                    System.out.println(BLOCK_TEXT);
                    addHoodie();
                }
                case "4" -> addAccessories();
                case "5" -> {
                    System.out.println(BLOCK_TEXT);
                    addShoes();
                }
                case "6" -> {
                    showBill();
                }
                case "7" -> removeItems();
                case "8" -> {
                    showBill();
                    flag = false;
                }

            }
        }

    }

    private static void showDiscounts() {
    }

    private static void removeItems() {
        RemoveItems removeItems = new RemoveItems(basket);
        removeItems.RemoveItems();
    }

    private static void showBill() {
      Bill bill= new Bill(basket, basketOfTshirt, basketOfPants, basketOfHoodies, basketOfShoes);
      bill.showBill();
    }

    private static void addShoes() {
        int counter = 1;
        List<Item> shoes = DataInitiator.listOfShoes();
        for(Item s : shoes) {
            s.showItem(counter);
            counter++;
        }
        addToBasket(shoes);
    }

    private static void addAccessories() {

    }

    private static void addHoodie() {
        int counter = 1;
        List<Item> hoodies = DataInitiator.listOfHoodies();
        for(Item h : hoodies) {
            h.showItem(counter);
            counter++;
        }
        addToBasket(hoodies);
    }

    private static void addPants() {
        int counter = 1;
        List<Item> pants = DataInitiator.listOfPants();
        for(Item p : pants) {
            p.showItem(counter);
            counter++;
        }
        addToBasket(pants);
    }

    private static void addTshirt() {
        int counter = 1;
        List<Item> tshirts = DataInitiator.listOfTshirts();
        for(Item t : tshirts) {
            t.showItem(counter);
            counter++;
        }
      addToBasket(tshirts);
    }

    private static void addToBasket(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        int itemInput = scanner.nextInt();
        if(itemInput == - 1) {
            flag = false;
        } else if(itemInput == 0) {
            input = "10";
        } else {
            if(items.size() >= itemInput) {
                basket.add(items.get(itemInput - 1));
            }else {
                System.out.println("The item doesn't exist\n");
            }
        }
    }
}
