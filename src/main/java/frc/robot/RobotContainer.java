package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants.*;
import frc.robot.commands.ArmLengthMotor;
import frc.robot.commands.ArmRaiseMotor;
import frc.robot.commands.ArmRaisePiston;
import frc.robot.commands.Camera;
import frc.robot.commands.ClawTrigger;
import frc.robot.commands.GearShift;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.autonomous.*;
import frc.robot.hardwareInterfaces.SingleThrowSwitch;
import frc.robot.hardwareInterfaces.SixPositionSwitch;
import frc.robot.subsystems.ArmLengthMotorSubsystem;
import frc.robot.subsystems.ArmPistonSubsystem;
import frc.robot.subsystems.ArmRaiseMotorSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DashboardSubsystem;
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

        /* Dashboard Subsystem */
        private DashboardSubsystem dashboardSubsystem = new DashboardSubsystem();

        /* Teleop Drive & Tank Subsystem w/ gears */
        private TankSubsystem tankSubsystem = new TankSubsystem();
        public TeleopDrive teleopDriveCommand = new TeleopDrive(tankSubsystem,
                        dashboardSubsystem, () -> leftDriverJoystick.getY(),
                        () -> rightDriverJoystick.getY());
        private GearShift gearUpCommand = new GearShift(tankSubsystem,
                        GearShift.GearUpOrDown.UP);
        private GearShift gearDownCommand = new GearShift(tankSubsystem,
                        GearShift.GearUpOrDown.DOWN);

        /* Camera */
        private CameraSubsystem cameraSubsystem = new CameraSubsystem();
        private Camera cameraCommand = new Camera(cameraSubsystem,
                        CameraConstants.USING_TWO_CAMERAS);

        /* Arm & Claw components */
        private ArmRaiseMotorSubsystem armRaiseMotorSubsystem = new ArmRaiseMotorSubsystem();
        private ArmRaiseMotor armRaiseMotorCommand = new ArmRaiseMotor(
                        armRaiseMotorSubsystem,
                        () -> rightOperatorJoystick.getY());
        private ArmLengthMotorSubsystem armLengthMotorSubsystem = new ArmLengthMotorSubsystem();
        private ArmLengthMotor armLengthMotorCommand = new ArmLengthMotor(
                        armLengthMotorSubsystem,
                        () -> leftOperatorJoystick.getY());
        private ArmPistonSubsystem armPistonSubsystem = new ArmPistonSubsystem();
        private ArmRaisePiston armRaisePistonCommand = new ArmRaisePiston(
                        armPistonSubsystem);
        private ClawSubsystem clawSubsystem = new ClawSubsystem();
        private ClawTrigger clawTriggerCommand = new ClawTrigger(clawSubsystem,
                        dashboardSubsystem);

        public RobotContainer()
                {
                        /* Initialize Camera */
                        rightOperatorJoystick.button(
                                        CameraConstants.SWITCH_CAMERA_BUTTON_ID)
                                        .onTrue(cameraCommand);

                        /* Initialize Teleop Drive & Tank Subsystem w/ gears */
                        tankSubsystem.setDefaultCommand(teleopDriveCommand);
                        rightDriverJoystick.button(
                                        DriveConstants.GEAR_UP_BUTTON_ID)
                                        .onTrue(gearUpCommand);
                        leftDriverJoystick.button(
                                        DriveConstants.GEAR_DOWN_BUTTON_ID)
                                        .onTrue(gearDownCommand);

                        /* Initialize Arm & Claw components */
                        armRaiseMotorSubsystem.setDefaultCommand(
                                        armRaiseMotorCommand);
                        armLengthMotorSubsystem.setDefaultCommand(
                                        armLengthMotorCommand);
                        leftOperatorJoystick.button(
                                        ArmAndClawConstants.ARM_RAISE_BUTTON_ID)
                                        .onTrue(armRaisePistonCommand);
                        rightOperatorJoystick.button(
                                        ArmAndClawConstants.CLAW_TRIGGER_BUTTON_ID)
                                        .onTrue(clawTriggerCommand);
                }

        public AutonomousCommandBase getAutonomousCommand()
        {
                AutonomousCommandBase autonomousCommand = null;
                // TankSubsystem autonomousTankSubsystem = new TankSubsystem();

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
                                 * from the game piece.
                                 * 
                                 * Then stop.
                                 */
                                case 0:
                                        autonomousCommand = new AutoDriveForwardOnly(
                                                        tankSubsystem,
                                                        teleopDriveCommand);
                                        break;
                                /*
                                 * Position 2
                                 * 
                                 * The robot is placed 3 inches away from the
                                 * line of the long side of the community and 8
                                 * inches away from the charging station.
                                 * 
                                 * Then, the robot will drive 44 inches
                                 * forwards, and turn 90 degrees left/right (or
                                 * no turn at all if determined by the double
                                 * throw switch), then drive another 44 inches.
                                 * 
                                 * Then stop.
                                 */
                                case 1:
                                        autonomousCommand = new AutoDriveTurnDrive(
                                                        tankSubsystem,
                                                        teleopDriveCommand);
                                        break;
                                /*
                                 * Position 3
                                 */
                                case 2:
                                        autonomousCommand = new AutoDriveOverChargingStation(
                                                        tankSubsystem,
                                                        teleopDriveCommand);
                                        break;
                                /*
                                 * Position 4
                                 */
                                case 3:
                                        autonomousCommand = new AutoDropCubeDriveForward(
                                                        tankSubsystem,
                                                        teleopDriveCommand);
                                        break;
                                default:
                                        System.out.println(
                                                        "No Autonomous Selected");
                                        break;
                                }
                        }

                if (autonomousCommand != null)
                        {
                        autonomousCommand.addRequirements(tankSubsystem);
                        tankSubsystem.setDefaultCommand(autonomousCommand);
                        }
                return autonomousCommand;
        }
        }
