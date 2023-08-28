package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.TankSubsystem;

public class TeleopDrive extends CommandBase
	{
	/* Subsystem */
	private TankSubsystem tankSubsystem;

	/* Left + Right Drive */
	private DoubleSupplier leftDrive;
	private DoubleSupplier rightDrive;

	/**
	 * Constructor
	 * 
	 * Sets {@link TankSubsystem} and the two drive {@link DoubleSupplier}'s
	 */
	public TeleopDrive(TankSubsystem tankSubsystem, DoubleSupplier leftDrive,
			DoubleSupplier rightDrive)
		{

			this.tankSubsystem = tankSubsystem;
			this.leftDrive = leftDrive;
			this.rightDrive = rightDrive;
		}

	@Override
	public void execute()
	{
		tankSubsystem.driveStraight(leftDrive.getAsDouble(),
				rightDrive.getAsDouble());
	}

	}
