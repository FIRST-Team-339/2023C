package frc.robot.subsystems;

import frc.robot.TankModule;
import frc.robot.Constants;
import frc.robot.Constants.*;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.PneumaticsBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.playingwithfusion.CANVenom;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Compressor;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.HardwareInterfaces.DoubleSolenoid;
import frc.HardwareInterfaces.LightSensor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ArmSubsystem extends SubsystemBase
        {
        private MotorController armLengthMotor = new WPI_VictorSPX(
                        Constants.ARM_LENGTH_MOTOR_ID);
        private MotorController armRaiseMotor = new CANVenom(
                        Constants.ARM_RAISE_MOTOR_ID);

        private LightSensor bottomArmSwitch = new LightSensor(
                        Constants.BOTTOM_ARM_SWITCH_PORT);
        private LightSensor topArmSwitch = new LightSensor(
                        Constants.TOP_ARM_SWITCH_PORT);

        private Compressor compressor = new Compressor(
                        PneumaticsModuleType.CTREPCM);

        private DoubleSolenoid clawPiston = new DoubleSolenoid(
                        Constants.CLAW_FWD_PORT, Constants.CLAW_REV_PORT);
        private DoubleSolenoid armRaisePiston = new DoubleSolenoid(
                        Constants.ARM_RAISE_FWD_PORT,
                        Constants.ARM_RAISE_REV_PORT);

        public ArmSubsystem()
                {
                        armRaiseMotor.setInverted(false);
                        clawPiston.setForward(true);
                        armLengthMotor.setInverted(false);
                        armRaisePiston.setForward(true);
                }

        /**
         * Arm control and claw control code goes here.
         *
         * @author Kaelyn Atkins
         * @editor Bryan Fernandez
         * @written February 9, 2023
         */
        public void armControl(double value, double otherValue, boolean button,
                        boolean otherButton)
        {
                boolean limitStatus = false;

                // Checks if claw trigger button has been pressed and sets the
                // claw
                // piston to
                // the opposite direction each time it is pressed

                // clawPiston.setForward((button) == true ? false : true);

                if (button == true)
                        {
                        this.clawPiston.setForward(true);
                        }
                else
                        {
                        this.clawPiston.setForward(false);
                        }

                // Checks if arm raise button has been pressed and sets the arm
                // raise
                // piston to
                // the opposite direction each time it is pressed
                // if (Constants.inDemoMode == false)
                // {
                if (otherButton == true)
                        {
                        this.armRaisePiston.setForward(true);
                        }
                else
                        {
                        this.armRaisePiston.setForward(false);
                        }
                // }

                // -----------------
                // Arm motor controls
                // ------------------

                // If right operator Y value is between -0.2 and +0.2 then the
                // armRaiseMotor will equal the armControlHoldSpeed
                if (value >= -Constants.ARM_CONTROL_DEADBAND
                                && value <= Constants.ARM_CONTROL_DEADBAND)
                        {
                        this.armRaiseMotor
                                        .set(Constants.ARM_CONTROL_HOLD_SPEED);
                        }
                else
                        {
                        // If right operator Y value is less than the
                        // ARM_CONTROL_DEADBAND
                        // then the ArmRaiseMotor will equal the equation below

                        // if (Constants.inDemoMode == true)
                        // {
                        limitStatus = bottomArmSwitch.isOn();
                        // } // if
                        // else
                        // {
                        // limitStatus = false;
                        // } // else
                        if ((value < -Constants.ARM_CONTROL_DEADBAND)
                                        && limitStatus == false)
                                {
                                this.armRaiseMotor.set(
                                                ((-Constants.ARM_RAISE_MAX_SPEED_DOWN
                                                                + Constants.ARM_RAISE_MIN_SPEED_NEGATIVE)
                                                                / (-Constants.MAX_JOYSTICK_OPERATOR_VALUE
                                                                                + Constants.MIN_JOYSTICK_OPERATOR_VALUE))
                                                                * (value + Constants.MIN_JOYSTICK_OPERATOR_VALUE)
                                                                - Constants.ARM_RAISE_MIN_SPEED_NEGATIVE);

                                } // end if
                                  // If right operator Y value is greater than
                                  // the
                                  // ARM_CONTROL_DEADBAND
                                  // then the ArmRaiseMotor will equal the
                                  // equation below
                                  // if (Constants.inDemoMode == true)
                                  // {
                        limitStatus = topArmSwitch.isOn();
                        // } // if
                        // else
                        // {
                        // limitStatus = false;
                        // } // else
                        if (value > Constants.ARM_CONTROL_DEADBAND
                                        && limitStatus == false)
                                {
                                this.armRaiseMotor.set(
                                                ((Constants.ARM_RAISE_MAX_SPEED_UP
                                                                - Constants.ARM_RAISE_MIN_SPEED_POSITIVE)
                                                                / (Constants.MAX_JOYSTICK_OPERATOR_VALUE
                                                                                - Constants.MIN_JOYSTICK_OPERATOR_VALUE))
                                                                * (value - Constants.MIN_JOYSTICK_OPERATOR_VALUE)
                                                                + Constants.ARM_RAISE_MIN_SPEED_POSITIVE);
                                } // end if
                        } // end else
                          // If left operator Y value is between -0.2 and +0.2
                          // then the
                          // armLengthMotor will equal the ARM_LENGTH_HOLD_SPEED
                // if (Constants.inDemoMode == false)
                // {
                if (otherValue >= -Constants.ARM_LENGTH_DEADBAND
                                && otherValue <= Constants.ARM_LENGTH_DEADBAND)
                        {
                        this.armLengthMotor
                                        .set(Constants.ARM_LENGTH_HOLD_SPEED);
                        } // end if
                else
                        {
                        // If left operator Y value is less than the
                        // ARM_LENGTH_DEADBAND
                        // then
                        // the ArmLengthMotor will equal the equation below
                        if (otherValue < -Constants.ARM_LENGTH_DEADBAND)
                                {
                                this.armLengthMotor.set(
                                                ((-Constants.ARM_LENGTH_MAX_SPEED
                                                                + Constants.ARM_LENGTH_MIN_SPEED)
                                                                / (-Constants.MAX_JOYSTICK_OPERATOR_VALUE
                                                                                + Constants.MIN_JOYSTICK_OPERATOR_VALUE))
                                                                * (otherValue + Constants.MIN_JOYSTICK_OPERATOR_VALUE)
                                                                - Constants.ARM_LENGTH_MIN_SPEED);
                                } // end if
                                  // If left operator Y value is greater than
                                  // the
                                  // ARM_LENGTH_DEADBAND
                                  // then the ArmLengthMotor will equal the
                                  // equation below
                        if (otherValue > Constants.ARM_LENGTH_DEADBAND)
                                {
                                this.armLengthMotor.set(
                                                ((Constants.ARM_LENGTH_MAX_SPEED
                                                                - Constants.ARM_LENGTH_MIN_SPEED)
                                                                / (Constants.MAX_JOYSTICK_OPERATOR_VALUE
                                                                                - Constants.MIN_JOYSTICK_OPERATOR_VALUE))
                                                                * (otherValue - Constants.MIN_JOYSTICK_OPERATOR_VALUE)
                                                                + Constants.ARM_LENGTH_MIN_SPEED);
                                } // end if

                        } // end else
                          // }

        } // end of armControl()

        @Override
        public void periodic()
        {
                // This block of code runs once per schedular 'tick'
                // Pretty much do nothing in this section
        }

        }
