package hw_1;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GroceryStore groceryStore = new GroceryStore();
        System.out.println(groceryStore.calculateTotalCost("ABCDABA"));
    }
}
