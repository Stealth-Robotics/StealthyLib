package org.stealthrobotics.stealthylib.core.controllers;

public class PIDController extends PIDFController {

    /**
     * Creates a PID controller with the given constants.
     *
     * @param kP The proportional constant.
     * @param kI The integral constant.
     * @param kD The derivative constant.
     */

    public PIDController(double kP, double kI, double kD) {
       this(new ControllerConfigs.PIDControllerConfig(kP, kI, kD));
    }

    /**
     * Creates a PID controller with the given constants.
     *
     * @param kP The proportional constant.
     * @param kI The integral constant.
     * @param kD The derivative constant.
     * @param minIntegral The minimum integral value.
     * @param maxIntegral The maximum integral value.
     */

    public PIDController(double kP, double kI, double kD, double minIntegral, double maxIntegral, double positionTolerance, double velocityTolerance) {
        this(new ControllerConfigs.PIDControllerConfig(kP, kI, kD, minIntegral, maxIntegral, positionTolerance, velocityTolerance));
    }

    /**
     * Creates a PID controller with the given config.
     *
     * @param config The config.
     */

    public PIDController(ControllerConfigs.PIDControllerConfig config) {
        super(config);
    }
}
