package hw_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GroceryStoreTest {
    @Mock
    //you don't need mock it because you test the class
    //actually you have to mock your data source but in your implementation it will be not simple
    private GroceryStore groceryStore;

   @Test
    public void quantityOneMultipliedByPriceGoodsA() throws FileNotFoundException {

        float actual = new GroceryStore().calculateTotalCost("A");
        float expected = 1.25F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeMultipliedByPriceGoodsA() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("AAA");
        float expected = 3.00F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeMultipliedByPriceGoodsB() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("BBB");
        float expected = 12.75F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityOneMultipliedByPriceGoodsC() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("C");
        float expected = 1.0F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantitySixMultipliedByPriceGoodsC() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("CCCCCC");
        float expected = 5.0F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantitySixMultipliedByPriceGoodsD() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("DD");
        float expected = 1.5F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void examplePromotionalQuantityAMultipliedByPriceAllGoods() throws FileNotFoundException {
        float actual = new GroceryStore().calculateTotalCost("ABCDABA");
        float expected = 13.25F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeGoodsA() {
        Map<Character, Integer> actual = new GroceryStore().quantityGoods("AAA");
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeGoodsAQuantityOneGoodsB() {
        Map<Character, Integer> actual = new GroceryStore().quantityGoods("ABAA");
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A', 3);
        expected.put('B', 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void jsonPriceGoodsAll() throws IOException {
        JsonPrice actual = new GroceryStore().jsonePriceGoods('A');
        JsonPrice expected = new JsonPrice();
        expected.setGoods('A');
        expected.setPrice(1.25F);
        expected.setPromotional(true);
        expected.setPromotionalQuantity(3);
        expected.setPromotionalPrice(3.00F);
        Assertions.assertEquals(
                expected, actual);
    }

    //add also test for wrong input
}
