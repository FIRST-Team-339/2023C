package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmAssembly;

public class ArmControl extends CommandBase {
    private ArmAssembly armAssembly;
    DoubleSupplier raiseMotor;
    DoubleSupplier extendMotor;

    public ArmControl(ArmAssembly assembly, DoubleSupplier raiseMotor, DoubleSupplier extendMotor){
        this.armAssembly = assembly;
        addRequirements(armAssembly);

        this.extendMotor = extendMotor;
        this.raiseMotor = raiseMotor;
    }

    @Override
    public void execute(){
        armAssembly.manipulateArm(extendMotor.getAsDouble(),raiseMotor.getAsDouble());
    }

}
