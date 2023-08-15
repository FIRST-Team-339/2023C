package frc.robot;


enum year {
                TWENTY_THREE, TWENTY_THREE_C
            };

public final class Constants
    {
/**
 * There is some possibilites here with the years being sub classes
 * Maybe we can have a method of some form that can return a reference to the specific year values
 * 
 * I am not sure of the java implementation, writing note to refresh conversation.
 * 
 */



        /*
         * 2023
         */

        public static final class TwentyThree{

            /* Joysticks */
            public static int LEFT_DRIVER_PORT = 0;
            public static int RIGHT_DRIVER_PORT  = 1;

            public static int LEFT_OPERATOR_PORT = 2;
            public static int RIGHT_OPERATOR_PORT = 3;

            public static double JOYSTICK_DEADBAND = 0.2;
            public static double ARM_DEADBAND = 0.2;

            /* Buttons */
            public static int GEAR_UP_BUTTON = 1;
            public static int GEAR_DOWN_BUTTON = 1;

            public static int CLAW_FOWARD_BUTTON = 1;
            public static int ARM_RAISED_BUTTON = 1;
        
            /* Motor Controllers */
            public static int LEFT_FRONT_DRIVE_ID = 0;
            public static int LEFT_REAR_DRIVE_ID = 1;
            public static int RIGHT_FRONT_DRIVE_ID = 2;
            public static int RIGHT_REAR_DRIVE_ID = 3;

            public static int ARM_RAISE_MOTOR_ID = 21;
            public static int ARM_LENGTH_MOTOR_ID = 23;

            /* Pneumatics  */
            public static int CLAW_PISTON_FWD_PORT = 6;
            public static int CLAW_PISTON_REV_PORT = 7;

            public static int ARM_RAISE_FWD_PORT = 2;
            public static int ARM_RAISE_REV_PORT = 3;

            /* Gears */
            public static int MAX_GEARS = 2;
            public static double GEAR_ONE = 0.6;
            public static double GEAR_TWO = 0.9;

            /* Values */
            public static double ARM_HOLD_SPEED = 0.02;
        }

        /*
         * 2023C 
         */
        public static final class TwentyThreeC{

        }

        /*
         * Determine which constants to use
         */

        private static year currentYear = year.TWENTY_THREE;

        public static Object getCurrentConstants(){
            
            switch(currentYear){
                case TWENTY_THREE:
                    return new TwentyThree();

                case TWENTY_THREE_C:
                    return new TwentyThreeC();

            }
            return null;
        }

    }
