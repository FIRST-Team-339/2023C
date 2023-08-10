package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.TankTransmission;
import frc.robot.subsystems.TankTransmissionRemap;

public class TeleopDrive extends CommandBase
	{
	private TankTransmissionRemap tank;
	DoubleSupplier leftDrive;
	DoubleSupplier rightDrive;

	public TeleopDrive(TankTransmissionRemap tank, DoubleSupplier leftDrive,
			DoubleSupplier rightDrive)
		{
			this.tank = tank;
			addRequirements(tank);

			this.leftDrive = leftDrive;
			this.rightDrive = rightDrive;
		}

	// This is the only method that is required
	// execute determines the functionality of the command - What will this
	// command call
	@Override
	public void execute()
	{
		tank.drive(leftDrive.getAsDouble(), rightDrive.getAsDouble());
	}

	}
