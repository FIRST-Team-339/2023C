package frc.robot.commands.autonomous;

import frc.robot.subsystems.ArmPistonSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.TeleopDrive;

public class AutoDriveTurnDrive extends AutonomousCommandBase {
    /* Auto Command State */
    private enum AutoCommandState {
        RESET_ENCODERS_1, DRIVE_1, RESET_ENCODERS_2, TURN, RESET_ENCODERS_3, DRIVE_2
    }

    private AutoCommandState autoCommandState = AutoCommandState.RESET_ENCODERS_1;

    /* Drive Distances */

    /**
     * Constructor
     * 
     * <p>
     * Sets {@link TankSubsystem}
     * </p>
     */
    public AutoDriveTurnDrive(TankSubsystem tankSubsystem, ArmPistonSubsystem armPistonSubsystem,
            ClawSubsystem clawSubsystem, TeleopDrive teleopDrive) {
        super(tankSubsystem, armPistonSubsystem, clawSubsystem, teleopDrive);
    }

    @Override
    public void executeAutonomous() {

    }
}
