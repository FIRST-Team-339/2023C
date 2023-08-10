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
                
                private TankCantrolBase leftSide;

		private MotorController rightFrontMotorController;
		private MotorController rightRearMotorController;
		private MotorControllerGroup rightMotorGroup;

                private TankControlBase rightSide;
                
		//NEED BETTER NAME HERE TO KEEP TYPES DIFFERENT
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

			this.leftFrontMotorController = new WPI_TalonFX(Constants.TwentyThree.LEFT_FRONT_DRIVE_ID);
			this.leftRearMotorController = new WPI_TalonFX(Constants.TwentyThree.LEFT_REAR_DRIVE_ID);
			this.leftMotorGroup = new MotorControllerGroup(leftFrontMotorController,leftRearMotorController);

			this.rightFrontMotorController = new WPI_TalonFX(Constants.TwentyThree.RIGHT_FRONT_DRIVE_ID);
			this.rightRearMotorController = new WPI_TalonFX(Constants.TwentyThree.RIGHT_REAR_DRIVE_ID);
			this.rightMotorGroup = new MotorControllerGroup(leftFrontMotorController,leftRearMotorController);

			//NEEDS UNIQUE NAMES
//			this.tankTransmission = new frc.HardwareInterfaces.Transmission.TankTransmission(leftMotorGroup, rightMotorGroup);

                        this.leftSide = new TankControlBase(leftMotorGroup);
                        this.rightSide = new TankControlBase(rightMotorGroup);
                        
		}

        /* DRIVE */
        
	public void drive(double leftSideVal, double rightSideVal)
	{
//            tankTransmission.drive(leftSpeed, rightSpeed);
            double leftOut = leftSide.scaleJoystickForDeadband(leftSideVal)
                                * leftSide.getCurrentGearRatio();
                leftSide.driveRaw(leftOut);
            double rightOut = rightSide.scaleJoystickForDeadband(
                                rightSideVal) * rightSide.getCurrentGearRatio();
                rightSide.driveRaw(rightOut);
	}
        
        public void driveRaw(double motorSpeed)
        {
                this.leftSide.driveRaw(motorSpeed);
                this.rightSide.driveRaw(motorSpeed);
        } // end driveRaw() - overloaded

        
        public void driveRaw(double rearVal, double frontVal)
        {
                this.leftSide.driveRaw(rearVal, frontVal);
                this.rightSide.driveRaw(rearVal, frontVal);
        } // end driveRaw() - overloaded

        
        public void driveRaw(double magnitude, double direction,
                        double rotation)
        {
                this.leftSide.driveRaw(magnitude, direction, rotation);
                this.rightSide.driveRaw(magnitude, direction, rotation);
        } // end driveRaw() - overloaded
        
        /* Gear */
        
	public void gearDown(){
            this.leftSide.downShift();
            this.rightSide.downShift();
	}

	public void gearUp(){
            this.leftSide.upShift();
            this.rightSide.upShift();
	}
        
        public int getCurrentGear()
        {
            return this.leftSide.getCurrentGear();
        }
        
        public double getCurrentGearRatio()
        {
            return this.leftSide.getCurrentGearRatio();
        }
        
        public void setGear(int gear)
        {
            this.leftSide.setGear(gear);
            this.rightSide.setGear(gear);
        }
        
        public void setGearPercentage(int gear, double value)
        {
            this.leftSide.setGearPercentage(gear, value);
            this.rightSide.setGearPercentage(gear, value);
        }
        
        public void setAllGearPercentages(double... ratios)
        {
            this.leftSide.setAllGearPercentages(ratios);
            this.rightSide.setAllGearPercentages(ratios);
        }
        
        public void setMaxGearPercentage(double value)
        {
            this.leftSide.setMaxGearPercentage(value);
            this.rightSide.setMaxGearPercentage(value);
        }
        
        public void setToMaxGear()
        {
            this.leftSide.setToMaxGear();
            this.rightSide.setToMaxGear();
        }
        
        /* DeadBand */
        
        public void disableDeadband()
        {
            this.leftSide.disableDeadband();
            this.rightSide.disableDeadband();
        }
        
        public void enableDeadband()
        {
            this.leftSide.enableDeadband();
            this.rightSide.enableDeadband();
        }
        
        public void setJoystickDeadband(double deadband)
        {
            this.leftSide.setJoystickDeadband(deadband);
            this.rightSide.setJoystickDeadband(deadband);
        }
        
        public double scaleJoystickForDeadband(double input)
        {
            this.rightSide.scaleJoystickForDeadband(input);
            return (this.leftSide.scaleJoystickForDeadband(input));
        }

        /* Misc */
        
        public void stop()
        {
            this.leftSide.stop();
            this.rightSide.stop();
        } 
        
        /* Subsystem Control */
        
	@Override
	public void periodic()
	{
		// SmartDashboard.putNumber("LeftFront: ", leftFrontMotorController.get());
		// SmartDashboard.putNumber("RightFront: ", rightFrontMotorController.get());
		// SmartDashboard.putNumber("LeftRear: ", leftRearMotorController.get());
		// SmartDashboard.putNumber("RightRear: ", rightRearMotorController.get());

		// System.out.println("Left: " + leftFrontMotorController.get());
		// System.out.println("Right: " + rightFrontMotorController.get());

		// System.out.println(tankTransmission.getCurrentGear());

	}

	}
