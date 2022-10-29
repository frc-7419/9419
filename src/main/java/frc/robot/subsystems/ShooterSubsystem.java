package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX shooter;

    public ShooterSubsystem(){
        this.shooter = new TalonFX(shoter.id);
    }

    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
    }
    public void coast(){
        shooter.setNeutralMode(NeutralMode.Coast);
    }


}