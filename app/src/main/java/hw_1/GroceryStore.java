package hw_1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryStore {

    public float calculateTotalCost(String goods) throws FileNotFoundException {
        float sum;
        float sumAll = 0;
        for (Character product : quantityGoods(goods).keySet()) {

            int quantity = quantityGoods(goods).get(product);
            float price = jsonePriceGoods(product).getPrice();
            boolean promotional = jsonePriceGoods(product).isPromotional();
            int promotionalQuantity = jsonePriceGoods(product).getPromotionalQuantity();
            float promotionalPrice = jsonePriceGoods(product).getPromotionalPrice();

            if (promotional) {
                if (quantity >= promotionalQuantity) {
                    sum = (promotionalPrice / promotionalQuantity) * quantity;
                } else {
                    sum = price * quantity;
                }
            } else {
                sum = price * quantity;
            }
            sumAll += sum;
        }

        BigDecimal result = new BigDecimal(Double.toString(sumAll));
        result = result.setScale(2, RoundingMode.HALF_UP);
        sum = result.floatValue();
        return sum;
    }

    public JsonPrice jsonePriceGoods(Character product) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader file = new FileReader("C:\\AnnaHuzii\\study java\\java_developer_hw\\jsonPrice.json");
        Type typeToken = TypeToken
                .getParameterized(List.class, JsonPrice.class)
                .getType();
        List<JsonPrice> jsonPrice = gson.fromJson(file, typeToken);
        JsonPrice data = null;
        for (JsonPrice price : jsonPrice) {
            if (product.equals(price.getGoods())) {
                data = price;
            }
        }
        return data;
    }

    public Map<Character, Integer> quantityGoods(String goods) {

        Integer quantity;
        Map<Character, Integer> quantityMap = new HashMap<>();
        for (int i = 0; i < goods.length(); i++) {
            quantity = quantityMap.get(goods.charAt(i));
            if (quantity == null) quantityMap.put(goods.charAt(i), 1);
            else quantityMap.put(goods.charAt(i), ++quantity);
        }
        return quantityMap;
    }
}

