package hw_1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryStore {
    private static final String PRICES_FILE_PATH = "jsonPrice.json";

    public float calculateTotalCost(String goods) {
        String newGoods = goods.replaceAll("[ |_/-]", "");
        float sum;
        float sumAll = 0;
        for (Character product : quantityGoods(newGoods).keySet()) {

            int quantity = quantityGoods(newGoods).get(product);
            if (jsonePriceGoods(product) != null) {
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
            } else {
                return sumAll;
            }
        }

        BigDecimal result = new BigDecimal(Double.toString(sumAll));
        result = result.setScale(2, RoundingMode.HALF_UP);
        sum = result.floatValue();
        return sum;
    }

    public JsonPrice jsonePriceGoods(Character product) {
        Gson gson = new Gson();
        JsonPrice data = null;
        try (FileReader file = new FileReader(PRICES_FILE_PATH)) {
            Type typeToken = TypeToken
                    .getParameterized(List.class, JsonPrice.class)
                    .getType();
            List<JsonPrice> jsonPrice = gson.fromJson(file, typeToken);
            for (JsonPrice price : jsonPrice) {
                if (product.equals(price.getGoods())) {
                    data = price;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("File '%s' not found", PRICES_FILE_PATH));
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

