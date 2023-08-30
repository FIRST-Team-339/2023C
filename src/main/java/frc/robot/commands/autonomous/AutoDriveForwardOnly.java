package frc.robot.commands.autonomous;

import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;

public class AutoDriveForwardOnly extends AutonomousBase
    {
    /* Subsystem */
    private TankSubsystem tankSubsystem;

    /* Encoders Reset Boolean */
    private boolean encodersReset = false;

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
        if (encodersReset == true)
            {
            tankSubsystem.driveStraightInches(driveDistance,
                    AutonomousConstants.AUTO_MAX_DRIVE_SPEED, false);
            }
        else
            {
            tankSubsystem.driveStraightInches(driveDistance,
                    AutonomousConstants.AUTO_MAX_DRIVE_SPEED, true);
            encodersReset = true;
            }
    }
    }
