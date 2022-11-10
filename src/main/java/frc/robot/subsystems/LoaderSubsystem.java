// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import static frc.robot.Constants.CanIds.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LoaderSubsystem extends SubsystemBase {
  
  private TalonSRX talonSRX;

  /** Creates a new LoaderSubsystem. */
  public LoaderSubsystem() {
    this.talonSRX = new TalonSRX(talon.id);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setPower(double power) {
    talonSRX.set(ControlMode.PercentOutput, power);
  }
}
