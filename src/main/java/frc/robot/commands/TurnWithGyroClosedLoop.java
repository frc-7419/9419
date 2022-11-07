// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class TurnWithGyroClosedLoop extends CommandBase {
  /** Creates a new TurnWithGyroClosedLoop. */

  private DrivebaseSubsystem driveBaseSubsystem;
  private GyroSubsystem gyroSubsystem;
  private double target;
  private double tolerance;
  private double kP;
  private double kI;
  private double kD;
  private PIDController pidController;
  private double pidOutput;
  private double initAngle;

  public TurnWithGyroClosedLoop(DrivebaseSubsystem driveBaseSubsystem, GyroSubsystem gyroSubsystem, double target, double tolerance, double kP, double kI, double kD) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.gyroSubsystem = gyroSubsystem;
    this.target = target;
    this.tolerance = tolerance;
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBaseSubsystem.coast();
    initAngle = gyroSubsystem.getGyroAngle();
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(initAngle + target);
    pidController.setTolerance(tolerance); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pidOutput = pidController.calculate(gyroSubsystem.getGyroAngle());
    driveBaseSubsystem.setLeftPower(pidOutput);
    driveBaseSubsystem.setRightPower(-pidOutput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.allPower(0); // stop() on 7419 drivebasesubsystem
    driveBaseSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
