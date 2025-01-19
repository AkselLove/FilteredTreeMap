package ru.spbstu.telematics.java;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class FilteredTreeMapTest {

    @Test
    public void testPutAndGet() {
        FilteredTreeMap<Integer, String> map = new FilteredTreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        assertEquals("One", map.get(1));
        assertEquals("Two", map.get(2));
        assertEquals("Three", map.get(3));
    }

    @Test
    public void testSizeAndRemove() {
        FilteredTreeMap<Integer, String> map = new FilteredTreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        assertEquals(2, map.size());

        map.remove(1);
        assertEquals(1, map.size());
        assertNull(map.get(1));
    }

    @Test
    public void testFilterKeys() {
        FilteredTreeMap<Integer, String> map = new FilteredTreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        FilteredTreeMap<Integer, String> filteredMap = map.filterKeys(key -> key > 1);

        assertEquals(2, filteredMap.size());
        assertTrue(filteredMap.containsKey(2));
        assertTrue(filteredMap.containsKey(3));
        assertFalse(filteredMap.containsKey(1));
    }

    @Test
    public void testContains() {
        FilteredTreeMap<Integer, String> map = new FilteredTreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(3));
        assertTrue(map.containsValue("Two"));
        assertFalse(map.containsValue("Three"));
    }

    @Test
    public void compareWithTreeMap() {
        FilteredTreeMap<Integer, String> filteredTreeMap = new FilteredTreeMap<>();
        TreeMap<Integer, String> standardTreeMap = new TreeMap<>();

        filteredTreeMap.put(1, "One");
        filteredTreeMap.put(2, "Two");
        filteredTreeMap.put(3, "Three");

        standardTreeMap.put(1, "One");
        standardTreeMap.put(2, "Two");
        standardTreeMap.put(3, "Three");

        // Сравнение размерности
        assertEquals(standardTreeMap.size(), filteredTreeMap.size());

        // Сравнение значений
        for (Map.Entry<Integer, String> entry : standardTreeMap.entrySet()) {
            assertEquals(entry.getValue(), filteredTreeMap.get(entry.getKey()));
        }

        // Удаление элемента и повторная проверка
        filteredTreeMap.remove(1);
        standardTreeMap.remove(1);
        assertEquals(standardTreeMap.size(), filteredTreeMap.size());
        assertNull(filteredTreeMap.get(1));
    }
}
