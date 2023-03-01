import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.MockitoConfigurationException;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.*;

public class BurgerTest {


    @Test
    public void checkSetBuns() {

        Bun bun = new Bun("red bun", 300);
        Burger burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredient() {
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