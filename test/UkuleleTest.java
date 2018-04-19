import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UkuleleTest {

    private static Ukulele uke;

    @BeforeClass
    public static void setUpClass() {
        uke = new Ukulele();
    }

    @Test
    public void testToString() {
        assertEquals("Ukulele", uke.toString());
    }

    @Test
    public void testTuningID() {
        assertEquals("Default re-entrant GCEA tuning", uke.tuningID());
    }
}