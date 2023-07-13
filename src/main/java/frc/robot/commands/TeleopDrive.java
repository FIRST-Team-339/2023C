package frc.robot.commands;


import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.TankTransmission;


public class TeleopDrive extends CommandBase  {
	private TankTransmission tank;
	DoubleSupplier leftDrive; 
	DoubleSupplier rightDrive;
	
	public TeleopDrive(TankTransmission tank, DoubleSupplier leftDrive, DoubleSupplier rightDrive) {
		this.tank = tank;
		this.leftDrive = leftDrive;
		this.rightDrive = rightDrive;
	}
	
	//This is the only method that is required
	//execute determines the functionality of the command - What will this command call
	@Override
	public void execute() {
		tank.drive(leftDrive.getAsDouble(), rightDrive.getAsDouble());
	}
	
}
