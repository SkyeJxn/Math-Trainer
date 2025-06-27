package core;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class statisticTest {
    
    @Test
    void testStatisticUpdate(){
        Statistics stat = new Statistics();
        int n = 6;

        for(int i = 1; i<=n; i++){
            stat.addCount(i%2 == 0);
        }

        assertEquals(n/2,stat.getRightCount());
        assertEquals(n/2, stat.getWrongCount());
    }
}
