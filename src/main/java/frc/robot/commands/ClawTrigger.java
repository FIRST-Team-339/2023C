package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DashboardSubsystem;

public class ClawTrigger extends CommandBase
    {
    /* Subsystems */
    private ClawSubsystem clawSubsystem;
    private DashboardSubsystem dashboardSubsystem;

    public ClawTrigger(ClawSubsystem clawSubsystem,
            DashboardSubsystem dashboardSubsystem)
        {
            addRequirements(clawSubsystem);
            this.clawSubsystem = clawSubsystem;
            this.dashboardSubsystem = dashboardSubsystem;
        }

    @Override
    public void execute()
    {
        /**
         * If the claw is already open, tell the Claw Subsystem to close
         * 
         * Otherwise, tell the Claw Subsystem to open
         */
        if (clawSubsystem.isOpen() == true)
            {
            clawSubsystem.close();
            }
        else
            {
            clawSubsystem.open();
            }
        dashboardSubsystem.updateClawClosedIndicator(!(clawSubsystem.isOpen()));

        // Cancels the command as it has ran
        cancel();
    }
    }
