package org.stealthrobotics.stealthylib.core.controllers;

public class PDController extends PIDController {

    /**
     * Creates a PD controller with the given constants.
     *
     * @param kP The proportional constant.
     * @param kD The derivative constant.
     */
    public PDController(double kP, double kD) {
        this(new ControllerConfigs.PDControllerConfig(kP, kD));
    }

    /**
     * Creates a PD controller with the given constants.
     *
     * @param kP The proportional constant.
     * @param kD The derivative constant.
     * @param positionTolerance The position tolerance.
     * @param velocityTolerance The velocity tolerance.
     */
    public PDController(double kP, double kD, double positionTolerance, double velocityTolerance) {
        this(new ControllerConfigs.PDControllerConfig(kP, kD, positionTolerance, velocityTolerance));
    }

    /**
     * Creates a PD controller with the given config.
     *
     * @param config The config.
     */
    public PDController(ControllerConfigs.PDControllerConfig config) {
        super(config);
    }
}