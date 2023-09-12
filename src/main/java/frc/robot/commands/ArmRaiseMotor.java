package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.*;
import frc.robot.hardwareInterfaces.LightSensor;
import frc.robot.subsystems.ArmRaiseMotorSubsystem;

public class ArmRaiseMotor extends CommandBase
    {
    /* Arm Raise Motor Subsystem */
    private ArmRaiseMotorSubsystem armRaiseMotorSubsystem;

    /* Joystick Value */
    private DoubleSupplier joystickValue;

    /* Limit Switches */
    /**
     * The top limit switch on the arm classed as a {@link LightSensor}
     */
    private LightSensor topLimitSwitch = new LightSensor(
            ArmAndClawConstants.ARM_TOP_LIMIT_SWITCH_ID);
    /**
     * The top limit switch on the arm classed as a {@link LightSensor}
     */
    private LightSensor bottomLimitSwitch = new LightSensor(
            ArmAndClawConstants.ARM_BOTTOM_LIMIT_SWITCH_ID);
    private boolean canRaiseArm = true;
    private boolean canLowerArm = true;

    public ArmRaiseMotor(ArmRaiseMotorSubsystem armRaiseMotorSubsystem,
            DoubleSupplier joystickValue)
        {
            addRequirements(armRaiseMotorSubsystem);
            this.armRaiseMotorSubsystem = armRaiseMotorSubsystem;
            this.joystickValue = joystickValue;
        }

    @Override
    public void execute()
    {
        double currentJoystickValue = joystickValue.getAsDouble();

        if (currentJoystickValue > 0.0 && canRaiseArm)
            {
            if (topLimitSwitch.get())
                {
                canRaiseArm = false;
                }
            else
                {
                armRaiseMotorSubsystem.setSpeed(currentJoystickValue
                        * ArmAndClawConstants.ARM_RAISE_SPEED_MULITPLIER);
                }
            canLowerArm = true;
            }
        else
            if (currentJoystickValue < 0.0 && canLowerArm)
                {
                if (bottomLimitSwitch.get())
                    {
                    canLowerArm = false;
                    }
                else
                    {
                    armRaiseMotorSubsystem.setSpeed(currentJoystickValue
                            * ArmAndClawConstants.ARM_RAISE_SPEED_MULITPLIER);
                    }
                canRaiseArm = true;
                }
    }
    }
