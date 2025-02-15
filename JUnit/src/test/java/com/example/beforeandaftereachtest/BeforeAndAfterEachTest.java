package beforeandaftereachtest;

import com.beforeandaftereachclass.BeforeAndAfterEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeforeAndAfterEachTest {
    private BeforeAndAfterEach dbConnection;

    // This method runs before each test and initializes the connection.
    @BeforeEach
    public void setUp() {
        dbConnection = new BeforeAndAfterEach();
        dbConnection.connect();
    }

    // This method runs after each test and ensures the connection is closed.
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }

    // Test to verify that the connection is established before each test.
    @Test
    public void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "The database connection should be established.");
    }

    // Test to verify that disconnect() properly closes the connection.
    @Test
    public void testConnectionIsClosed() {
        // Manually disconnect to simulate closing the connection
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "The database connection should be closed.");
    }
}
