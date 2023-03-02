import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest extends TestBase {

    IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    @DisplayName("Проверка цены ингредиента")
    public void getPriceIngredient() {

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        float actualPrice = ingredient.getPrice();

        assertEquals(price, actualPrice, 0);
    }

    @Test
    @DisplayName("Проверка названия ингредиента")
    public void getNameIngredient() {

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        String actualName = ingredient.getName();

        assertEquals(name, actualName);
    }

    @Test
    @DisplayName("Проверка типа ингредиента")
    public void getTypeIngredient() {

        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        IngredientType actualType = ingredient.getType();

        assertEquals(ingredientType, actualType);
    }
}
