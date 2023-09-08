package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;

import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends CommandBase
	{
	private ArmSubsystem arm;
	DoubleSupplier armRaise;
	DoubleSupplier armExtend;
	BooleanSupplier claw;
	BooleanSupplier raisePiston;

	public ArmCommand(ArmSubsystem arm, DoubleSupplier armRaise,
			DoubleSupplier armExtend, BooleanSupplier claw,
			BooleanSupplier raisePiston)
		{
			this.arm = arm;
			addRequirements(arm);
			this.armRaise = armRaise;
			this.armExtend = armExtend;
			this.claw = claw;
			this.raisePiston = raisePiston;

		}

	// This is the only method that is required
	// execute determines the functionality of the command - What will this
	// command call
	@Override
	public void execute()
	{
		arm.armControl(armRaise.getAsDouble(), armExtend.getAsDouble(),
				claw.getAsBoolean(), raisePiston.getAsBoolean());
	}

	}
