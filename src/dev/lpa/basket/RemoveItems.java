package dev.lpa.basket;

import dev.lpa.bill.Bill;
import dev.lpa.clothes.Item;

import java.util.*;

public class RemoveItems {
    private List<Item> basket;

    public RemoveItems(List<Item> basket) {
        this.basket = basket;
    }


    public void RemoveItems() {
        int j = 0;
        List<String> itemsToRemove = new ArrayList<>();
        System.out.println("Your current basket: ");
        for(int i = 0; i < basket.size(); i++) {
            basket.get(i).showItem(i++);
            i++;;
        }
        System.out.println("--------------------");
        System.out.println("Which items do you want to cancel(separate them using commas): ");
        Scanner scanner = new Scanner(System.in);
        String cancel = scanner.nextLine();
        itemsToRemove = new ArrayList<>(Arrays.asList(cancel.split(",")));
        Collections.sort(itemsToRemove);
        for(int i = 0; i < itemsToRemove.size(); i++) {
                basket.remove(Integer.valueOf((String) itemsToRemove.get(i)) - 1 - j);
                j++;
        }
        System.out.println("Now your basket is: ");
        for(int i = 0; i < basket.size(); i++) {
            basket.get(i).showItem(i++);
            i++;
        }
        System.out.println("--------------------");
    }
}
