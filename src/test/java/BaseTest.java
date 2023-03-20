import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void cleanUp() {
    }
}