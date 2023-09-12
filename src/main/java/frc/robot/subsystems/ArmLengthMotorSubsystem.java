package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmAndClawConstants;

public class ArmLengthMotorSubsystem extends SubsystemBase
    {
    /* Arm Length Motor WPI Victor SPX */
    private WPI_VictorSPX armLengthMotor = new WPI_VictorSPX(
            ArmAndClawConstants.ARM_LENGTH_MOTOR_ID);

    /* No Constructor */
    public ArmLengthMotorSubsystem()
        {
        }

    /**
     * Gets the speed of the arm length motor
     * 
     * @return The current set speed. Value is between -1.0 and 1.0.
     */
    public double getSpeed()
    {
        return armLengthMotor.get();
    }

    /**
     * Sets the speed of the arm length motor
     * 
     * @param speed
     *            The speed to set. Value should be between -1.0 and 1.0.
     */
    public void setSpeed(double speed)
    {
        armLengthMotor.set(speed);
    }
    }
