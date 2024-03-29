package org.stealthrobotics.stealthylib.core.controllers;

/**
 * A class containing various configs for controllers.
 */

public abstract class ControllerConfigs {

    private ControllerConfigs() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * A config for a simple elevator feedforward.
     */

    public static class ElevatorFeedforwardConfig {
        public double ks;
        public double kg;
        public double kv;
        public double ka;

        public ElevatorFeedforwardConfig() {
            this.ks = 0;
            this.kg = 0;
            this.kv = 0;
            this.ka = 0;
        }

        public ElevatorFeedforwardConfig(double ks, double kg, double kv, double ka) {
            this.ks = ks;
            this.kg = kg;
            this.kv = kv;
            this.ka = ka;
        }
    }

    /**
     * A config for a simple arm feedforward.
     */

    public static class ArmFeedforwardConfig {
        public double ks;
        public double kcos;
        public double kv;
        public double ka;

        public ArmFeedforwardConfig() {
            this.ks = 0;
            this.kcos = 0;
            this.kv = 0;
            this.ka = 0;
        }

        public ArmFeedforwardConfig(double ks, double kcos, double kv, double ka) {
            this.ks = ks;
            this.kcos = kcos;
            this.kv = kv;
            this.ka = ka;
        }
    }

    /**
     * A config for a simple motor feedforward.
     */

    public static class SimpleMotorFeedforwardConfig {
        public double ks;
        public double kv;
        public double ka;

        public SimpleMotorFeedforwardConfig() {
            this.ks = 0;
            this.kv = 0;
            this.ka = 0;
        }

        public SimpleMotorFeedforwardConfig(double ks, double kv, double ka) {
            this.ks = ks;
            this.kv = kv;
            this.ka = ka;
        }
    }

    /**
     * A config for a bang-bang controller.
     */

    public static class BangBangControllerConfig {
        public double tolerance;

        public BangBangControllerConfig() {
            this.tolerance = Double.POSITIVE_INFINITY;
        }

        public BangBangControllerConfig(double tolerance) {
            this.tolerance = tolerance;
        }
    }

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

        public PIDFControllerConfig() {
            this.kP = 0;
            this.kI = 0;
            this.kD = 0;
            this.kF = 0;
            this.minIntegral = -1;
            this.maxIntegral = 1;
            this.positionTolerance = 0.05;
            this.velocityTolerance = Double.POSITIVE_INFINITY;
        }

        public PIDFControllerConfig(double kP, double kI, double kD, double kF) {
            this.kP = kP;
            this.kI = kI;
            this.kD = kD;
            this.kF = kF;
            this.minIntegral = -1;
            this.maxIntegral = 1;
            this.positionTolerance = 0;
            this.velocityTolerance = 0;
        }

        public PIDFControllerConfig(double kP, double kI, double kD, double kF, double minIntegral, double maxIntegral, double positionTolerance, double velocityTolerance) {
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
        public PIDControllerConfig() {
            super();
        }

        public PIDControllerConfig(double kP, double kI, double kD) {
            super(kP, kI, kD, 0);
        }

        public PIDControllerConfig(double kP, double kI, double kD, double minIntegral, double maxIntegral, double positionTolerance, double velocityTolerance) {
            super(kP, kI, kD, 0, minIntegral, maxIntegral, positionTolerance, velocityTolerance);
        }
    }

    /**
     * A config for a PD controller.
     */

    public static class PDControllerConfig extends PIDControllerConfig {
        public PDControllerConfig() {
            super();
        }

        public PDControllerConfig(double kP, double kD) {
            super(kP, 0, kD);
        }

        public PDControllerConfig(double kP, double kD, double positionTolerance, double velocityTolerance) {
            super(kP, 0, kD, -1, 1, positionTolerance, velocityTolerance);
        }
    }

    /**
     * A config for a P controller.
     */

    public static class PControllerConfig extends PDControllerConfig {
        public PControllerConfig() {
            super();
        }

        public PControllerConfig(double kP) {
            super(kP, 0);
        }

        public PControllerConfig(double kP, double positionTolerance) {
            super(kP, 0, positionTolerance, Double.POSITIVE_INFINITY);
        }
    }
}
