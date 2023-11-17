package org.stealthrobotics.stealthylib.core.controllers;

/*----------------------------------------------------------------------------*/
/* Copied from FTCLib and modified to use StealthyLib's controller config     */
/* system.                                                                    */
/*                                                                            */
/* Original source:                                                           */
/* https://github.com/FTCLib/FTCLib/blob/1c8995d09413b406e0f4aff238e          */
/* a4edc2bb860c4/core/src/main/java/com/arcrobotics/ftclib/controller/        */
/* PDController.java                                                        */
/*----------------------------------------------------------------------------*/

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