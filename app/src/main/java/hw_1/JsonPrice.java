package hw_1;

import lombok.Data;

@Data
public class JsonPrice {
    private Character goods;
    private float price;
    private boolean promotional;
    private int promotionalQuantity;
    private float promotionalPrice;

}
