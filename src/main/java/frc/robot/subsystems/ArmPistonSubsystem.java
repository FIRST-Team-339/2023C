package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmAndClawConstants;
import frc.robot.hardwareInterfaces.DoubleSolenoid;

public class ArmPistonSubsystem extends SubsystemBase
    {
    private DoubleSolenoid armPiston = new DoubleSolenoid(
            ArmAndClawConstants.ARM_RAISE_PISTON_FWD_PORT,
            ArmAndClawConstants.ARM_RAISE_PISTON_REV_PORT);

    /* No Constructor */
    public ArmPistonSubsystem()
        {
        }

    /**
     * @return If the arm raise piston is raised or not
     */
    public boolean isRaised()
    {
        return armPiston.getForward();
    }

    /**
     * Raises the arm piston
     * 
     * @return The value of what forward now is
     */
    public boolean raise()
    {
        return armPiston.setForward(true);
    }

    /**
     * Lowers the arm piston
     * 
     * @return The value of what reverse now is
     */
    public boolean lower()
    {
        return armPiston.setReverse(true);
    }

    }
