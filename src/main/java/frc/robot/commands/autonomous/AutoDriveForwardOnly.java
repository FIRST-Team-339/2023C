package frc.robot.commands.autonomous;

import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;

public class AutoDriveForwardOnly extends AutonomousBase
    {
    /* Subsystem */
    private TankSubsystem tankSubsystem;

    /* Auto Command State */
    private enum AutoCommandState
        {
        RESET_ENCODERS, DRIVE,
        }

    private AutoCommandState autoCommandState = AutoCommandState.RESET_ENCODERS;

    /* Drive Distance */
    public static int driveDistance = 120;

    /**
     * Constructor
     * 
     * <p>
     * Sets {@link TankSubsystem}
     * </p>
     */
    public AutoDriveForwardOnly(TankSubsystem tankSubsystem)
        {
            this.tankSubsystem = tankSubsystem;
        }

    @Override
    public void executeAutonomous()
    {
        switch (autoCommandState)
            {
            case RESET_ENCODERS:
                tankSubsystem.driveStraightInches(driveDistance,
                        AutonomousConstants.AUTO_MAX_DRIVE_SPEED, true);

                autoCommandState = AutoCommandState.DRIVE;
                break;
            case DRIVE:
                tankSubsystem.driveStraightInches(driveDistance,
                        AutonomousConstants.AUTO_MAX_DRIVE_SPEED, false);
            default:
                break;
            }
    }
    }
