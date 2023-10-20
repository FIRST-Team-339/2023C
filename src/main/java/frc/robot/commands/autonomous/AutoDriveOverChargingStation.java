package frc.robot.commands.autonomous;

import frc.robot.subsystems.ArmPistonSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.TeleopDrive;

public class AutoDriveOverChargingStation extends AutonomousCommandBase {
    /* Auto Command State */
    private enum AutoCommandState {
        RESET_ENCODERS, DRIVE, HOLD
    }

    private AutoCommandState autoCommandState = AutoCommandState.RESET_ENCODERS;

    /* Drive Variables */
    public int driveDistance = 92;
    public double driveSpeed = 0.22;
    public double chargingStationHoldSpeed = -0.05;

    /**
     * Constructor
     * 
     * <p>
     * Sets {@link TankSubsystem}
     * </p>
     */
    public AutoDriveOverChargingStation(TankSubsystem tankSubsystem, ArmPistonSubsystem armPistonSubsystem,
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
                if (tankSubsystem.driveStraightInches(driveDistance,
                        AutonomousConstants.AUTO_MAX_DRIVE_SPEED,
                        false) == true) {
                    autoCommandState = AutoCommandState.HOLD;
                }
            case HOLD:
                tankSubsystem.driveStraight(chargingStationHoldSpeed, true);
            default:
                break;
        }
    }
}
