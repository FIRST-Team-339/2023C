package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.playingwithfusion.CANVenom;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.HardwareInterfaces.DoubleSolenoid;

/**
 * Subsystem Class representing the 2023 arm assembly
 * 
 * @author Craig Kimball
 * @written 08/XX/23
 */
public class ArmAssembly extends SubsystemBase{
    private MotorController armRaiseMotor;
    private MotorController armLengthMotor;

    private DoubleSolenoid clawPiston;
    private DoubleSolenoid armRaisePiston;

    /**
     * Creates the ArmAssembly Subsystem Object
     */
    public ArmAssembly(){
        this.armRaiseMotor = new CANVenom(Constants.TwentyThree.ARM_RAISE_MOTOR_ID);
        this.armLengthMotor = new WPI_VictorSPX(Constants.TwentyThree.ARM_LENGTH_MOTOR_ID);
        this.armRaiseMotor.setInverted(true);
        this.armLengthMotor.setInverted(true);

        this.armRaisePiston = new DoubleSolenoid(
            Constants.TwentyThree.ARM_RAISE_FWD_PORT,
            Constants.TwentyThree.ARM_RAISE_REV_PORT);
        this.clawPiston = new DoubleSolenoid(
            Constants.TwentyThree.CLAW_PISTON_FWD_PORT,
            Constants.TwentyThree.CLAW_PISTON_REV_PORT);
    }


    /* Arm Control */

    /**
     * Method to extend the elevator section of the arm
     * @param motorSpeed
     *          The value of the motors, in percentage (-1.0 to 1.0)
     */
    public void extendArm(double motorSpeed){
        if(motorSpeed >= -Constants.TwentyThree.ARM_DEADBAND && motorSpeed <= Constants.TwentyThree.ARM_DEADBAND){
            //Motor should not move
            //Validate hold value
            this.armLengthMotor.set(Constants.TwentyThree.ARM_HOLD_SPEED);
        }else{
            //Scaling arm raise and lower speed as a safety net for test on robot
            // refer to 2023 season code for calculation
        this.armLengthMotor.set(motorSpeed*.5);
        }
    }

    /**
     * Method to rotate the arm assembly
     * @param motorSpeed
     *          The value of the motors, in percentage (-1.0 to 1.0)
     */
    public void rotateArm(double motorSpeed){
        if(motorSpeed >= -Constants.TwentyThree.ARM_DEADBAND && motorSpeed <= Constants.TwentyThree.ARM_DEADBAND){
            //Motor should not move
            //Validate hold value

            //DOES NOT WORK
            System.out.println("false");
            this.armRaiseMotor.set(Constants.TwentyThree.ARM_HOLD_SPEED);
            
        }else{
            System.out.println("True");
            //Scaling arm raise and lower speed as a safety net for test on robot
            // refer to 2023 season code for calculation
            
            //DOES NOT WORK
            this.armRaiseMotor.set(motorSpeed*.5);
        }
    }

    /**
     * Method for use in command
     * @param extendSpeed
     * @param rotateSpeed
     */
    public void manipulateArm(double extendSpeed, double rotateSpeed){
        extendArm(extendSpeed);
        rotateArm(rotateSpeed);
    }


    /**
     * Method to extend the rear portion of the arm
     * @param isRaised
     *          The value of the piston, True is Forward
     */
    public void setArmRaised(boolean isRaised){
        this.armRaisePiston.setForward(isRaised);
    }

    /**
     * Method to flip armRaised
     *
     */
    public void alternateArmRaised(){
        //sets the piston to the opposite state as current
        setArmRaised(!this.armRaisePiston.getForward());
    }

    /* Claw Control */

    /**
     * Method to close the class
     * @param isForward
     *          The value of the piston, True is Closed
     */
    public void setClawForward(boolean isForward){
        this.clawPiston.setForward(isForward);
    }

    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("ArmRaise", armRaiseMotor.get());
        SmartDashboard.putNumber("ArmLength", armLengthMotor.get());
        
        SmartDashboard.putBoolean("ArmRaised", armRaisePiston.getForward());
        SmartDashboard.putBoolean("ClawForward", clawPiston.getForward());
    }

}
