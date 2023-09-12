package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import frc.robot.Constants.*;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.subsystems.DashboardSubsystem;

public class TeleopDrive extends CommandBase
	{
	/* Subsystems */
	private TankSubsystem tankSubsystem;
	private DashboardSubsystem dashboardSubsystem;

	/* Left + Right Drive */
	private DoubleSupplier leftDrive;
	private DoubleSupplier rightDrive;

	/**
	 * Constructor
	 * 
	 * Sets {@link TankSubsystem}, {@link Dashboard} and the two drive
	 * {@link DoubleSupplier}'s
	 */
	public TeleopDrive(TankSubsystem tankSubsystem,
			DashboardSubsystem dashboardSubsystem, DoubleSupplier leftDrive,
			DoubleSupplier rightDrive)
		{
			addRequirements(tankSubsystem, dashboardSubsystem);
			this.tankSubsystem = tankSubsystem;
			this.dashboardSubsystem = dashboardSubsystem;

			this.leftDrive = leftDrive;
			this.rightDrive = rightDrive;
		}

	@Override
	public void initialize()
	{
		dashboardSubsystem
				.updateAutoIndicator(DashboardSubsystem.AutonomousMode.Teleop);
	}

	@Override
	public void execute()
	{
		tankSubsystem.driveStraight(leftDrive.getAsDouble(),
				rightDrive.getAsDouble());

		boolean inReverse = leftDrive
				.getAsDouble() > DriveConstants.JOYSTICK_DEADBAND
				&& rightDrive.getAsDouble() > DriveConstants.JOYSTICK_DEADBAND;

		dashboardSubsystem.updateGearIndicator(tankSubsystem.getCurrentGear(),
				inReverse);
	}

	}
