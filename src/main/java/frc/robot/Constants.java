package frc.robot;

import frc.robot.enums.DriveGears;

/**
 * The {@code Constants} class is to store all constants to be used with the
 * robot
 * 
 * <p>
 * Anything declared here should be prefaced with {@code public static final}
 * </p>
 */
public final class Constants
    {
    public static final class DriveConstants
        {
        /* MOTOR IDs */
        public static final int TOP_LEFT_MOTOR_ID = 9;
        public static final int BOTTOM_LEFT_MOTOR_ID = 8;
        public static final int TOP_RIGHT_MOTOR_ID = 19;
        public static final int BOTTOM_RIGHT_MOTOR_ID = 16;

        /* MOTOR CONTROLLER GROUPS */
        public static final boolean[] MOTOR_CONTROLLER_GROUPS_INVERTED =
            { true, false };

        /* JOYSTICK DEADBAND */
        public static final double JOYSTICK_DEADBAND = 0.05;

        /* Gears */
        public static final DriveGears defaultGear = DriveGears.GEAR1;
        public static final int GEAR_DOWN_BUTTON_ID = 1;
        public static final int GEAR_UP_BUTTON_ID = 1;
        }

    public static final class AutonomousConstants
        {
        /* Autonomous Hardware IDs */
        public static final int USE_AUTO_SWITCH_ID = 10;
        public static final int[] AUTO_SIX_POSITION_SWITCH_IDS =
            { 15, 13, 14, 18, 16, 17 };
        public static final int AUTO_DELAY_POT_ID = 2;

        /* Autonomous Delay */
        public static final double AUTO_MAX_DELAY_SECONDS = 5.0;

        /* Autonomous Drive Constants */
        public static final double AUTO_MAX_DRIVE_SPEED = 0.3;
        }

    public static final class JoystickConstants
        {
        /* JOYSTICK IDs */
        public static final int LEFT_DRIVER_JOYSTICK_ID = 0;
        public static final int RIGHT_DRIVER_JOYSTICK_ID = 1;
        public static final int LEFT_OPERATOR_JOYSTICK_ID = 2;
        public static final int RIGHT_OPERATOR_JOYSTICK_ID = 3;
        }

    public static final class CameraConstants
        {
        /* SOFTWARE PROPERTIES */
        public static final boolean USING_TWO_CAMERAS = true;
        public static final int SWITCH_CAMERA_BUTTON_ID = 10;
        public static final double SWITCH_CAMERA_DEBOUNCE_TIME = 0.25;

        /* CAMERA PROPERTIES */
        public static final int[] resolution =
            { 340, 240 };
        public static final int framesPerSecond = 20;
        public static final int compression = 60;
        }
    }
