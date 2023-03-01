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

import static org.junit.Assert.*;

public class BurgerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test // DONE
    public void checkSetBuns() {

        Bun bun = new Bun("red bun", 300);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test // DONE
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

    @Test // DONE
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
        System.out.println(ingredientList);
        System.out.println(burger.ingredients);
        assertEquals(ingredientList, burger.ingredients);
    }

    @Test
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }


    @Test
    public void getReceipt() {
    }
}