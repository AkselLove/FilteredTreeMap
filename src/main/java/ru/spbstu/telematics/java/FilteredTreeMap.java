package ru.spbstu.telematics.java;

import java.util.*;
import java.util.function.Predicate;

public class FilteredTreeMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {
    private final TreeMap<K, V> treeMap;

    public FilteredTreeMap() {
        this.treeMap = new TreeMap<>();
    }

    @Override
    public int size() {
        return treeMap.size();
    }

    @Override
    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return treeMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return treeMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return treeMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        return treeMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return treeMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        treeMap.putAll(m);
    }

    @Override
    public void clear() {
        treeMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return treeMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return treeMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return treeMap.entrySet();
    }

    // Реализация Iterable
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return treeMap.entrySet().iterator();
    }

    // Функция фильтрации по ключам
    public FilteredTreeMap<K, V> filterKeys(Predicate<K> predicate) {
        FilteredTreeMap<K, V> filteredMap = new FilteredTreeMap<>();
        for (Map.Entry<K, V> entry : this.treeMap.entrySet()) {
            if (predicate.test(entry.getKey())) {
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredMap;
    }
}

