import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameBun() {
        String expectedName = "black bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceBun() {
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
