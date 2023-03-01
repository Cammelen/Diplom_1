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


    @Test // DONE
    public void checkSetBuns() {

        Bun bun = new Bun("red bun", 300);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test // DONE
    public void checkAddIngredients() {

        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Burger burger = new Burger();
        burger.ingredients.add(ingredientSauce);
        System.out.println(ingredientSauce.getName());
        assertNotNull(ingredientSauce);
        assertEquals("hot sauce", ingredientSauce.getName());
    }

    @Test
    public void removeIngredient() {
    }

    @Test
    public void moveIngredient() {
    }


    @Test
    public void getReceipt() {
    }
}