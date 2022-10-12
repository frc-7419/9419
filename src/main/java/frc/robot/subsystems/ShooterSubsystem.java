package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RunShooter extends SubsystemBase{
    private TalonFX shooter;

    public ShooterSubsystem(){
        shooter = new TalonFX(); // idk what falcon id is :/

    }

    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
    }
    public void coast(){
        shooter.setNeutralMode(NeutralMode.Coast);
    }


}