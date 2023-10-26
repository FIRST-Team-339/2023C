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
public final class Constants {
    public static final class DriveConstants {
        /* MOTOR IDs */
        public static final int TOP_LEFT_MOTOR_ID = 9;
        public static final int BOTTOM_LEFT_MOTOR_ID = 8;
        public static final int TOP_RIGHT_MOTOR_ID = 19;
        public static final int BOTTOM_RIGHT_MOTOR_ID = 16;

        /* Encoder */
        public static final double DISTANCE_PER_PULSE = 0.00100001;

        /* MOTOR CONTROLLER GROUPS */
        public static final boolean[] MOTOR_CONTROLLER_GROUPS_INVERTED = { false, true };

        /* JOYSTICK DEADBAND */
        public static final double JOYSTICK_DEADBAND = 0.05;

        /* Gears */
        public static final DriveGears defaultGear = DriveGears.GEAR1;
        public static final int GEAR_DOWN_BUTTON_ID = 1;
        public static final int GEAR_UP_BUTTON_ID = 1;

        /* Rate Limits */
        public static final double ACCELERATION_RATE_LIMIT = 1.0;
        public static final double BRAKE_RATE_LIMIT = 0.8;
        public static final double DRIVE_STRAIGHT_CORRECTION_DELTA = 0.1;
    }

    public static final class AutonomousConstants {
        /* Autonomous Hardware IDs */
        public static final int USE_AUTO_SWITCH_ID = 10;
        public static final int[] AUTO_SIX_POSITION_SWITCH_IDS = { 15, 13, 14, 18, 16, 17 };
        public static final int AUTO_DELAY_POT_ID = 2;

        /* Autonomous Delay */
        public static final double AUTO_MIN_DELAY_SECONDS = 0.0;
        public static final double AUTO_MAX_DELAY_SECONDS = 5.0;

        /* Autonomous Drive Constants */
        public static final double AUTO_MAX_DRIVE_SPEED = 0.3;
    }

    public static final class JoystickConstants {
        /* JOYSTICK IDs */
        public static final int LEFT_DRIVER_JOYSTICK_ID = 0;
        public static final int RIGHT_DRIVER_JOYSTICK_ID = 1;
        public static final int LEFT_OPERATOR_JOYSTICK_ID = 2;
        public static final int RIGHT_OPERATOR_JOYSTICK_ID = 3;
    }

    public static final class CameraConstants {
        /* SOFTWARE PROPERTIES */
        public static final boolean USING_TWO_CAMERAS = false;

        /* BUTTON IDS */
        public static final int SWITCH_CAMERA_BUTTON_ID = 10;

        /* CAMERA PROPERTIES */
        public static final int[] RESOLUTION = { 340, 240 };
        public static final int FRAMES_PER_SECOND = 20;
        public static final int COMPRESSION = 60;
    }

    public static final class ArmAndClawConstants {
        /* HARDWARE */
        public static final int ARM_RAISE_MOTOR_ID = 21;
        public static final int ARM_LENGTH_MOTOR_ID = 23;
        public static final int ARM_RAISE_PISTON_FWD_PORT = 2;
        public static final int ARM_RAISE_PISTON_REV_PORT = 3;
        public static final int CLAW_PISTON_FWD_PORT = 6;
        public static final int CLAW_PISTON_REV_PORT = 7;
        public static final int ARM_TOP_LIMIT_SWITCH_ID = 6;
        public static final int ARM_BOTTOM_LIMIT_SWITCH_ID = 0;

        /* BUTTON IDS */
        public static final int ARM_RAISE_BUTTON_ID = 1;
        public static final int CLAW_TRIGGER_BUTTON_ID = 1;

        /* Speed Multipliers */
        public static final double ARM_RAISE_SPEED_MULITPLIER = 0.75;

        /* Arm Hold Speeds */
        public static final double ARM_RAISE_HOLD_SPEED = 0.02;
    }

    public static final class DashboardConstants {
        /* Battery Level */
        public static final double LOW_BATTERY_LEVEL = 11.5;
    }
}
