import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void getNameIngredientType() {

        String expectedName = "SAUCE";
        String actualName = IngredientType.SAUCE.name();
        assertEquals(expectedName, actualName);
    }
}
