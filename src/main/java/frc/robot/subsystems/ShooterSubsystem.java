package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team7419.TalonFuncs;

import frc.robot.Constants;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIds;
import frc.robot.Constants.RobotConstants;


public class ShooterSubsystem extends SubsystemBase{
    // 
    // public ShooterSubsystem(){
    //     this.shooterFX = new TalonFX(shooter.id);
    //     this.beambreak = new DigitalInput(1);
    // }
    
    private DigitalInput beambreak;
    private TalonFX shooter;
    private DigitalInput beamBreakSensor;
    private SimpleMotorFeedforward topFeedforward;

    private double maxVoltage = 11;
    private double topTargetVelocity = 0;
    private double topTargetRawVelocity = 0;

    public ShooterSubsystem(){
        shooter = new TalonFX(CanIds.shooter.id);
        beamBreakSensor = new DigitalInput(CanIds.beambreak.id);
        topFeedforward = new SimpleMotorFeedforward(RobotConstants.TopShooterKs, RobotConstants.TopShooterKv);
        

        shooter.configVoltageCompSaturation(maxVoltage); //before: topfalcon
        shooter.enableVoltageCompensation(true);
        
        shooter.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        shooter.setInverted(false);

    }
    
    public void setShooterPower(double power){
        shooter.set(ControlMode.PercentOutput, power);
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
        shooter.setNeutralMode(NeutralMode.Coast);
    }

    /*public boolean getBeamBreak(){
        return beambreak.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("beam break", getBeamBreak());
    }*/
}