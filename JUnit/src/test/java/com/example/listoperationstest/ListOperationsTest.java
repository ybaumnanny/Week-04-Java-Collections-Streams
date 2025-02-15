package listoperationstest;

import static org.junit.jupiter.api.Assertions.*;

import com.listoperationsclass.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after adding an element.");
        assertTrue(list.contains(5), "List should contain the added element.");
    }

    @Test
    void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        listManager.removeElement(list, 10);
        assertEquals(1, list.size(), "List size should be 1 after removing an element.");
        assertFalse(list.contains(10), "List should not contain the removed element.");
    }

    @Test
    void testGetSize() {
        listManager.addElement(list, 1);
        listManager.addElement(list, 2);
        listManager.addElement(list, 3);
        assertEquals(3, listManager.getSize(list), "List size should be 3.");
    }
}
