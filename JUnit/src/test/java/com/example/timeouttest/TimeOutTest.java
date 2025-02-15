package timeouttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import com.timeoutclass.TimeOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeOutTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        assertEquals("Finished", TimeOut.longRunningTask());
    }
}