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
    private DigitalInput beamBreakSensor;

    public ShooterSubsystem(){
        shooter = new TalonFX(shoter.id);
        beamBreakSensor = new DigitalInput(beambreak.id);
    }

    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
    }
    public void coast(){
        shooter.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
        SmartDashboard.putBoolean("Beam-break Detection", beamBreakSensor.get());
    }
}