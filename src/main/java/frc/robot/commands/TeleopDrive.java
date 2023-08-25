package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.TankSubsystem;

public class TeleopDrive extends CommandBase
	{
	private TankSubsystem tankSubsystem;
	DoubleSupplier leftDrive;
	DoubleSupplier rightDrive;

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
		tankSubsystem.drive(leftDrive.getAsDouble(), rightDrive.getAsDouble());
	}

	}
