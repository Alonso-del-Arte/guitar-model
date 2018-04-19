import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarTest {

    @Test
    public void testGuitarExtendsStringedInstrument() {
        assertEquals(StringedInstrument.class, Guitar.class.getSuperclass());
    }

}
