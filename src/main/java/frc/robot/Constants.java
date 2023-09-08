package frc.robot;

public class Constants
    {
    public static final int LEFT_BOTTOM_MOTOR_ID = 8;
    public static final int LEFT_TOP_MOTOR_ID = 9;
    public static final int RIGHT_BOTTOM_MOTOR_ID = 16;
    public static final int RIGHT_TOP_MOTOR_ID = 19;

    public static final int ARM_LENGTH_MOTOR_ID = 23;
    public static final int ARM_RAISE_MOTOR_ID = 21;

    public static final int LEFT_DRIVER_JOYSTICK_ID = 0;
    public static final int RIGHT_DRIVER_JOYSTICK_ID = 1;
    public static final int LEFT_OPERATOR_JOYSTICK_ID = 2;
    public static final int RIGHT_OPERATOR_JOYSTICK_ID = 3;

    public static final int GEAR_UP_BUTTON_ID = 1;
    public static final int GEAR_DOWN_BUTTON_ID = 1;

    public static final double FIRST_GEAR = 0.3;
    public static final double SECOND_GEAR = 0.5;
    public static final double THIRD_GEAR = 0.7;

    public static final double DEADBAND = 0.2;

    public static final int ARM_CLAW_BUTTON_ID = 1;
    public static final int ARM_RAISE_PISTON_BUTTON_ID = 1;

    public final static int ARM_RAISE_FWD_PORT = 0;
    public final static int ARM_RAISE_REV_PORT = 1;

    public final static int CLAW_FWD_PORT = 6;
    public final static int CLAW_REV_PORT = 7;

    public final static int BOTTOM_ARM_SWITCH_PORT = 0;
    public final static int TOP_ARM_SWITCH_PORT = 6;

    public final static double ARM_RAISE_MAX_SPEED_UP = 0.75;
    public final static double ARM_RAISE_MAX_SPEED_DOWN = 0.6;
    public final static double ARM_RAISE_MIN_SPEED_POSITIVE = 0.0;
    public final static double ARM_RAISE_MIN_SPEED_NEGATIVE = 0.2;
    public final static double ARM_LENGTH_MAX_SPEED = 0.75;
    public final static double ARM_LENGTH_MIN_SPEED = 0.0;
    public final static double MAX_JOYSTICK_OPERATOR_VALUE = 1.0;
    public final static double MIN_JOYSTICK_OPERATOR_VALUE = 0.201;
    public final static double ARM_CONTROL_HOLD_SPEED = 0.02;
    public final static double ARM_LENGTH_HOLD_SPEED = 0.0;
    public final static double ARM_CONTROL_DEADBAND = 0.2;
    public final static double ARM_LENGTH_DEADBAND = 0.2;
    public final static int ARM_RAISE_MAX_TICKS = -110;

    public static final int DISABLE_AUTO_SWITCH_ID = 10;

    public static final boolean USING_TWO_CAMERAS = true;
    public static final int SWITCH_CAMERA_BUTTON_ID = 10;
    public static final double SWITCH_CAMERA_DEBOUNCE_TIME = 0.25;
    public static final int[] RESOLUTION =
        { 340, 240 };
    public static final int FRAMES_PER_SECOND = 20;
    public static final int COMPRESSION = 60;

    // public enum DRIVE_GEARS
    // {
    // GEAR1(0, 0.3), GEAR2(1, 0.5);

    // private double ratio;
    // private int id;

    // private DRIVE_GEARS(int id, double ratio)
    // {
    // this.id = id;
    // this.ratio = ratio;
    // }

    // public static DRIVE_GEARS getFromId(int id)
    // {
    // for (DRIVE_GEARS gear : values())
    // {
    // if (gear.id == id)
    // {
    // return gear;
    // }
    // }
    // return null;
    // }

    // public int getId()
    // {
    // return id;
    // }

    // public double getRatio()
    // {
    // return ratio;
    // }
    // }
    }
