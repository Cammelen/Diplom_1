import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "red bun", 300);

    @Test
    public void getPriceIngredient() {

        float expectedPrice = 300;
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameIngredient() {

        String expectedName = "red bun";
        String actualName = ingredient.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeIngredient() {

        IngredientType e = IngredientType.SAUCE;
        IngredientType a = ingredient.getType();

        assertEquals(e, a);
    }
}
