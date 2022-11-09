// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangarSubsystem extends SubsystemBase {
  private TalonFX talonFX;
  /** Creates a new HangarSubsystem. */
  public HangarSubsystem() {
    this.talonFX = new TalonFX(12);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setPower(double power) {
    this.talonFX.set(ControlMode.PercentOutput, power);
  }
}
