package org.stealthrobotics.stealthylib.core.math.interpolation;

/**
 * An interface for defining interpolation functions such as linear, cubic, etc.
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public interface InterpolationFunction <K, V extends Number>{

    /**
     * Interpolates a value given two key-value pairs and a key to interpolate
     * @param lowerKey The lower key
     * @param lowerValue The lower value
     * @param upperKey The upper key
     * @param upperValue The upper value
     * @param toInterpolate The key to interpolate
     * @return The interpolated value
     */
    V interpolate(K lowerKey, V lowerValue, K upperKey, V upperValue, K toInterpolate);
}
