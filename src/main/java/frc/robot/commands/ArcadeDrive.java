// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveBaseSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;


/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveBaseSubsystem drivebaseSubsystem;
  private XboxController joystick;
  private double straightCoefficient = 0.25;
  private double turnCoefficient = 0.25;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(DriveBaseSubsystem drivebaseSubsystem, XboxController joystick) {
    this.drivebaseSubsystem = drivebaseSubsystem;
    this.joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double straightPower = straightCoefficient * joystick.getLeftY();
    double turnPower = turnCoefficient * joystick.getRightX(); 
    double leftPower = turnPower + straightPower;
    double rightPower = turnPower - straightPower;
    drivebaseSubsystem.setLeftPower(leftPower);
    drivebaseSubsystem.setRightPower(rightPower);
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
