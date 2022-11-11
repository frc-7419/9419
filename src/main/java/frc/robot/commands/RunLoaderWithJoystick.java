// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LoaderSubsystem;

public class RunLoaderWithJoystick extends CommandBase {
  private LoaderSubsystem loaderSubsystem;
  private XboxController joystick;
  /** Creates a new RunLoaderWithJoystick. */
  public RunLoaderWithJoystick(LoaderSubsystem loaderSubsystem, XboxController joystick) {
    this.loaderSubsystem = loaderSubsystem;
    this.joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(loaderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    
    //if (joystick.getRightTriggerAxis()!=0) {
    //  loaderSubsystem.setPower(-1);
    //} else if (joystick.getLeftTriggerAxis()!=0) {
    //  loaderSubsystem.setPower(1);
    //}
    //else {
    //  loaderSubsystem.setPower(0);
    //}

    if (joystick.getRightBumper()) {
      loaderSubsystem.setPower(1);
    } else if (joystick.getLeftBumper()) {
      loaderSubsystem.setPower(-1);
    }
    else {
      loaderSubsystem.setPower(0);
    }

  }

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
