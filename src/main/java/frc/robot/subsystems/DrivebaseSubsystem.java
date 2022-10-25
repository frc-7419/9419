// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.CanIds;

public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;

  public DrivebaseSubsystem() {
    left1 = new TalonFX(2);
    left2 = new TalonFX(3);
    right1 = new TalonFX(4);
    right2 = new TalonFX(5);
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
