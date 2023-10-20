package frc.robot.commands.autonomous;

import frc.robot.subsystems.ArmPistonSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.TeleopDrive;

public class AutoDriveForwardOnly extends AutonomousCommandBase {
    /* Auto Command State */
    private enum AutoCommandState {
        RESET_ENCODERS, DRIVE, BRAKE
    }

    private AutoCommandState autoCommandState = AutoCommandState.RESET_ENCODERS;

    /*
     * Drive Distance, supposed to be 120 inches but it is shaved off a little to
     * account for braking
     */
    public static int driveDistance = 110;

    /**
     * Constructor
     * 
     * <p>
     * Sets {@link TankSubsystem}
     * </p>
     */
    public AutoDriveForwardOnly(TankSubsystem tankSubsystem, ArmPistonSubsystem armPistonSubsystem,
            ClawSubsystem clawSubsystem, TeleopDrive teleopDrive) {
        super(tankSubsystem, armPistonSubsystem, clawSubsystem, teleopDrive);
    }

    public void executeAutonomous() {
        switch (autoCommandState) {
            case RESET_ENCODERS:
                tankSubsystem.driveStraightInches(driveDistance,
                        AutonomousConstants.AUTO_MAX_DRIVE_SPEED, true);

                autoCommandState = AutoCommandState.DRIVE;
                break;
            case DRIVE:
                if (tankSubsystem.accelerate(1.0 /* This is at the Auto Max Drive Speed */) == true) {
                    if (tankSubsystem.driveStraightInches(driveDistance, 1.0, false) == true) {
                        autoCommandState = AutoCommandState.BRAKE;
                    }
                }
                break;
            case BRAKE:
                tankSubsystem.brake();
        }
    }
}
