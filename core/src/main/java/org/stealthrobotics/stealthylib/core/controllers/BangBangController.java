package org.stealthrobotics.stealthylib.core.controllers;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/**
 * Implements a bang-bang controller, which outputs either 0 or 1 depending on whether the
 * measurement is less than the setpoint. This maximally-aggressive control approach works very well
 * for velocity control of high-inertia mechanisms, and poorly on most other things.
 *
 * <p>Note that this is an *asymmetric* bang-bang controller - it will not exert any control effort
 * in the reverse direction (e.g. it won't try to slow down an over-speeding shooter wheel). This
 * asymmetry is *extremely important.* Bang-bang control is extremely simple, but also potentially
 * hazardous. Always ensure that your motor controllers are set to "coast" before attempting to
 * control them with a bang-bang controller.
 */
public class BangBangController {
    private double tolerance;

    private double setpoint;
    private double measurement;

    /**
     * Creates a new bang-bang controller from config.
     *
     * @param config The config to use.
     */

    public BangBangController(ControllerConfigs.BangBangControllerConfig config) {
        setTolerance(config.tolerance);
    }

    public BangBangController(double tolerance) {
        this(new ControllerConfigs.BangBangControllerConfig(tolerance));
    }

    /**
     * Creates a new bang-bang controller.
     *
     * <p>Always ensure that your motor controllers are set to "coast" before attempting to control
     * them with a bang-bang controller.
     */
    public BangBangController() {
        this(new ControllerConfigs.BangBangControllerConfig());
    }

    /**
     * Sets the setpoint for the bang-bang controller.
     *
     * @param setpoint The desired setpoint.
     */
    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    /**
     * Returns the current setpoint of the bang-bang controller.
     *
     * @return The current setpoint.
     */
    public double getSetpoint() {
        return setpoint;
    }

    /**
     * Returns true if the error is within the tolerance of the setpoint.
     *
     * @return Whether the error is within the acceptable bounds.
     */
    public boolean atSetpoint() {
        return Math.abs(setpoint - measurement) < tolerance;
    }

    /**
     * Sets the error within which atSetpoint will return true.
     *
     * @param tolerance Position error which is tolerable.
     */
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * Returns the current tolerance of the controller.
     *
     * @return The current tolerance.
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * Returns the current measurement of the process variable.
     *
     * @return The current measurement of the process variable.
     */
    public double getMeasurement() {
        return measurement;
    }

    /**
     * Returns the current error.
     *
     * @return The current error.
     */
    public double getError() {
        return setpoint - measurement;
    }

    /**
     * Returns the calculated control output.
     *
     * @param measurement The most recent measurement of the process variable.
     * @return The calculated motor output (0 or 1).
     */
    public double calculate(double measurement) {
        this.measurement = measurement;

        return measurement < setpoint ? 1 : 0;
    }
}