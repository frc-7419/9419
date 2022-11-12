// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunLoader;
import frc.robot.commands.RunShooter;
import frc.robot.commands.StraightWithMotionMagic;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class OneBallAuto extends SequentialCommandGroup {
  /** Creates a new OneBallAuto. */
  public OneBallAuto(DriveBaseSubsystem driveBaseSubsystem, ShooterSubsystem shooterSubsystem, LoaderSubsystem loaderSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(parallel(new RunShooter(shooterSubsystem), new RunLoader(loaderSubsystem,1)).withTimeout(1));
    addCommands(new StraightWithMotionMagic(driveBaseSubsystem, -40));
  }
}
