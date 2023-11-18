package org.stealthrobotics.stealthylib.core.math.interpolation;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * A TreeMap that interpolates values between keys
 * @param <K>
 * @param <V>
 */

public class InterpolationTreeMap<K extends Comparable<K>, V extends Number> {
    private final NavigableMap<K, V> data;
    private InterpolationFunction<K, V> interpolationFunction;

    /**
     * Creates a new InterpolationTreeMap with a passed in interpolation function
     */
    public InterpolationTreeMap(InterpolationFunction<K, V> interpolationFunction) {
        this.data = new TreeMap<>();
        this.interpolationFunction = interpolationFunction;
    }

    /**
     * Sets the interpolation function for this InterpolationTreeMap
     * @param interpolationFunction
     */
    public void setInterpolationFunction(InterpolationFunction<K, V> interpolationFunction) {
        this.interpolationFunction = interpolationFunction;
    }

    /**
     * Puts a key-value pair into the InterpolationTreeMap
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        data.put(key, value);
    }

    /**
     * Interpolates a value given a key
     * @param key
     * @return The interpolated value
     */
    public V interpolate(K key) {
        K lowerKey = data.floorKey(key);
        K upperKey = data.ceilingKey(key);
        if (lowerKey == null || upperKey == null) {
            throw new IllegalArgumentException("Key is out of bounds");
        }
        V lowerValue = data.get(lowerKey);
        V upperValue = data.get(upperKey);

        return interpolationFunction.interpolate(lowerKey, lowerValue, upperKey, upperValue, key);
    }
}
