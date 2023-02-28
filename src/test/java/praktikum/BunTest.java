package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameBun() {
        String expectedName = "black bun";
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceBun() {
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

}
