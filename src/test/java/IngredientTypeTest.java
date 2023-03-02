import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientTypeTest extends TestBase {

    @Test
    @DisplayName("Проверка названий типов ингридиентов")
    public void getNameIngredientType() {

        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertNotEquals("SAUCE", IngredientType.FILLING.name());
    }
}
