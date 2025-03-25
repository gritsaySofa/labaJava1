import org.example.ContainerNum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerNumTest {
    private ContainerNum container;

    @BeforeEach
    public void setUp() {
        container = new ContainerNum();
    }

    @Test
    public void testEmptyContainer() {
        assertEquals(0, container.getSize());
        assertNull(container.getIndex(0));
    }

    @Test
    public void testAddToFirst() {
        container.addToFirst(10);
        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);

        container.addToFirst(20);
        assertEquals(2, container.getSize());
        assertEquals(20, container.getIndex(0).number);
        assertEquals(10, container.getIndex(1).number);
    }

    @Test
    public void testAddToLast() {
        container.addToLast(10);
        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);

        container.addToLast(20);
        assertEquals(2, container.getSize());
        assertEquals(10, container.getIndex(0).number);
        assertEquals(20, container.getIndex(1).number);
    }

    @Test
    public void testAddToIndex() {
        container.addToFirst(10);
        container.addToLast(30);
        container.addToIndex(20, 1);

        assertEquals(3, container.getSize());
        assertEquals(10, container.getIndex(0).number);
        assertEquals(20, container.getIndex(1).number);
        assertEquals(30, container.getIndex(2).number);
    }

    @Test
    public void testDeleteFromFirst() {
        container.addToFirst(10);
        container.addToFirst(20);
        container.deleteFromFirst();

        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);
    }

    @Test
    public void testDeleteFromLast() {
        container.addToLast(10);
        container.addToLast(20);
        container.deleteFromLast();

        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);
    }

    @Test
    public void testDeleteFromIndex() {
        container.addToLast(10);
        container.addToLast(20);
        container.addToLast(30);
        container.deleteFromIndex(1);

        assertEquals(2, container.getSize());
        assertEquals(10, container.getIndex(0).number);
        assertEquals(30, container.getIndex(1).number);
    }

    @Test
    public void testTakeFirst() {
        container.addToFirst(10);
        container.addToFirst(20);
        int value = container.takeFirst();

        assertEquals(20, value);
        assertEquals(1, container.getSize());
    }

    @Test
    public void testTakeLast() {
        container.addToLast(10);
        container.addToLast(20);
        int value = container.takeLast();

        assertEquals(20, value);
        assertEquals(1, container.getSize());
    }

    @Test
    public void testTakeIndex() {
        container.addToLast(10);
        container.addToLast(20);
        container.addToLast(30);
        int value = container.takeIndex(1);

        assertEquals(20, value);
        assertEquals(2, container.getSize());
    }

    @Test
    public void testTakeFromEmptyContainerThrowsException() {
        assertThrows(IllegalStateException.class, () -> container.takeFirst());
        assertThrows(IllegalStateException.class, () -> container.takeLast());
        assertThrows(IllegalStateException.class, () -> container.takeIndex(0));
    }

    @Test
    public void testInvalidIndex() {
        container.addToFirst(10);
        assertNull(container.getIndex(-1));
        assertNull(container.getIndex(1));
    }
}
