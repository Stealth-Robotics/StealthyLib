package org.stealthrobotics.stealthylib.core.controllers;

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST and other WPILib contributors.                         */
/*                                                                            */
/* Open Source Software; you can modify and/or share it under the terms of    */
/* the WPILib BSD license file located in the root directory of this project. */
/*----------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------*/
/* Copied from WPILib and modified to use StealthyLib's controller config     */
/* system.                                                                    */
/*                                                                            */
/* Original source:                                                           */
/* https://github.com/wpilibsuite/allwpilib/blob/da3ec1be1077b180d1f730fc4ed7 */
/* 033720d8d78d/wpimath/src/main/java/edu/wpi/first/math/controller/          */
/* ArmFeedforward.java                                                        */
/*----------------------------------------------------------------------------*/

/**
 * A helper class that computes feedforward outputs for a simple arm (modeled as a motor
 * acting against the force of gravity on a beam suspended at an angle).
 */
@SuppressWarnings("MemberName")
public class ArmFeedforward {
    public final double ks;
    public final double kcos;
    public final double kv;
    public final double ka;

    /**
     * Creates a new ArmFeedforward with the specified gains.
     *
     * @param ks The static gain.
     * @param kcos The cosine gain.
     * @param kv The velocity gain.
     * @param ka The acceleration gain.
     */

    public ArmFeedforward(double ks, double kcos, double kv, double ka) {
        this(new ControllerConfigs.ArmFeedforwardConfig(ks, kcos, kv, ka));
    }

    /**
     * Creates a new ArmFeedforward from the config.
     *
     * @param config The feedforward config.
     */

    public ArmFeedforward(ControllerConfigs.ArmFeedforwardConfig config) {
        this.ks = config.ks;
        this.kcos = config.kcos;
        this.kv = config.kv;
        this.ka = config.ka;
    }

    /**
     * Calculates the feedforward from the gains and setpoints.
     *
     * @param velocityRadPerSec     The velocity setpoint.
     * @param accelRadPerSecSquared The acceleration setpoint.
     * @return The computed feedforward.
     */
    public double calculate(double positionRadians, double velocityRadPerSec,
                            double accelRadPerSecSquared) {
        return ks * Math.signum(velocityRadPerSec) + kcos * Math.cos(positionRadians)
                + kv * velocityRadPerSec
                + ka * accelRadPerSecSquared;
    }

    /**
     * Calculates the feedforward from the gains and velocity setpoint (acceleration is assumed to
     * be zero).
     *
     * @param velocity The velocity setpoint.
     * @return The computed feedforward.
     */
    public double calculate(double positionRadians, double velocity) {
        return calculate(positionRadians, velocity, 0);
    }

    // Rearranging the main equation from the calculate() method yields the
    // formulas for the methods below:

    /**
     * Calculates the maximum achievable velocity given a maximum voltage supply,
     * a position, and an acceleration.  Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the acceleration constraint, and this will give you
     * a simultaneously-achievable velocity constraint.
     *
     * @param maxVoltage   The maximum voltage that can be supplied to the arm.
     * @param angle        The angle of the arm.
     * @param acceleration The acceleration of the arm.
     * @return The maximum possible velocity at the given acceleration and angle.
     */
    public double maxAchievableVelocity(double maxVoltage, double angle, double acceleration) {
        // Assume max velocity is positive
        return (maxVoltage - ks - Math.cos(angle) * kcos - acceleration * ka) / kv;
    }

    /**
     * Calculates the minimum achievable velocity given a maximum voltage supply,
     * a position, and an acceleration.  Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the acceleration constraint, and this will give you
     * a simultaneously-achievable velocity constraint.
     *
     * @param maxVoltage   The maximum voltage that can be supplied to the arm.
     * @param angle        The angle of the arm.
     * @param acceleration The acceleration of the arm.
     * @return The minimum possible velocity at the given acceleration and angle.
     */
    public double minAchievableVelocity(double maxVoltage, double angle, double acceleration) {
        // Assume min velocity is negative, ks flips sign
        return (-maxVoltage + ks - Math.cos(angle) * kcos - acceleration * ka) / kv;
    }

    /**
     * Calculates the maximum achievable acceleration given a maximum voltage
     * supply, a position, and a velocity. Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the velocity constraint, and this will give you
     * a simultaneously-achievable acceleration constraint.
     *
     * @param maxVoltage The maximum voltage that can be supplied to the arm.
     * @param angle      The angle of the arm.
     * @param velocity   The velocity of the arm.
     * @return The maximum possible acceleration at the given velocity.
     */
    public double maxAchievableAcceleration(double maxVoltage, double angle, double velocity) {
        return (maxVoltage - ks * Math.signum(velocity) - Math.cos(angle) * kcos - velocity * kv) / ka;
    }

    /**
     * Calculates the minimum achievable acceleration given a maximum voltage
     * supply, a position, and a velocity. Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the velocity constraint, and this will give you
     * a simultaneously-achievable acceleration constraint.
     *
     * @param maxVoltage The maximum voltage that can be supplied to the arm.
     * @param angle      The angle of the arm.
     * @param velocity   The velocity of the arm.
     * @return The minimum possible acceleration at the given velocity.
     */
    public double minAchievableAcceleration(double maxVoltage, double angle, double velocity) {
        return maxAchievableAcceleration(-maxVoltage, angle, velocity);
    }
}