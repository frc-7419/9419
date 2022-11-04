package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX shooter;
    private DigitalInput sensor;

    public ShooterSubsystem(){
        shooter = new TalonFX(62);
        sensor = new DigitalInput(0);
    }

    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
    }
    public void coast(){
        shooter.setNeutralMode(NeutralMode.Coast);
    }
    public boolean getBeamBroken(){
        return sensor.get();
    }

}