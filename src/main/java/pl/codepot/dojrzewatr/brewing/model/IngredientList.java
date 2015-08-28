package pl.codepot.dojrzewatr.brewing.model;

import java.util.List;

/**
 * Created by kedzior on 28.08.15.
 */
public class IngredientList {
    private List<Ingredient> ingredients;

    public IngredientList() {}
    public IngredientList(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "IngredientList{" +
                "ingredients=" + ingredients +
                '}';
    }
}
