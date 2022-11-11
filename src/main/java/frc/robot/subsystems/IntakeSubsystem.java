// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private VictorSPX intake;
  public IntakeSubsystem() {
    this.intake = new VictorSPX(CanIds.intake.id);
  }

  public void setSpeed(double speed){
    intake.set(ControlMode.PercentOutput, speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
