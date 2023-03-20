import praktikum.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

public class BurgerTest extends BaseTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Test
    @DisplayName("Проверка на создание булочки")
    public void checkSetBuns() {

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);

        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    @DisplayName("Проверка на добавление ингредиентов бургера")
    public void checkAddIngredients() {

        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientOne.getPrice()).thenReturn(100F);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredientOne);

        assertEquals(List.of(ingredientOne), burger.ingredients);
    }

    @Test
    @DisplayName("Проверка на удаление ингредиента бургера")
    public void checkRemoveIngredient() {

        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredientOne);

        Mockito.when(ingredientOne.getType()).thenReturn(null);

        burger.removeIngredient(0);

        assertEquals(List.of(), burger.ingredients);
    }

    @Test
    @DisplayName("Проверка на перемещение ингредиентов бургера")
    public void moveIngredient() {

        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(1, 0);

        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);

        assertEquals(List.of(ingredientTwo).get(0), burger.ingredients.get(0));
    }

    @Test
    @DisplayName("Проверка на получение стоимости бургера")
    public void checkGetPrice() {

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);

        float expectedPrice = 300;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    @DisplayName("Проверка на получение рецепта бургера")
    public void checkGetReceipt() {

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientOne.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);

        assertNotNull(burger.getReceipt());
    }
}