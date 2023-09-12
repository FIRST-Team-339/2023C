package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPistonSubsystem;

public class ArmRaisePiston extends CommandBase
    {
    /* Subsystem */
    private ArmPistonSubsystem armPistonSubsystem;

    public ArmRaisePiston(ArmPistonSubsystem armPistonSubsystem)
        {
            addRequirements(armPistonSubsystem);
            this.armPistonSubsystem = armPistonSubsystem;
        }

    @Override
    public void execute()
    {
        /**
         * If the arm piston is already raised, tell the Arm Piston Subsystem to
         * lower
         * 
         * Otherwise, tell the Arm Piston Subsystem to raise
         */
        if (armPistonSubsystem.isRaised() == true)
            {
            armPistonSubsystem.lower();
            }
        else
            {
            armPistonSubsystem.raise();
            }

        // Cancels the command as it has ran
        cancel();
    }
    }
