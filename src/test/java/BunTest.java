import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest extends TestBase {

    @Mock
    Bun bun;

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bun() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    @DisplayName("Проверка названия булочки")
    public void getNameBun() {

        Bun bun = new Bun(name, price);

        String actualName = bun.getName();

        assertEquals(name, actualName);
    }

    @Test
    @DisplayName("Проверка цены булочки")
    public void getPriceBun() {

        Bun bun = new Bun(name, price);

        float actualPrice = bun.getPrice();

        assertEquals(price, actualPrice, 0);
    }

    @Test
    @DisplayName("Проверка количества вызовов метода получения имени булочки")
    public void getNameBunMock() {

        bun.getName();
        bun.getName();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    @DisplayName("Проверка количества вызовов метода получения цены булочки")
    public void getPriceBunMock() {

        bun.getPrice();
        bun.getPrice();
        bun.getPrice();
        Mockito.verify(bun, Mockito.times(3)).getPrice();
    }
}
