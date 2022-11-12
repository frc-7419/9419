// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.LimelightConstants;

public class TurnToTargetClosedLoop extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private DriveBaseSubsystem driveBaseSubsystem;
  private LimelightSubsystem limelightSubsystem;

  private PIDController pidController;
  
  private double kP;
  private double kI;
  private double kD;

  private double pidOutput;
  private double tx;
  private double ty;
  private double distanceToTarget;
  private double boost;
  private double kCameraHeight = LimelightConstants.kCameraHeight;
  private double velocityThreshold = 115;
  private boolean velocityBelow = false;



  public TurnToTargetClosedLoop(DriveBaseSubsystem driveBaseSubsystem, LimelightSubsystem limelightSubsystem) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(driveBaseSubsystem, limelightSubsystem);
  }

  @Override
  public void initialize() {

    kP = .005; // gets P coefficient from dashboard
    kI = 0;
    kD = 0; 
    pidController = new PIDController(kP, kI, kD);
    pidController.setSetpoint(0);
    pidController.setTolerance(1);
  }

  @Override
  public void execute() {

    SmartDashboard.putString("command status", "pid");

    tx = limelightSubsystem.getTx();
    ty = limelightSubsystem.getTy();

    pidOutput = pidController.calculate(tx);
    boost = Math.abs(pidOutput) / pidOutput * .05;
    pidOutput += boost;
    SmartDashboard.putNumber("pidoutput", pidOutput);
    driveBaseSubsystem.setLeftPower(-pidOutput);
    driveBaseSubsystem.setRightPower(pidOutput);
    driveBaseSubsystem.brake();
    // distanceToTarget = (LimelightConstants.kTargetHeight - LimelightConstants.kCameraHeight) / Math.tan(Math.toRadians(ty));
    // distanceToTarget = 1.426*distanceToTarget - 52.372;// linear regression needs to be updated for 9419
    // SmartDashboard.putNumber("distance", distanceToTarget);

    if(Math.abs(driveBaseSubsystem.getLeftVelocity()) < velocityThreshold){
      if(Math.abs(driveBaseSubsystem.getRightVelocity()) < velocityThreshold){
        velocityBelow = true;
      }
    }
}
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
