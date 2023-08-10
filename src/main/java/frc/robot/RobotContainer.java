package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.*;

public class RobotContainer
    {
    /* Constant Local */
    Object localConstants;

    /* Control Interfaces */
    private final Joystick leftDriver = new Joystick(
            Constants.TwentyThree.LEFT_DRIVER_PORT);
    private final Joystick rightDriver = new Joystick(
            Constants.TwentyThree.RIGHT_DRIVER_PORT);

    /* Buttons */
    private final JoystickButton gearUpButton = new JoystickButton(rightDriver,
            Constants.TwentyThree.GEAR_UP_BUTTON);
    private final JoystickButton gearDownButton = new JoystickButton(leftDriver,
            Constants.TwentyThree.GEAR_DOWN_BUTTON);

    /* Subsystems */
    TankTransmissionRemap tankTransmission = new TankTransmissionRemap();

    public RobotContainer()
        {
            localConstants = Constants.getCurrentConstants();
            System.out.println();

            // Tank Transmission will always try and drive
            tankTransmission.setDefaultCommand(new TeleopDrive(tankTransmission,
                    () -> leftDriver.getY(), () -> rightDriver.getY()));

            gearUpButton
                    .toggleOnTrue(Commands.runOnce(tankTransmission::gearUp));
            gearDownButton
                    .toggleOnTrue(Commands.runOnce(tankTransmission::gearDown));

        }

    }
