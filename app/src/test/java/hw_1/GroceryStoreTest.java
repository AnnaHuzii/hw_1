package hw_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class GroceryStoreTest {

    @Test
    public void quantityOneMultipliedByPriceGoodsAPlusUnnecessaryCharacters(){

        float actual = new GroceryStore().calculateTotalCost("-/A I_");
        float expected = 1.25F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityOneMultipliedByPriceGoodsI(){

        float actual = new GroceryStore().calculateTotalCost("I");
        float expected = 0.00F;
        Assertions.assertEquals(expected, actual);
    }

   @Test
    public void quantityOneMultipliedByPriceGoodsA(){

        float actual = new GroceryStore().calculateTotalCost("A");
        float expected = 1.25F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeMultipliedByPriceGoodsA(){
        float actual = new GroceryStore().calculateTotalCost("AAA");
        float expected = 3.00F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityThreeMultipliedByPriceGoodsB(){
        float actual = new GroceryStore().calculateTotalCost("BBB");
        float expected = 12.75F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantityOneMultipliedByPriceGoodsC(){
        float actual = new GroceryStore().calculateTotalCost("C");
        float expected = 1.0F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantitySixMultipliedByPriceGoodsC(){
        float actual = new GroceryStore().calculateTotalCost("CCCCCC");
        float expected = 5.0F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void quantitySixMultipliedByPriceGoodsD(){
        float actual = new GroceryStore().calculateTotalCost("DD");
        float expected = 1.5F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void examplePromotionalQuantityAMultipliedByPriceAllGoodsPlusI(){
        float actual = new GroceryStore().calculateTotalCost("ABCDABAI");
        float expected = 13.25F;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void examplePromotionalQuantityAMultipliedByPriceAllGoods(){
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
    public void jsonPriceGoodsAll(){
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

    @Test
    public void jsonPriceGoodsAbsent(){
        JsonPrice actual = new GroceryStore().jsonePriceGoods('I');
        Assertions.assertNull(actual);
    }

}
