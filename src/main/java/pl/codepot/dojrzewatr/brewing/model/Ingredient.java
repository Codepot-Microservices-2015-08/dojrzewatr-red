package pl.codepot.dojrzewatr.brewing.model;

/**
 * Created by kedzior on 28.08.15.
 */
public class Ingredient {
    private String type;
    private Integer quantity;

    @Override
    public String toString() {
        return "Ingredient{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
