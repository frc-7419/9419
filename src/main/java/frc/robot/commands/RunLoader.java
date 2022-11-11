// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;

public class RunLoader extends CommandBase {
  /** Creates a new RunLoader. */
  private LoaderSubsystem loaderSubsystem;
  private double power;

  public RunLoader(LoaderSubsystem loaderSubsystem, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.loaderSubsystem = loaderSubsystem;
    this.power = power;
    addRequirements(loaderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loaderSubsystem.setPower(power);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loaderSubsystem.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
