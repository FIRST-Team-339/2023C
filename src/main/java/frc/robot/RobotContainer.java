package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants.*;
import frc.robot.Constants.DriveConstants.DRIVE_GEARS;
import frc.robot.commands.Camera;
import frc.robot.commands.ShiftGear;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.TankSubsystem;

public class RobotContainer
        {
        // Joysticks
        private CommandJoystick leftDriverJoystick = new CommandJoystick(
                        JoystickConstants.LEFT_DRIVER_JOYSTICK_ID);
        private CommandJoystick rightDriverJoystick = new CommandJoystick(
                        JoystickConstants.RIGHT_DRIVER_JOYSTICK_ID);
        private CommandJoystick leftOperatorJoystick = new CommandJoystick(
                        JoystickConstants.LEFT_OPERATOR_JOYSTICK_ID);
        private CommandJoystick rightOperatorJoystick = new CommandJoystick(
                        JoystickConstants.RIGHT_OPERATOR_JOYSTICK_ID);

        // Teleop Drive & Tank Subsystem
        private TankSubsystem tankSubsystem = new TankSubsystem();
        private TeleopDrive teleopDriveCommand = new TeleopDrive(tankSubsystem,
                        () -> leftDriverJoystick.getY(),
                        () -> rightDriverJoystick.getY());
        private ShiftGear gearUpCommand = new ShiftGear(tankSubsystem,
                        ShiftGear.GearUpOrDown.UP);
        private ShiftGear gearDownCommand = new ShiftGear(tankSubsystem,
                        ShiftGear.GearUpOrDown.DOWN);

        // Camera
        private CameraSubsystem cameraSubsystem = new CameraSubsystem();
        private Camera cameraCommand = new Camera(cameraSubsystem,
                        CameraConstants.USING_TWO_CAMERAS);

        public RobotContainer()
                {
                        // Start Camera
                        // TODO: FIX DUAL CAMERAS
                        cameraCommand.addRequirements(cameraSubsystem);
                        rightOperatorJoystick.button(
                                        CameraConstants.SWITCH_CAMERA_BUTTON_ID)
                                        .onTrue(cameraCommand);

                        // Start Teleop Drive & Tank Subsystem w/ gears
                        teleopDriveCommand.addRequirements(tankSubsystem);
                        tankSubsystem.setDefaultCommand(teleopDriveCommand);
                        gearUpCommand.addRequirements(tankSubsystem);
                        gearDownCommand.addRequirements(tankSubsystem);
                        rightDriverJoystick.button(
                                        DriveConstants.GEAR_UP_BUTTON_ID)
                                        .onTrue(gearUpCommand);
                        leftDriverJoystick.button(
                                        DriveConstants.GEAR_DOWN_BUTTON_ID)
                                        .onTrue(gearDownCommand);
                }

        @Override
        public Command getAutonomousCommand()
        {

        }
        }
