package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Modules.TankModule;
import frc.HardwareInterfaces.Transmission.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import com.ctre.phoenix.sensors.Pigeon2;

public class TankTransmission extends SubsystemBase
	{

	private MotorController leftFrontMotorController;
	private MotorController leftRearMotorController;
	private MotorControllerGroup leftMotorGroup;

	private MotorController rightFrontMotorController;
	private MotorController rightRearMotorController;
	private MotorControllerGroup rightMotorGroup;

	// NEED BETTER NAME HERE TO KEEP TYPES DIFFERENT
	private frc.HardwareInterfaces.Transmission.TankTransmission tankTransmission;

	// public Pigeon2 gyro;

	public TankTransmission()
		{
			// gyro = new Pigeon2(Constants.gyroID);

			// tankTreads = new TankModule[] {
			// new TankModule(Constants.leftFrontID, Constants.leftRearID,
			// Constants.leftFrontEncoder, Constants.leftRearEncoder),
			// new TankModule(Constants.rightFrontID, Constants.rightRearID,
			// Constants.rightFrontEncoder, Constants.rightRearEncoder)
			// };

			this.leftFrontMotorController = new WPI_TalonFX(
					Constants.TwentyThree.LEFT_FRONT_DRIVE_ID);
			this.leftRearMotorController = new WPI_TalonFX(
					Constants.TwentyThree.LEFT_REAR_DRIVE_ID);
			this.leftMotorGroup = new MotorControllerGroup(
					leftFrontMotorController, leftRearMotorController);

			this.leftMotorGroup.setInverted(true);

			this.rightFrontMotorController = new WPI_TalonFX(
					Constants.TwentyThree.RIGHT_FRONT_DRIVE_ID);
			this.rightRearMotorController = new WPI_TalonFX(
					Constants.TwentyThree.RIGHT_REAR_DRIVE_ID);
			this.rightMotorGroup = new MotorControllerGroup(
					rightFrontMotorController, rightRearMotorController);

			// NEEDS UNIQUE NAMES
			this.tankTransmission = new frc.HardwareInterfaces.Transmission.TankTransmission(
					leftMotorGroup, rightMotorGroup);

		}

	public void drive(double leftSpeed, double rightSpeed)
	{
		tankTransmission.drive(leftSpeed, rightSpeed);
	}

	public void gearDown()
	{
		tankTransmission.downShift();
	}

	public void gearUp()
	{
		tankTransmission.upShift();
	}

	@Override
	public void periodic()
	{
		// SmartDashboard.putNumber("LeftFront: ",
		// leftFrontMotorController.get());
		// SmartDashboard.putNumber("RightFront: ",
		// rightFrontMotorController.get());
		// SmartDashboard.putNumber("LeftRear: ",
		// leftRearMotorController.get());
		// SmartDashboard.putNumber("RightRear: ",
		// rightRearMotorController.get());

		// System.out.println("Left: " + leftFrontMotorController.get());
		// System.out.println("Right: " + rightFrontMotorController.get());

		// System.out.println(tankTransmission.getCurrentGear());

	}

	}
