package frc.robot.subsystems;

import frc.robot.TankModule;
import frc.HardwareInterfaces.Transmission.TankTransmission;
import frc.robot.Constants;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TankSubsystem extends SubsystemBase
	{
	private MotorController leftBottomMotor = new WPI_TalonFX(
			Constants.LEFT_BOTTOM_MOTOR_ID);
	private MotorController leftTopMotor = new WPI_TalonFX(
			Constants.LEFT_TOP_MOTOR_ID);
	private MotorController rightBottomMotor = new WPI_TalonFX(
			Constants.RIGHT_BOTTOM_MOTOR_ID);
	private MotorController rightTopMotor = new WPI_TalonFX(
			Constants.RIGHT_TOP_MOTOR_ID);

	private MotorControllerGroup leftSideMotors = new MotorControllerGroup(
			leftBottomMotor, leftTopMotor);
	private MotorControllerGroup rightSideMotors = new MotorControllerGroup(
			rightBottomMotor, rightTopMotor);

	private TankTransmission tankTransmission = new TankTransmission(
			leftSideMotors, rightSideMotors);

	public TankSubsystem()
		{
			leftBottomMotor.setInverted(true);
			leftTopMotor.setInverted(true);

			tankTransmission.setJoystickDeadband(Constants.DEADBAND);
			tankTransmission.setAllGearPercentages(Constants.FIRST_GEAR,
					Constants.SECOND_GEAR, Constants.THIRD_GEAR);
		}

	public void drive(double speed, double otherSpeed)
	{
		this.tankTransmission.drive(speed, otherSpeed);
	}

	public void upShift()
	{
		this.tankTransmission.upShift();
	}

	public void downShift()
	{
		this.tankTransmission.downShift();
	}

	@Override
	public void periodic()
	{
		// This block of code runs once per schedular 'tick'
		// Pretty much do nothing in this section
	}

	}
