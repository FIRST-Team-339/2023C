package frc.robot.subsystems;

import com.playingwithfusion.CANVenom;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmAndClawConstants;

public class ArmRaiseMotorSubsystem extends SubsystemBase
    {
    /* Arm Length Motor WPI Victor SPX */
    private CANVenom armLengthMotor = new CANVenom(
            ArmAndClawConstants.ARM_RAISE_MOTOR_ID);

    /* No Constructor */
    public ArmRaiseMotorSubsystem()
        {
        }

    /**
     * Gets the speed of the arm length motor
     * 
     * @return The motor duty cycle as a ratio. Value is between -1.0 and 1.0.
     */
    public double getSpeed()
    {
        return armLengthMotor.get();
    }

    /**
     * Sets the speed of the arm length motor
     * 
     * @param speed
     *            The motor duty cycle as a ratio. Value should be between -1.0
     *            and 1.0. If the speed is 
     */
    public void setSpeed(double speed)
    {
        armLengthMotor.set(speed);
    }
    }
