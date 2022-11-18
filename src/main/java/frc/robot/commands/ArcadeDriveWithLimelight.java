// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

/** An example command that uses an example subsystem. */
public class ArcadeDriveWithLimelight extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveBaseSubsystem drivebaseSubsystem;
  private XboxController joystick;
  private LimelightSubsystem limelightSubsystem;
  private double straightCoefficient = 0.55;//0.25;
  private double turnCoefficient = 0.25;
  private ShuffleboardTab distanceTab = Shuffleboard.getTab("Robot Distance");
  private NetworkTableEntry distanceEntry = distanceTab.add("Distance (Meters) ",0).getEntry();
  private double kPdistance = Constants.PIDConstants.DriveBaseMotionMagickP; //PID control... use this value for now
  private double threshold = 0.8;
  private double wantDistance = 5.0;
  private final SlewRateLimiter speedLimiter = new SlewRateLimiter(100);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveWithLimelight(DriveBaseSubsystem drivebaseSubsystem, XboxController joystick, LimelightSubsystem limelightSubsystem) {
    this.drivebaseSubsystem = drivebaseSubsystem;
    this.joystick = joystick;
    this.limelightSubsystem = limelightSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebaseSubsystem, limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeed = -1 * speedLimiter.calculate(joystick.getLeftY() * straightCoefficient);
    double zRotation = joystick.getRightX() * turnCoefficient;
 
    double leftPower = xSpeed + zRotation;
    double rightPower = xSpeed - zRotation;
    distanceEntry.setDouble(limelightSubsystem.getDistance());

    if ((joystick.getRightBumperPressed() || joystick.getLeftBumperPressed()) && limelightSubsystem.getTv()==1) { //buttons will be decided later
      // threshold = 0.5 + 0.5 = 1
      if (limelightSubsystem.getDistance() < wantDistance-threshold) {
        drivebaseSubsystem.setLeftPower(0.3);
        drivebaseSubsystem.setRightPower(0.3);
      }
      else if (limelightSubsystem.getDistance() > wantDistance+threshold) {
        drivebaseSubsystem.setRightPower(-0.3);
        drivebaseSubsystem.setLeftPower(-0.3);
      }
    }
    else {
      drivebaseSubsystem.setLeftPower(leftPower);
      drivebaseSubsystem.setRightPower(rightPower);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivebaseSubsystem.setLeftPower(0);
    drivebaseSubsystem.setRightPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
