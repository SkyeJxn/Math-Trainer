import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LivesTest {

    @Test
    void testChanges(){
        Lives lv = new Lives(3);

        lv.changeCurrent(-1);
        assertEquals(2, lv.getCurrent());

        lv.changeCurrent(2);
        assertEquals(3, lv.getCurrent());
    }

    @Test
    void testAlive(){
        Lives lv = new Lives(2);
        assertTrue(lv.alive());

        lv.changeCurrent(-2);
        assertFalse(lv.alive());

        lv.changeCurrent(1);
        assertTrue(lv.alive());
    }
}
