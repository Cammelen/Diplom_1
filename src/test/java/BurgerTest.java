import praktikum.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class BurgerTest extends TestBase {

    @Mock
    Bun bun;

    Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    List<Ingredient> ingredientList = new ArrayList<>();

    @Test
    @DisplayName("Проверка на создание булочки")
    public void checkSetBuns() {

        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);

        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    @DisplayName("Проверка на добавление ингредиентов бургера")
    public void checkAddIngredients() {

        Burger burger = new Burger();

        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredientFilling);

        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        assertEquals(ingredientList, burger.ingredients);
    }

    @Test
    @DisplayName("Проверка на удаление ингредиента бургера")
    public void checkRemoveIngredient() {

        Burger burger = new Burger();

        ingredientList.add(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        System.out.println(burger.ingredients);

        ingredientList.remove(0);
        burger.removeIngredient(0);

        assertEquals(ingredientList, burger.ingredients);
        System.out.println(burger.ingredients);
    }

    @Test
    @DisplayName("Проверка на перемещение ингредиентов бургера")
    public void moveIngredient() {

        Burger burger = new Burger();

        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredientFilling);
        ingredientList.add(1, ingredientList.remove(0));

        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(1, 0);

        assertEquals(ingredientList, burger.ingredients);
    }

    @Test
    @DisplayName("Проверка на получение стоимости бургера")
    public void checkGetPrice() {

        Burger burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(100F);

        float price = bun.getPrice() * 2;

        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredientFilling);

        for (
                Ingredient ingredient : ingredientList) {
            price += ingredient.getPrice();
        }

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        float actualPrice = burger.getPrice();

        assertEquals(price, actualPrice, 0);
        System.out.println(price);
        System.out.println(actualPrice);
    }

    @Test
    @DisplayName("Проверка на получение рецепта бургера")
    public void checkGetReceipt() {

        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("black bun");

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredientFilling);

        for (Ingredient ingredient : ingredientList) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        StringBuilder actualReceipt = new StringBuilder(burger.getReceipt());

        assertNotNull(actualReceipt);
        System.out.println(receipt);
        System.out.println(actualReceipt);
    }
}