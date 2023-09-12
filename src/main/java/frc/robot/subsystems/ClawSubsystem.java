package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmAndClawConstants;
import frc.robot.hardwareInterfaces.DoubleSolenoid;

public class ClawSubsystem extends SubsystemBase
    {
    private DoubleSolenoid clawPiston = new DoubleSolenoid(
            ArmAndClawConstants.CLAW_PISTON_FWD_PORT,
            ArmAndClawConstants.CLAW_PISTON_REV_PORT);

    /* No Constructor */
    public ClawSubsystem()
        {
        }

    /**
     * @return If the claw piston is open or not
     */
    public boolean isOpen()
    {
        return clawPiston.getForward();
    }

    /**
     * Open's the claw
     * 
     * @return The value of what forward now is
     */
    public boolean open()
    {
        return clawPiston.setForward(true);
    }

    /**
     * Close's the claw
     * 
     * @return The value of what reverse now is
     */
    public boolean close()
    {
        return clawPiston.setReverse(true);
    }

    }
