package frc.robot.subsystems;

import frc.robot.TankModule;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.sensors.Pigeon2;

public class TankSubsystem extends SubsystemBase
	{

	public TankSubsystem()
		{
			// new TankModule(Constants.leftFrontID, Constants.leftRearID,
			// Constants.leftFrontEncoder, Constants.leftRearEncoder),
			// new TankModule(Constants.rightFrontID, Constants.rightRearID,
			// Constants.rightFrontEncoder, Constants.rightRearEncoder)
			// };

		}

	public void drive(double speed, double otherSpeed)
	{

	}

	@Override
	public void periodic()
	{
		// This block of code runs once per schedular 'tick'
		// Pretty much do nothing in this section
	}

	}
