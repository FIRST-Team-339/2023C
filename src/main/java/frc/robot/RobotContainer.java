package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmControl;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.*;

public class RobotContainer {
    /* Constant Local */
    // Constants localConstants = Constants.getCurrentConstants();
    
    /* Control Interfaces */
    private final Joystick leftDriver = new Joystick(Constants.TwentyThree.LEFT_DRIVER_PORT);
    private final Joystick rightDriver = new Joystick(Constants.TwentyThree.RIGHT_DRIVER_PORT);

    private final Joystick leftOperator = new Joystick(Constants.TwentyThree.LEFT_OPERATOR_PORT);
    private final Joystick rightOperator = new Joystick(Constants.TwentyThree.RIGHT_OPERATOR_PORT);

    /* Buttons */
    private final JoystickButton gearUpButton = new JoystickButton(rightDriver, Constants.TwentyThree.GEAR_UP_BUTTON);
    private final JoystickButton gearDownButton = new JoystickButton(leftDriver, Constants.TwentyThree.GEAR_DOWN_BUTTON);

    private final JoystickButton raiseArmButton = new JoystickButton(rightOperator, Constants.TwentyThree.ARM_RAISED_BUTTON);
    private final JoystickButton extendClawButton = new JoystickButton(leftOperator, Constants.TwentyThree.CLAW_FOWARD_BUTTON);

    /* Subsystems */
    TankTransmission tankTransmission = new TankTransmission();
    ArmAssembly armAssembly = new ArmAssembly();

    public RobotContainer(){

        /* TankTransmission */
        tankTransmission.setAllGearPercentages(Constants.TwentyThree.GEAR_ONE,Constants.TwentyThree.GEAR_TWO);
        tankTransmission.setJoystickDeadband(Constants.TwentyThree.JOYSTICK_DEADBAND);

        tankTransmission.setDefaultCommand(
            new TeleopDrive(tankTransmission, () -> leftDriver.getY(), () -> rightDriver.getY())
        );

        gearUpButton.toggleOnTrue(Commands.runOnce(tankTransmission::upShift));
        gearDownButton.toggleOnTrue(Commands.runOnce(tankTransmission::downShift));

        /* ArmAssembly */
        armAssembly.setDefaultCommand(
            new ArmControl(armAssembly, () -> leftOperator.getY(), () -> rightOperator.getY())
        );

        raiseArmButton.toggleOnTrue(Commands.runOnce(armAssembly::alternateArmRaised));

        //While holding claw button, claw is forwad
        //Noticed functionality, works every other time every single time
        extendClawButton.toggleOnTrue(Commands.run(() -> armAssembly.setClawForward(true)));
            extendClawButton.toggleOnFalse(Commands.run(() -> armAssembly.setClawForward(false)));
    }

}
