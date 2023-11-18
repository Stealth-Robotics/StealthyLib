package org.stealthrobotics.stealthylib.core.math;

public final class MathUtils {
    private MathUtils() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated"
        );
    }

    /**
     * Interpolates a value given a lower value, an upper value, and a key to interpolate
     * @param lowerValue The lower value
     * @param upperValue The upper value
     * @param toInterpolate The key to interpolate
     * @return The interpolated value
     */
    public static double interpolateLinear(double lowerValue, double upperValue, double toInterpolate) {
        return lowerValue + (toInterpolate * (upperValue - lowerValue));
    }

    /**
     * Interpolates a value given two key-value pairs and a key to interpolate
     * @param lowerValue The lower value
     * @param upperValue The upper value
     * @param lowerBound The lower key
     * @param upperBound The upper key
     * @param toInterpolate The key to interpolate
     * @return The interpolated value
     */
    public static double interpolateKeyValuePairLinear(double lowerValue, double upperValue, double lowerBound, double upperBound, double toInterpolate) {
        return lowerValue + (toInterpolate - lowerBound) * (upperValue - lowerValue) / (upperBound - lowerBound);
    }

}
