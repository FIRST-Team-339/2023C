package frc.robot;

public class TankModule {
	
	private TalonSRX /**FX*/ frontMotor;
	private TalonSRX /**FX*/ rearMotor;
	private Encoder frontEncoder;
	private Encoder rearEncoder;
	
	public TankModule(int frontID, int rearID, int feID, int reID) {
		
		frontMotor = new TalonSRX(frontID);
		rearMotor = new TalonSRX(rearID);
		
		frontEncoder = new Encoder(feID);
		rearEncoder = new Encoder(reID);
		
	}
	
	//Double check 624 implementation of desiredState, they dont explicity pass in control here
	public boolean setDesiredState(/**TeleopModuleState desiredState,*/ double speed) {
		//for swerve call setAngle First!!!!!!1 - highly important
		if(setSpeed(/**desiredState,*/speed)) {
			return true;
		}
	}
	
	private boolean setSpeed(/**TeleopModuleState desiredState,*/ double speed) {
		//this representation is redundant but it due to a difference in teleop/swerve
		if(true) {
			//use correct Talon / other set method here
			frontMotor.set(speed);
			rearMotor.set(speed);
		}else {
			//swerve calculation
		}
		return true;
	}
	
	//In Swerve this will return an object instead of a raw value
	public double getEncoderValue() {
		//fluff math - not true implementation
		return (frontEncoder + rearEncoder) / 2; 
	}
	

}
