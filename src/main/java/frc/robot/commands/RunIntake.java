// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase {
  /** Creates a new RunIntake. */
  private IntakeSubsystem intakeSubsystem;
  private XboxController joystick;
  private double speed = 1.0;
  public RunIntake(IntakeSubsystem intakeSubsystem, XboxController joystick) {
    this.intakeSubsystem = intakeSubsystem;
    this.joystick = joystick;
    addRequirements(intakeSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if(joystick.getXButton()){
    //  intakeSubsystem.setSpeed(-speed);
    //} else if (joystick.getBButton()) {
    //  intakeSubsystem.setSpeed(speed);
    //}
    
    if (joystick.getRightTriggerAxis() != 0){
      intakeSubsystem.setSpeed(-speed);
    } else if (joystick.getLeftTriggerAxis() != 0){
      intakeSubsystem.setSpeed(speed);
    }
    else {
      intakeSubsystem.setSpeed(0);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
  // Vince is an NFT
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
