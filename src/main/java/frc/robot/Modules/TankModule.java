package frc.robot.Modules;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Encoder;

public class TankModule
	{

	private WPI_TalonFX /** FX */
	frontMotor;
	private WPI_TalonFX /** FX */
	rearMotor;
	private Encoder frontEncoder;
	private Encoder rearEncoder;

	public TankModule(int frontID, int rearID, int feID, int reID)
		{

			frontMotor = new WPI_TalonFX(frontID);
			rearMotor = new WPI_TalonFX(rearID);

			// frontEncoder = frontMotor.

		}

	// Double check 624 implementation of desiredState, they dont explicity pass
	// in control here
	public boolean setDesiredState(/** TeleopModuleState desiredState, */
	double speed)
	{
		// for swerve call setAngle First!!!!!!1 - highly important
		if (setSpeed(/** desiredState, */
				speed))
			{
			return true;
			}
		return false;
	}

	private boolean setSpeed(/** TeleopModuleState desiredState, */
	double speed)
	{
		// this representation is redundant but it due to a difference in
		// teleop/swerve
		if (true)
			{
			// use correct Talon / other set method here
			frontMotor.set(speed);
			rearMotor.set(speed);
			}
		else
			{
			// swerve calculation
			}
		return true;
	}

	// In Swerve this will return an object instead of a raw value
	// public double getEncoderValue()
	// {
	// // fluff math - not true implementation
	// return (frontEncoder + rearEncoder) / 2;
	// }

	}
