// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunShooter;
import frc.robot.commands.StraightWithMotionMagic;
import frc.robot.commands.StraightMove;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.RunIntakeWithoutJoystick;
import frc.robot.commands.RunLoader;
import frc.robot.subsystems.LoaderSubsystem;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallAuto extends ParallelCommandGroup {
  /** Creates a new TwoBallAuto. */
  public TwoBallAuto(DriveBaseSubsystem driveBaseSubsystem, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem, LoaderSubsystem loaderSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //Robot moves forwar and shoots loaded ball
    
    //below is working commands
    // addCommands(parallel(new RunShooter(shooterSubsystem), new RunLoader(loaderSubsystem,1)).withTimeout(4));
    // addCommands(); 

    addCommands(
      sequence(
        parallel(
          new RunShooter(shooterSubsystem), 
          new RunLoader(loaderSubsystem,1)
          // new RunShooter(shooterSubsystem),
          // new RunLoader(loaderSubsystem, 0.5)
        ).withTimeout(2),
        // new RunLoader(loaderSubsystem, 0.5),
        new StraightMove(driveBaseSubsystem, 0.3).withTimeout(1)
      )
    );
    /*addCommands(parallel().withTimeout(4));
    addCommands(new StraightWithMotionMagic(driveBaseSubsystem, -10).withTimeout(2));*/
  }
}
