import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    void testAddition() {
        assertEquals(5, Hello.add(2, 3));
    }
}