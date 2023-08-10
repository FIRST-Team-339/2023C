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

            /* Buttons */
            public static int GEAR_UP_BUTTON = 10;
            public static int GEAR_DOWN_BUTTON = 11;
        
            /* Motor Controllers */
            public static int LEFT_FRONT_DRIVE_ID = 0;
            public static int LEFT_REAR_DRIVE_ID = 1;
            public static int RIGHT_FRONT_DRIVE_ID = 2;
            public static int RIGHT_REAR_DRIVE_ID = 3;

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
