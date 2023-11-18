package org.stealthrobotics.stealthylib.core.math.interpolation.utils;

import org.stealthrobotics.stealthylib.core.math.MathUtils;
import org.stealthrobotics.stealthylib.core.math.interpolation.InterpolationFunction;

/**
 * A linear interpolation function for Doubles
 */
public class DoubleLinearInterpolationFunction implements InterpolationFunction<Double, Double> {
    @Override
    public Double interpolate(Double lowerKey, Double lowerValue, Double upperKey, Double upperValue, Double toInterpolate) {
        return MathUtils.interpolateKeyValuePairLinear(lowerValue, upperValue, lowerKey, upperKey, toInterpolate);
    }
}
