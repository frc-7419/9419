// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.sensors.PigeonIMU;

public class GyroSubsystem extends SubsystemBase {
  /** Creates a new GyroSubsystem. */

  private PigeonIMU gyro;

  public GyroSubsystem() {
    // try {
		// 	/* Communicate w/navX-MXP via the MXP SPI Bus (use mini USB to USB A cable)   
		// 	   Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or S     
		// 	   See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
    //            ahrs = new AHRS(SerialPort.Port.kMXP); 
		// } catch (RuntimeException ex ) {
    //         DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true); 
    //     }
    this.gyro = new PigeonIMU(0);
  }

  public double getGyroYaw() {
    double[] ypr = new double[3];
    gyro.getYawPitchRoll(ypr);
    return ypr[0];
  }

  public double getGyroPitch() {
    double[] ypr = new double[3];
    gyro.getYawPitchRoll(ypr);
    return ypr[1];
  }

  public double getGyroRoll() {
    double[] ypr = new double[3];
    gyro.getYawPitchRoll(ypr);
    return ypr[2];
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("gyro yaw", getGyroYaw());
    SmartDashboard.putNumber("gyro pitch", getGyroPitch());
    SmartDashboard.putNumber("gyro roll", getGyroRoll());
    // This method will be called once per scheduler run
  }
}
