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
/* https://github.com/wpilibsuite/allwpilib/blob/cfbff32185ed0340cac5e22012a9 */
/* cffee15507be/wpimath/src/main/java/edu/wpi/first/math/controller/          */
/* ElevatorFeedforward.java                                                   */
/*----------------------------------------------------------------------------*/

/**
 * A helper class that computes feedforward outputs for a simple elevator (modeled as a motor
 * acting against the force of gravity).
 */
@SuppressWarnings("MemberName")
public class ElevatorFeedforward {
    public final double ks;
    public final double kg;
    public final double kv;
    public final double ka;

    /**
     * Creates a new ElevatorFeedforward with the specified gains.
     *
     * @param ks The static gain.
     * @param kg The gravity gain.
     * @param kv The velocity gain.
     * @param ka The acceleration gain.
     */
    public ElevatorFeedforward(double ks, double kg, double kv, double ka) {
        this(new ControllerConfigs.ElevatorFeedforwardConfig(ks, kg, kv, ka));
    }

    /**
     * Creates a new ElevatorFeedforward from the config.
     *
     * @param config The feedforward config.
     */

    public ElevatorFeedforward(ControllerConfigs.ElevatorFeedforwardConfig config) {
        this.ks = config.ks;
        this.kg = config.kg;
        this.kv = config.kv;
        this.ka = config.ka;
    }

    /**
     * Calculates the feedforward from the gains and setpoints.
     *
     * @param velocity     The velocity setpoint.
     * @param acceleration The acceleration setpoint.
     * @return The computed feedforward.
     */
    public double calculate(double velocity, double acceleration) {
        return ks * Math.signum(velocity) + kg + kv * velocity + ka * acceleration;
    }

    /**
     * Calculates the feedforward from the gains and velocity setpoint (acceleration is assumed to
     * be zero).
     *
     * @param velocity The velocity setpoint.
     * @return The computed feedforward.
     */
    public double calculate(double velocity) {
        return calculate(velocity, 0);
    }

    // Rearranging the main equation from the calculate() method yields the
    // formulas for the methods below:

    /**
     * Calculates the maximum achievable velocity given a maximum voltage supply
     * and an acceleration.  Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the acceleration constraint, and this will give you
     * a simultaneously-achievable velocity constraint.
     *
     * @param maxVoltage   The maximum voltage that can be supplied to the elevator.
     * @param acceleration The acceleration of the elevator.
     * @return The maximum possible velocity at the given acceleration.
     */
    public double maxAchievableVelocity(double maxVoltage, double acceleration) {
        // Assume max velocity is positive
        return (maxVoltage - ks - kg - acceleration * ka) / kv;
    }

    /**
     * Calculates the minimum achievable velocity given a maximum voltage supply
     * and an acceleration.  Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the acceleration constraint, and this will give you
     * a simultaneously-achievable velocity constraint.
     *
     * @param maxVoltage   The maximum voltage that can be supplied to the elevator.
     * @param acceleration The acceleration of the elevator.
     * @return The minimum possible velocity at the given acceleration.
     */
    public double minAchievableVelocity(double maxVoltage, double acceleration) {
        // Assume min velocity is negative, ks flips sign
        return (-maxVoltage + ks - kg - acceleration * ka) / kv;
    }

    /**
     * Calculates the maximum achievable acceleration given a maximum voltage
     * supply and a velocity. Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the velocity constraint, and this will give you
     * a simultaneously-achievable acceleration constraint.
     *
     * @param maxVoltage The maximum voltage that can be supplied to the elevator.
     * @param velocity   The velocity of the elevator.
     * @return The maximum possible acceleration at the given velocity.
     */
    public double maxAchievableAcceleration(double maxVoltage, double velocity) {
        return (maxVoltage - ks * Math.signum(velocity) - kg - velocity * kv) / ka;
    }

    /**
     * Calculates the minimum achievable acceleration given a maximum voltage
     * supply and a velocity. Useful for ensuring that velocity and
     * acceleration constraints for a trapezoidal profile are simultaneously
     * achievable - enter the velocity constraint, and this will give you
     * a simultaneously-achievable acceleration constraint.
     *
     * @param maxVoltage The maximum voltage that can be supplied to the elevator.
     * @param velocity   The velocity of the elevator.
     * @return The minimum possible acceleration at the given velocity.
     */
    public double minAchievableAcceleration(double maxVoltage, double velocity) {
        return maxAchievableAcceleration(-maxVoltage, velocity);
    }
}