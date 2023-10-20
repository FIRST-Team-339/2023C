package frc.robot.commands.autonomous;

import frc.robot.subsystems.ArmPistonSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.TeleopDrive;

public class AutoDropCubeDriveForward extends AutonomousCommandBase {
    /* Encoders Reset Boolean */
    private boolean encodersReset = false;

    /* Drive Distances */

    /**
     * Constructor
     * 
     * <p>
     * Sets {@link TankSubsystem}
     * </p>
     */
    public AutoDropCubeDriveForward(TankSubsystem tankSubsystem, ArmPistonSubsystem armPistonSubsystem,
            ClawSubsystem clawSubsystem, TeleopDrive teleopDrive) {
        super(tankSubsystem, armPistonSubsystem, clawSubsystem, teleopDrive);
    }

    @Override
    public void executeAutonomous() {

    }
}
