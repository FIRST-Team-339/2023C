package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankSubsystem;

public class ShiftGear extends CommandBase
    {
    public static enum GearUpOrDown
        {
        UP, DOWN
        }

    private TankSubsystem tankSubsystem;
    private GearUpOrDown gearState;

    public ShiftGear(TankSubsystem tankSubsystem, GearUpOrDown gearState)
        {
            this.tankSubsystem = tankSubsystem;
            this.gearState = gearState;
        }

    @Override
    public void execute()
    {
        /**
         * If the `gearState` value is set to UP, tell the Tank Subsystem to
         * shift up a gear
         * 
         * Otherwise, tell the Tank Subsystem to shift down a gear
         */
        switch (gearState)
            {
            case UP:
                tankSubsystem.shiftGearUp();
                break;
            case DOWN:
                tankSubsystem.shiftGearDown();
                break;
            default:
                break;
            }

        cancel();
    }

    }
