package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants.*;
import frc.robot.commands.Camera;
import frc.robot.commands.GearShift;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.autonomous.*;
import frc.robot.hardwareInterfaces.SingleThrowSwitch;
import frc.robot.hardwareInterfaces.SixPositionSwitch;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.TankSubsystem;

public class RobotContainer
        {
        /* Joysticks */
        private CommandJoystick leftDriverJoystick = new CommandJoystick(
                        JoystickConstants.LEFT_DRIVER_JOYSTICK_ID);
        private CommandJoystick rightDriverJoystick = new CommandJoystick(
                        JoystickConstants.RIGHT_DRIVER_JOYSTICK_ID);
        private CommandJoystick leftOperatorJoystick = new CommandJoystick(
                        JoystickConstants.LEFT_OPERATOR_JOYSTICK_ID);
        private CommandJoystick rightOperatorJoystick = new CommandJoystick(
                        JoystickConstants.RIGHT_OPERATOR_JOYSTICK_ID);

        /* Autonomous Hardware */
        private SingleThrowSwitch useAutoSwitch = new SingleThrowSwitch(
                        AutonomousConstants.USE_AUTO_SWITCH_ID);
        private SixPositionSwitch sixPositionAutoSwitch = new SixPositionSwitch(
                        AutonomousConstants.AUTO_SIX_POSITION_SWITCH_IDS);

        /* Teleop Drive & Tank Subsystem */
        private TankSubsystem tankSubsystem = new TankSubsystem();
        private TeleopDrive teleopDriveCommand = new TeleopDrive(tankSubsystem,
                        () -> leftDriverJoystick.getY(),
                        () -> rightDriverJoystick.getY());
        private GearShift gearUpCommand = new GearShift(tankSubsystem,
                        GearShift.GearUpOrDown.UP);
        private GearShift gearDownCommand = new GearShift(tankSubsystem,
                        GearShift.GearUpOrDown.DOWN);

        /* Camera */
        private CameraSubsystem cameraSubsystem = new CameraSubsystem();
        private Camera cameraCommand = new Camera(cameraSubsystem,
                        CameraConstants.USING_TWO_CAMERAS);

        public RobotContainer()
                {
                        // Initialize Camera
                        cameraCommand.addRequirements(cameraSubsystem);
                        rightOperatorJoystick.button(
                                        CameraConstants.SWITCH_CAMERA_BUTTON_ID)
                                        .onTrue(cameraCommand);

                        // Initialize Teleop Drive & Tank Subsystem w/ gears
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

        public Command getAutonomousCommand()
        {
                CommandBase autonomousCommand = null;

                if (useAutoSwitch.isOn())
                        {
                        switch (sixPositionAutoSwitch.getPosition())
                                {
                                /*
                                 * Position 1
                                 * 
                                 * When the robot is in the shorter length of
                                 * the community, it will be placed 4 inches
                                 * away from the community line and drive
                                 * forward 140 inches, then stop 16 inches away
                                 * from the game piece. Then stop.
                                 */
                                case 0:
                                        autonomousCommand = new AutoDriveForwardOnly(
                                                        tankSubsystem);
                                        break;
                                default:
                                        break;
                                }
                        }

                if (autonomousCommand != null)
                        {
                        autonomousCommand.addRequirements(tankSubsystem);
                        }
                return autonomousCommand;
        }
        }
