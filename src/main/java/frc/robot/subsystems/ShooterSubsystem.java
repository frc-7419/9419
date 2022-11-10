package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team7419.TalonFuncs;

import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIds;
import frc.robot.Constants.RobotConstants;


public class ShooterSubsystem extends SubsystemBase{
<<<<<<< Updated upstream
    private TalonFX shooterFX;
    private DigitalInput beambreak;
    public ShooterSubsystem(){
        this.shooterFX = new TalonFX(shooter.id);
        this.beambreak = new DigitalInput(1);
    }
=======
    private TalonFX shooter;
    private DigitalInput beamBreakSensor;
    private SimpleMotorFeedforward topFeedforward;

    private double maxVoltage = 11;
    private double topTargetVelocity = 0;
    private double topTargetRawVelocity = 0;

    public ShooterSubsystem(){
        shooter = new TalonFX(shoter.id);
        beamBreakSensor = new DigitalInput(beambreak.id);
        topFeedforward = new SimpleMotorFeedforward(RobotConstants.TopShooterKs, RobotConstants.TopShooterKv);
        

        shooter.configVoltageCompSaturation(maxVoltage); //before: topfalcon
        shooter.enableVoltageCompensation(true);
        
        shooter.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        shooter.setInverted(false);
>>>>>>> Stashed changes

    }
    
    public void setShooterPower(double power){
        shooterFX.set(ControlMode.PercentOutput, power);
    }

    public void setTopClosedLoopVelocity(double velocityMetersPerSecond) {
        this.topTargetVelocity = velocityMetersPerSecond;
        this.topTargetRawVelocity = velocityMetersPerSecond * RobotConstants.RotationsPerMeter * 2048 * 0.1;
        shooter.set(ControlMode.Velocity, velocityMetersPerSecond * RobotConstants.RotationsPerMeter * 2048 * 0.1, DemandType.ArbitraryFeedForward, topFeedforward.calculate(velocityMetersPerSecond) / maxVoltage);
    }

    public void off() {
        setShooterPower(0);
    }
    
    public void setTopPIDF(double kP, double kI, double kD, double kF){
        TalonFuncs.setPIDFConstants(0, shooter, kP, kI, kD, kF);
    }
    
    public void coast(){
        shooterFX.setNeutralMode(NeutralMode.Coast);
    }

<<<<<<< Updated upstream
    public boolean getBeamBreak(){
        return beambreak.get();
=======
    public boolean getBeambreak(){
        return beamBreakSensor.get();

    
>>>>>>> Stashed changes
    }

    @Override
    public void periodic() {
<<<<<<< Updated upstream
        SmartDashboard.putBoolean("beam break", getBeamBreak());
    }
=======
    // This method will be called once per scheduler run
        SmartDashboard.putBoolean("Beam-break Detection", beamBreakSensor.get());
                                                                                                                                                                                                                                                                                                        }
>>>>>>> Stashed changes
}