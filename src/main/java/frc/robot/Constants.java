package frc.robot;

public final class Constants
    {
    public static final class DriveConstants
        {
        // MOTOR IDs
        public static final int TOP_LEFT_MOTOR_ID = 9;
        public static final int BOTTOM_LEFT_MOTOR_ID = 8;
        public static final int TOP_RIGHT_MOTOR_ID = 19;
        public static final int BOTTOM_RIGHT_MOTOR_ID = 16;

        // MOTOR CONTROLLER GROUPS
        public static final boolean[] MOTOR_CONTROLLER_GROUPS_INVERTED =
            { true, false };

        // JOYSTICK DEADBAND
        public static final double JOYSTICK_DEADBAND = 0.05;

        // GEARS
        public enum DRIVE_GEARS
            {
            GEAR1(0, 0.3), GEAR2(1, 0.5);

            private double ratio;
            private int id;

            private DRIVE_GEARS(int id, double ratio)
                {
                    this.id = id;
                    this.ratio = ratio;
                }

            public static DRIVE_GEARS getFromId(int id)
            {
                for (DRIVE_GEARS gear : values())
                    {
                    if (gear.id == id)
                        {
                        return gear;
                        }
                    }
                return null;
            }

            public int getId()
            {
                return id;
            }

            public double getRatio()
            {
                return ratio;
            }
            }

        public static final DRIVE_GEARS defaultGear = DRIVE_GEARS.GEAR1;
        public static final int GEAR_DOWN_BUTTON_ID = 1;
        public static final int GEAR_UP_BUTTON_ID = 1;
        }

    public static final class AutonomousConstants
        {
        public static final int DISABLE_AUTO_SWITCH_ID = 10;
        }

    public static final class JoystickConstants
        {
        // JOYSTICK IDs
        public static final int LEFT_DRIVER_JOYSTICK_ID = 0;
        public static final int RIGHT_DRIVER_JOYSTICK_ID = 1;
        public static final int LEFT_OPERATOR_JOYSTICK_ID = 2;
        public static final int RIGHT_OPERATOR_JOYSTICK_ID = 3;
        }

    public static final class CameraConstants
        {
        // SOFTWARE PROPERTIES
        public static final boolean USING_TWO_CAMERAS = true;
        public static final int SWITCH_CAMERA_BUTTON_ID = 10;
        public static final double SWITCH_CAMERA_DEBOUNCE_TIME = 0.25;

        // CAMERA PROPERTIES
        public static final int[] resolution =
            { 340, 240 };
        public static final int framesPerSecond = 20;
        public static final int compression = 60;
        }
    }
