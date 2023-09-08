package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.HardwareInterfaces.Transmission.TankTransmission;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.ArmCommand;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants.*;

public class RobotContainer
        {
        private CommandJoystick leftDriverJoystick = new CommandJoystick(
                        Constants.LEFT_DRIVER_JOYSTICK_ID);
        private CommandJoystick rightDriverJoystick = new CommandJoystick(
                        Constants.RIGHT_DRIVER_JOYSTICK_ID);

        private CommandJoystick leftOperatorJoystick = new CommandJoystick(
                        Constants.LEFT_OPERATOR_JOYSTICK_ID);
        private CommandJoystick rightOperatorJoystick = new CommandJoystick(
                        Constants.RIGHT_OPERATOR_JOYSTICK_ID);

        private JoystickButton gearUpButton = new JoystickButton(
                        rightDriverJoystick.getHID(),
                        Constants.GEAR_UP_BUTTON_ID);
        private JoystickButton gearDownButton = new JoystickButton(
                        leftDriverJoystick.getHID(),
                        Constants.GEAR_DOWN_BUTTON_ID);

        private TankSubsystem tankSubsystem = new TankSubsystem();

        private ArmSubsystem armSubsystem = new ArmSubsystem();

        // private CameraSubsystem cameraSubsystem = new CameraSubsystem();
        // private Camera cameraCommand = new Camera(cameraSubsystem,
        // CameraConstants.USING_TWO_CAMERAS);

        public RobotContainer()
                {
                        this.tankSubsystem.setDefaultCommand(new TeleopDrive(
                                        tankSubsystem,
                                        () -> leftDriverJoystick.getY(),
                                        () -> rightDriverJoystick.getY()));

                        this.gearUpButton.toggleOnTrue((Commands
                                        .runOnce(tankSubsystem::upShift)));
                        this.gearDownButton.toggleOnTrue((Commands
                                        .runOnce(tankSubsystem::downShift)));

                        // cameraSubsystem.setDefaultCommand(new Camera(
                        // cameraSubsystem,
                        // () -> rightOperatorJoystick.button(
                        // Constants.SWITCH_CAMERA_BUTTON_ID)));

                        this.armSubsystem.setDefaultCommand(new ArmCommand(
                                        armSubsystem,
                                        () -> leftOperatorJoystick.getY(),
                                        () -> rightOperatorJoystick.getY(),
                                        rightOperatorJoystick.trigger(),
                                        leftOperatorJoystick.trigger()));
                }
        }
