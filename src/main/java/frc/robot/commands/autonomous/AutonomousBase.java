package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.hardwareInterfaces.Potentiometer;
import frc.robot.Constants.*;

/**
 * The {@code AutonomousBase} Class is used as the base class for Autonomous
 * Commands
 * 
 * <p>
 * It's purpose is to handle the Delay Potentiometer before running
 * </p>
 */
public abstract class AutonomousBase extends CommandBase
    {
    private static Potentiometer autoDelayPotentiometer = new Potentiometer(
            AutonomousConstants.AUTO_DELAY_POT_ID);
    private static Timer autoDelayTimer = new Timer();
    private static boolean autoDelayTimerStarted = false;

    @Override
    public final void execute()
    {
        /* Handle Delay Potentiometer */
        if (autoDelayTimerStarted == false)
            {
            autoDelayTimer.start();
            autoDelayTimerStarted = true;
            }
        else
            {
            if (autoDelayTimer.hasElapsed(autoDelayPotentiometer.get(0,
                    AutonomousConstants.AUTO_MAX_DELAY_SECONDS)))
                {
                executeAutonomous();
                }
            }
    }

    /**
     * The main body of an autonomous command. Called repeatedly while the
     * command is scheduled once the {@link #autoDelayTimer} has elappsed the
     * set time.
     */
    public void executeAutonomous()
    {
    }

    }
