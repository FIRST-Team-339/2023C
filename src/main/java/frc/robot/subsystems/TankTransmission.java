package frc.robot.subsystems;

import frc.robot.Constants;
import frc.HardwareInterfaces.Transmission.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Tank Transmission Subsystem for use in WPI Command Based programming
 * Based on a traction drive system with four motors, with two sets of paired motors
 * Each joystick controlls one side of the robot
 * 
 * @author Ryan McGee 
 * @author Craig Kimball
 * @written 08/04/23
 */
public class TankTransmission extends SubsystemBase
	{
	
		private MotorController leftFrontMotorController;
		private MotorController leftRearMotorController;
		private TankControlBase leftSide;

		private MotorController rightFrontMotorController;
		private MotorController rightRearMotorController;
		private TankControlBase rightSide;
	
		// public Pigeon2 gyro;

	/**
	 * Creates the Transmission Subsystem Object
	 */
	public TankTransmission()
		{
			this.leftFrontMotorController = new WPI_TalonFX(Constants.TwentyThree.LEFT_FRONT_DRIVE_ID);
			this.leftRearMotorController = new WPI_TalonFX(Constants.TwentyThree.LEFT_REAR_DRIVE_ID);
			this.leftSide = new TankControlBase( new MotorControllerGroup(leftFrontMotorController,leftRearMotorController));

			this.rightFrontMotorController = new WPI_TalonFX(Constants.TwentyThree.RIGHT_FRONT_DRIVE_ID);
			this.rightRearMotorController = new WPI_TalonFX(Constants.TwentyThree.RIGHT_REAR_DRIVE_ID);
			this.rightSide = new TankControlBase(new MotorControllerGroup(rightFrontMotorController,rightRearMotorController));
		}// end constructor

		/**
         * Turns off the deadband for use in auto.
         */
        public void disableDeadband()
        {
                this.leftSide.disableDeadband();
                this.rightSide.disableDeadband();
        } // end disableDeadband()

        /**
         * Removes one from the current gear of the robot, allowing the user to
         * drive slower.
         */
        public void downShift()
        {
                this.leftSide.downShift();
                this.rightSide.downShift();
        } // end downShift()

		/**
         * Tells the robot to move up one gear.
         */
        public void upShift()
        {
                this.leftSide.upShift();
                this.rightSide.upShift();
        } // end upShift()

        /**
         * Drives the transmission based on a Tank drive system, but without
         * gear ratios or joystick deadbands. Use for autonomous purposes.
         *
         * @param motorSpeed
         *                The value of the motors, in percentage (-1.0 to 1.0)
         */
        public void driveRaw(double motorSpeed)
        {
                this.leftSide.driveRaw(motorSpeed);
                this.rightSide.driveRaw(motorSpeed);
        } // end driveRaw() - overloaded

        /**
         * Drives the transmission based on a Tank drive system, but without
         * gear ratios or joystick deadbands. This represents 2 motors
         * controlling a single side of the robot but NOT in a ControllerGroup.
         *
         * @param rearVal
         *                The left value of the robot, in percentage (-1.0 to
         *                1.0)
         * @param frontVal
         *                The right value of the robot, in percentage (-1.0 to
         *                1.0)
         */
        public void driveRaw(double rearVal, double frontVal)
        {
                this.leftSide.driveRaw(rearVal, frontVal);
                this.rightSide.driveRaw(rearVal, frontVal);
        } // end driveRaw() - overloaded

        /**
         * Drives the transmission based on a Tank drive system, but without
         * gear ratios or joystick deadbands. Use for autonomous purposes.
         *
         * @param motorSpeed
         *                The value of the motors, in percentage (-1.0 to 1.0)
         */
        public void driveRaw(double magnitude, double direction,
                        double rotation)
        {
                this.leftSide.driveRaw(magnitude, direction, rotation);
                this.rightSide.driveRaw(magnitude, direction, rotation);
        } // end driveRaw() - overloaded

        /**
         * Drives the transmission based on a Tank drive system, where left
         * controls the left wheels, and right controls the right wheels.
         * 
         * Uses joystick deadbands and gear ratios.
         * 
         * @param leftSideVal
         *                Percentage, (-1.0 to 1.0)
         * @param rightSideVal
         *                Percentage, (-1.0 to 1.0)
         */
        public void drive(double leftSideVal, double rightSideVal)
        {
                double leftOut = leftSide.scaleJoystickForDeadband(leftSideVal)
                                * leftSide.getCurrentGearRatio();
                leftSide.driveRaw(leftOut);
                double rightOut = rightSide.scaleJoystickForDeadband(
                                rightSideVal) * rightSide.getCurrentGearRatio();
                rightSide.driveRaw(rightOut);
        } // end drive()

        /**
         * Turns on the deadband for use in teleop.
         */
        public void enableDeadband()
        {
                this.leftSide.enableDeadband();
                this.rightSide.enableDeadband();
        } // end enableDeadband()

        /**
         * @return The gear number that is active as seen from the leftSide
         */
        public int getCurrentGear()
        {
                return this.leftSide.getCurrentGear();
        } // end getCurrentGear()

        /**
         * @return The percentage corresponding to the current gear as seen from
         *         the leftSide
         */
        public double getCurrentGearRatio()
        {
                return this.leftSide.getCurrentGearRatio();
        } // end getCurrentGearRatio()

		/**
         * Performs scaling for the Joysticks. See the TankControl class for an
         * explanation of what is going on.
         *
         * @param input
         * @return The scaled value, if between -1 and -deadband or deadband and
         *         1, or 0 if between -deadband and deadband for the leftSide of
         *         the robot
         */
        public double scaleJoystickForDeadband(double input)
        {
                this.rightSide.scaleJoystickForDeadband(input);
                return (this.leftSide.scaleJoystickForDeadband(input));
        } // end scaleJoystickForDeadband()

        /**
         * Sets every gear ratio. Make sure that the lowest gear starts at 0,
         * and the highest gear is at the max, to make sure the up-shifting and
         * down-shifting works properly.
         *
         * @param ratios
         *                Percent multiplied by the transmission.drive functions
         */
        public void setAllGearPercentages(double... ratios)
        {
                this.leftSide.setAllGearPercentages(ratios);
                this.rightSide.setAllGearPercentages(ratios);
        } // end setAllGearPercentages()

        /**
         * TODO Test gear system Sets the current gear for the robot. This will
         * change the maximum speed of the robot for precise aiming/driving.
         *
         * @param gear
         *                The requested gear number. If outside the range, it
         *                will do nothing.
         */
        public void setGear(int gear)
        {
                this.leftSide.setGear(gear);
                this.rightSide.setGear(gear);
        } // end setGear()

        /**
         * Sets the percent multiplied by Transmission.
         *
         * @param gear
         *                Which gear should be changed: 0 is lowest, increasing.
         * @param value
         *                Percent decimal form: between 0.0 and less than or
         *                equal to 1.0
         */
        public void setGearPercentage(int gear, double value)
        {
                this.leftSide.setGearPercentage(gear, value);
                this.rightSide.setGearPercentage(gear, value);
        } // end setGearPercentage()

        /**
         * TODO test deadbands Sets the minimum value the joysticks must output
         * in order for the robot to start moving.
         *
         * @param deadband
         *                Percentage value, ranging from 0.0 to 1.0, in
         *                decimals.
         */
        public void setJoystickDeadband(double deadband)
        {
                this.leftSide.setJoystickDeadband(deadband);
                this.rightSide.setJoystickDeadband(deadband);
        } // end setJoystickDeadband()

        /**
         * Sets the maximum gear to the value input.
         *
         * @param value
         *                Percent (0.0 to 1.0)
         */
        public void setMaxGearPercentage(double value)
        {
                this.leftSide.setMaxGearPercentage(value);
                this.rightSide.setMaxGearPercentage(value);
        } // end setMaxGearPercentage()

        /**
         * Sets the robot to the maximum gear available
         *
         */
        public void setToMaxGear()
        {
                this.leftSide.setToMaxGear();
                this.rightSide.setToMaxGear();
        } // end setToMaxGear()

        /**
         * Shift gears using a up-shift and down-shift button. Also makes sure
         * that holding the button will not trigger multiple shifts.
         *
         * @param upShiftButton
         *                The button that should change to the next higher gear
         * @param downShiftButton
         *                The button that should change to the next lowest gear
         */
        public void shiftGears(boolean upShiftButton, boolean downShiftButton)
        {
                this.leftSide.shiftGears(upShiftButton, downShiftButton);
                this.rightSide.shiftGears(upShiftButton, downShiftButton);
        } // end shiftGears()

        /**
         * Tells the robot to cut all power to the motors.
         */
        public void stop()
        {
                this.leftSide.stop();
                this.rightSide.stop();
        } // end stop()


	@Override
	public void periodic()
	{
		SmartDashboard.putNumber("LeftFront: ", leftFrontMotorController.get());
		SmartDashboard.putNumber("RightFront: ", rightFrontMotorController.get());
		SmartDashboard.putNumber("LeftRear: ", leftRearMotorController.get());
		SmartDashboard.putNumber("RightRear: ", rightRearMotorController.get());

		// System.out.println("Left: " + leftFrontMotorController.get());
		// System.out.println("Right: " + rightFrontMotorController.get());

		// System.out.println(tankTransmission.getCurrentGear());
	}

}
