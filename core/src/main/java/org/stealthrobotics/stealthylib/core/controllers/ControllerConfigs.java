package org.stealthrobotics.stealthylib.core.controllers;

/**
 * A class containing various configs for controllers.
 */

public class ControllerConfigs {

    /**
     * A config for a PIDF controller.
     */

    public static class PIDFControllerConfig {
        public double kP;
        public double kI;
        public double kD;
        public double kF;
        public double minIntegral;
        public double maxIntegral;
        public double positionTolerance;
        public double velocityTolerance;

        public PIDFControllerConfig(){
            this.kP = 0;
            this.kI = 0;
            this.kD = 0;
            this.kF = 0;
            this.minIntegral = -1;
            this.maxIntegral = 1;
            this.positionTolerance = 0.05;
            this.velocityTolerance = Double.POSITIVE_INFINITY;
        }

        public PIDFControllerConfig(double kP, double kI, double kD, double kF){
            this.kP = kP;
            this.kI = kI;
            this.kD = kD;
            this.kF = kF;
            this.minIntegral = -1;
            this.maxIntegral = 1;
            this.positionTolerance = 0;
            this.velocityTolerance = 0;
        }

        public PIDFControllerConfig(double kP, double kI, double kD, double kF, double minIntegral, double maxIntegral, double positionTolerance, double velocityTolerance){
            this.kP = kP;
            this.kI = kI;
            this.kD = kD;
            this.kF = kF;
            this.minIntegral = minIntegral;
            this.maxIntegral = maxIntegral;
            this.positionTolerance = positionTolerance;
            this.velocityTolerance = velocityTolerance;
        }
    }

    /**
     * A config for a PID controller.
     */

    public static class PIDControllerConfig extends PIDFControllerConfig {
        public PIDControllerConfig(){
            super();
        }

        public PIDControllerConfig(double kP, double kI, double kD){
            super(kP, kI, kD, 0);
        }

        public PIDControllerConfig(double kP, double kI, double kD, double minIntegral, double maxIntegral, double positionTolerance, double velocityTolerance){
            super(kP, kI, kD, 0, minIntegral, maxIntegral, positionTolerance, velocityTolerance);
        }
    }

    /**
     * A config for a PD controller.
     */

    public static class PDControllerConfig extends PIDControllerConfig {
        public PDControllerConfig(){
            super();
        }

        public PDControllerConfig(double kP, double kD){
            super(kP, 0, kD);
        }

        public PDControllerConfig(double kP, double kD, double positionTolerance, double velocityTolerance){
            super(kP, 0, kD, -1, 1, positionTolerance, velocityTolerance);
        }
    }

    /**
     * A config for a P controller.
     */

    public static class PControllerConfig extends PDControllerConfig {
        public PControllerConfig(){
            super();
        }

        public PControllerConfig(double kP){
            super(kP, 0);
        }

        public PControllerConfig(double kP, double positionTolerance){
            super(kP, 0, positionTolerance, Double.POSITIVE_INFINITY);
        }
    }
}
