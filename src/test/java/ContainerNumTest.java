import org.example.ContainerNum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности
 */
public class ContainerNumTest {
    private ContainerNum container;

    /**
     * Инициализирует новый контейнер перед каждым тестом
     */
    @BeforeEach
    public void setUp() {
        container = new ContainerNum();
    }

    /**
     * Проверка пустого контейнера
     */
    @Test
    public void testEmptyContainer() {
        assertEquals(0, container.getSize());
        assertNull(container.getIndex(0));
    }

    /**
     * Тестирует добавление элементов в начало контейнера
     * Kорректность размера после добавления
     * Правильный порядок элементов
     * Состояние внутренних ссылок
     */
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

    /**
     * Тестирует добавление элементов в конец контейнера
     * Kорректность размера после добавления
     * Правильный порядок элементов
     * Состояние внутренних ссылок
     */
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

    /**
     * Тестирует вставку элемента по указанному индексу
     * Корректность вставки в середину списка
     * Сохранение порядка элементов
     * Обновление размера контейнера
     */
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


    /**
     * Тестирует удаление элемента из начала контейнера
     * Корректность размера после удаления
     * Обновление ссылки на первый элемент
     * Сохранение оставшихся элементов
     */
    @Test
    public void testDeleteFromFirst() {
        container.addToFirst(10);
        container.addToFirst(20);
        container.deleteFromFirst();

        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);
    }

    /**
     * Тестирует удаление элемента из конца контейнера
     * Корректность размера после удаления
     * Обновление ссылки на последний элемент
     * Сохранение оставшихся элементов
     */
    @Test
    public void testDeleteFromLast() {
        container.addToLast(10);
        container.addToLast(20);
        container.deleteFromLast();

        assertEquals(1, container.getSize());
        assertEquals(10, container.getIndex(0).number);
    }

    /**
     * Тестирует удаление элемента по указанному индексу
     * Корректность удаления из середины списка
     * Обновление связей между элементами
     * Корректность размера после удаления
     */
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

    /**
     * Тестирует извлечение элемента из начала контейнера
     * Корректность возвращаемого значения
     * Уменьшение размера контейнера
     * Обновление ссылки на первый элемент
     */
    @Test
    public void testTakeFirst() {
        container.addToFirst(10);
        container.addToFirst(20);
        int value = container.takeFirst();

        assertEquals(20, value);
        assertEquals(1, container.getSize());
    }

    /**
     * Тестирует извлечение элемента из конца контейнера
     * Корректность возвращаемого значения
     * Уменьшение размера контейнера
     * Обновление ссылки на последний элемент
     */
    @Test
    public void testTakeLast() {
        container.addToLast(10);
        container.addToLast(20);
        int value = container.takeLast();

        assertEquals(20, value);
        assertEquals(1, container.getSize());
    }

    /**
     * Тестирует извлечение элемента по указанному индексу
     * Корректность возвращаемого значения
     * Уменьшение размера контейнера
     * Обновление связей между элементами
     */
    @Test
    public void testTakeIndex() {
        container.addToLast(10);
        container.addToLast(20);
        container.addToLast(30);
        int value = container.takeIndex(1);

        assertEquals(20, value);
        assertEquals(2, container.getSize());
    }

    /**
     * Тестирует при извлечении из пустого контейнера
     */
    @Test
    public void testTakeFromEmptyContainerThrowsException() {
        assertThrows(IllegalStateException.class, () -> container.takeFirst());
        assertThrows(IllegalStateException.class, () -> container.takeLast());
        assertThrows(IllegalStateException.class, () -> container.takeIndex(0));
    }

    /**
     * Тестирует обработку отрицательных и превышающих размер контейнера индексов
     */
    @Test
    public void testInvalidIndex() {
        container.addToFirst(10);
        assertNull(container.getIndex(-1));
        assertNull(container.getIndex(1));
    }
}
