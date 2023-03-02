import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.MockitoConfigurationException;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import static org.junit.Assert.*;

public class BurgerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void checkSetBuns() {

        Bun bun = new Bun("red bun", 300);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredients() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        System.out.println(burger.ingredients);
        System.out.println(ingredientList);
        assertEquals(ingredientList, burger.ingredients);
    }

    @Test
    public void checkRemoveIngredient() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        System.out.println(ingredientList);
        System.out.println(burger.ingredients);
        ingredientList.remove(0);
        burger.removeIngredient(0);
        assertEquals(ingredientList, burger.ingredients);
        System.out.println(ingredientList);
        System.out.println(burger.ingredients);
    }

    @Test
    public void moveIngredient() {

        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredienteeFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredienteeFilling);
        System.out.println(ingredientList);
        ingredientList.add(1, ingredientList.remove(0));
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredienteeFilling);
        System.out.println(burger.ingredients);
        burger.moveIngredient(1, 0);
        assertEquals(ingredientList, burger.ingredients);
        System.out.println(ingredientList);
        System.out.println(burger.ingredients);
    }

    @Test
    public void checkGetPrice() {

        Burger burger = new Burger();

        Bun bun = new Bun("black bun", 100);
        float price = bun.getPrice() * 2;

        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredienteeFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredienteeFilling);

        for (
                Ingredient ingredient : ingredientList) {
            price += ingredient.getPrice();
        }

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredienteeFilling);

        float actualPrice = burger.getPrice();

        assertEquals(price, actualPrice, 0);
        System.out.println(price);
        System.out.println(actualPrice);
    }

    @Test
    public void getReceipt() {

        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredienteeFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredientSauce);
        ingredientList.add(ingredienteeFilling);

        for (Ingredient ingredient: ingredientList) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredienteeFilling);

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

      StringBuilder actualReceipt = new StringBuilder(burger.getReceipt());

        assertNotNull(actualReceipt);
        System.out.println(actualReceipt);
    }
}