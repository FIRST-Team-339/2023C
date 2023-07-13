package frc.robot.subsystems;

import frc.robot.TankModule;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.sensors.Pigeon2;



public class TankTransmission extends SubsystemBase{
	public TankModule[] tankTreads;
	public Pigeon2 gyro;
	
	
	public Swerve() {
		gyro = new Pigeon2(Constants.gyroID);
		
		tankTreads = new TankModule[] {
				new TankModule(Constants.leftFrontID, Constants.leftRearID, Constants.leftFrontEncoder, Constants.leftRearEncoder),
				new TankModule(Constants.rightFrontID, Constants.rightRearID, Constants.rightFrontEncoder, Constants.rightRearEncoder)			
		};
		
	}
	
	public void drive(double speed, double otherSpeed) {
		
		//Swerve Implementation will look something like this with some odometry math above to calculate what values to pass
//		for(TankModule tread : tankTreads) {
//			tread.setDesiredState(speed);
//		}
		
		//for tank transmission we can simply do this for now
		tankTreads[0].setDesiredState(speed);
		tankTreads[1].setDesiredState(otherSpeed);
	}
	
	
	@Override
	public void periodic() {
		//This block of code runs once per schedular 'tick'
		//Pretty much do nothing in this section
	}
	
	
}
