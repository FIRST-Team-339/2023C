package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import frc.robot.hardwareInterfaces.KilroyEncoder;

public class TankSubsystem extends SubsystemBase
	{
	// Motors on the Left Side
	private MotorController motorForLeftEncoder = new WPI_TalonFX(
			DriveConstants.BOTTOM_LEFT_MOTOR_ID);
	private MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(
			new WPI_TalonFX(DriveConstants.TOP_LEFT_MOTOR_ID),
			motorForLeftEncoder);

	// Motors on the Right Side
	private MotorController motorForRightEncoder = new WPI_TalonFX(
			DriveConstants.BOTTOM_RIGHT_MOTOR_ID);
	private MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(
			new WPI_TalonFX(DriveConstants.TOP_RIGHT_MOTOR_ID),
			motorForRightEncoder);

	// The Robot's Drive
	private DifferentialDrive differentialDrive = new DifferentialDrive(
			leftMotorControllerGroup, rightMotorControllerGroup);

	// The Drive Encoder on the Left Side
	private KilroyEncoder leftEncoder = new KilroyEncoder(
			(WPI_TalonFX) motorForLeftEncoder);

	// The Drive Encoder on the Left Side
	private KilroyEncoder rightEncoder = new KilroyEncoder(
			(WPI_TalonFX) motorForRightEncoder);

	// Current Gear
	private DriveConstants.DRIVE_GEARS currentGear;

	public TankSubsystem()
		{
			// Set the `currentGear` value to the passed `startingGear` value
			currentGear = DriveConstants.defaultGear;
			setGear(currentGear);

			// Set the Joystick Deadband
			differentialDrive.setDeadband(DriveConstants.JOYSTICK_DEADBAND);

			// Set the inversion value for the motor controller groups
			leftMotorControllerGroup.setInverted(
					DriveConstants.MOTOR_CONTROLLER_GROUPS_INVERTED[0]);
			rightMotorControllerGroup.setInverted(
					DriveConstants.MOTOR_CONTROLLER_GROUPS_INVERTED[1]);

			// Reset Encoders
			leftEncoder.reset();
			rightEncoder.reset();
		}

	public void drive(double leftSpeed, double rightSpeed)
	{
		differentialDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public DriveConstants.DRIVE_GEARS getCurrentGear()
	{
		return currentGear;
	}

	public double getCurrentGearRatio()
	{
		return currentGear.getRatio();
	}

	public void setGear(DriveConstants.DRIVE_GEARS gear)
	{
		differentialDrive.setMaxOutput(gear.getRatio());
	}

	private void shiftGearBy(int shiftBy)
	{
		DriveConstants.DRIVE_GEARS newGear = DriveConstants.DRIVE_GEARS
				.getFromId(currentGear.getId() + shiftBy);
		if (newGear != null)
			{
			setGear(newGear);
			currentGear = newGear;
			}
	}

	public void shiftGearUp()
	{
		shiftGearBy(1);
	}

	public void shiftGearDown()
	{
		shiftGearBy(-1);
	}

	}
