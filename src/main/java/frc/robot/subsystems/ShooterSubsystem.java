package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX shooter;
    private DigitalInput beambreak;
    public ShooterSubsystem(){
        this.shooter = new TalonFX(shoter.id);
        this.beambreak = new DigitalInput(1);
    }

    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
    }
    public void coast(){
        shooter.setNeutralMode(NeutralMode.Coast);
    }

    public boolean getBeamBreak(){
        return beambreak.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("beam break", getBeamBreak());
    }
}