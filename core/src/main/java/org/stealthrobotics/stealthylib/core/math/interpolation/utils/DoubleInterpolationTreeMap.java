package org.stealthrobotics.stealthylib.core.math.interpolation.utils;

import org.stealthrobotics.stealthylib.core.math.interpolation.InterpolationFunction;
import org.stealthrobotics.stealthylib.core.math.interpolation.InterpolationTreeMap;

/**
 * A TreeMap that interpolates values between keys. Both the keys and values are assumed Doubles.
 */
public class DoubleInterpolationTreeMap extends InterpolationTreeMap<Double, Double> {

    /**
     * Creates a new DoubleInterpolationTreeMap with a linear interpolation function
     */
    public DoubleInterpolationTreeMap() {
        this(new DoubleLinearInterpolationFunction());
    }

    /**
     * Creates a new DoubleInterpolationTreeMap with a passed in interpolation function
     * @param interpolationFunction The interpolation function to use
     */
    public DoubleInterpolationTreeMap(InterpolationFunction<Double, Double> interpolationFunction) {
        super(interpolationFunction);
    }
}
