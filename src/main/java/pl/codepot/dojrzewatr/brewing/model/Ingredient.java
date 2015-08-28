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
}
