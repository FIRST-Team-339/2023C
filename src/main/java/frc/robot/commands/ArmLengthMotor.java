package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmLengthMotorSubsystem;

public class ArmLengthMotor extends CommandBase
    {
    /* Arm Length Motor Subsystem */
    private ArmLengthMotorSubsystem armLengthMotorSubsystem;

    /* Joystick Value */
    private DoubleSupplier joystickValue;

    public ArmLengthMotor(ArmLengthMotorSubsystem armLengthMotorSubsystem,
            DoubleSupplier joystickValue)
        {
            addRequirements(armLengthMotorSubsystem);
            this.armLengthMotorSubsystem = armLengthMotorSubsystem;
            this.joystickValue = joystickValue;
        }

    @Override
    public void execute()
    {
        armLengthMotorSubsystem.setSpeed(-(joystickValue.getAsDouble()));
    }
    }
