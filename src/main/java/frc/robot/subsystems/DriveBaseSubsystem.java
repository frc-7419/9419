// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBaseSubsystem extends SubsystemBase {
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;

  public DriveBaseSubsystem() {
    left1 = new TalonFX(leftmast.id);
    left2 = new TalonFX(leftfollow.id);
    right1 = new TalonFX(rightmast.id);
    right2 = new TalonFX(rightfollow.id);

    right1.setInverted(true);
    right1.setSensorPhase(false);
    right2.setInverted(true);
    right2.setSensorPhase(false);

    left1.setInverted(false);
    left2.setInverted(false);

    left2.follow(left1);
    right2.follow(right1);
  }

  public void setLeftPower(double power) {
    // left1.set
    left1.set(ControlMode.PercentOutput, power);
    left2.set(ControlMode.PercentOutput, power);
  }

  public void setRightPower(double power) {
    // right1.set
    right1.set(ControlMode.PercentOutput, power);
    right2.set(ControlMode.PercentOutput, power);
  }
  public TalonFX getLeftMast() {
    return left1;
  }
  public TalonFX getRightMast() {
    return right1;
  }
  public TalonFX getLeftFollow() {
    return left2;
  }
  public TalonFX getRightFollow() {
    return right2;
  }

  public void allPower(double power){
    setLeftPower(power);
    setRightPower(power);
  }
  public void stop(){allPower(0);}
  public void setAllMode(NeutralMode mode){
    right1.setNeutralMode(mode);
    right2.setNeutralMode(mode);
    left1.setNeutralMode(mode);
    left2.setNeutralMode(mode);
  }
  public void brake(){setAllMode(NeutralMode.Brake);}
  public void coast(){setAllMode(NeutralMode.Coast);}

  public double getLeftVelocity(){return left1.getSelectedSensorVelocity();}
  public double getRightVelocity(){return right1.getSelectedSensorVelocity();}
  
  public void factoryResetAll() {
    right1.configFactoryDefault();
    right2.configFactoryDefault();
    left1.configFactoryDefault();
    left2.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
