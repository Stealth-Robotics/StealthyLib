package org.stealthrobotics.stealthylib.core.controllers;

public class PController extends PDController {

    /**
     * Creates a P controller with the given constants.
     *
     * @param kP The proportional constant.
     */
    public PController(double kP) {
        this(new ControllerConfigs.PControllerConfig(kP));
    }

    /**
     * Creates a P controller with the given constants.
     *
     * @param kP The proportional constant.
     * @param positionTolerance The position tolerance.
     */
    public PController(double kP, double positionTolerance) {
        this(new ControllerConfigs.PControllerConfig(kP, positionTolerance));
    }

    /**
     * Creates a P controller with the given config.
     *
     * @param config The config.
     */
    public PController(ControllerConfigs.PControllerConfig config) {
        super(config);
    }
}