package org.stealthrobotics.stealthylib.core.controllers;

/*----------------------------------------------------------------------------*/
/* Copied from FTCLib and modified to use StealthyLib's controller config     */
/* system.                                                                    */
/*                                                                            */
/* Original source:                                                           */
/* https://github.com/FTCLib/FTCLib/blob/1c8995d09413b406e0f4aff238e          */
/* a4edc2bb860c4/core/src/main/java/com/arcrobotics/ftclib/controller/        */
/* PController.java                                                        */
/*----------------------------------------------------------------------------*/

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