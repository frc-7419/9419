// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.RunHangar;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunLoaderWithJoystick;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunShooterWithJoystick;
import frc.robot.commands.TurnToTargetClosedLoop;
import frc.robot.commands.autos.TwoBallAuto;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.HangarSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final HangarSubsystem hangarSubsystem = new HangarSubsystem();
  private final LoaderSubsystem loaderSubsystem = new LoaderSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();

  private final XboxController joystick1 = new XboxController(0);
  private final XboxController joystick2 = new XboxController(1);
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveBaseSubsystem, joystick1);
  private final TurnToTargetClosedLoop turnToTargetClosedLoop = new TurnToTargetClosedLoop(driveBaseSubsystem, limelightSubsystem);
  private final RunIntake runIntake = new RunIntake(intakeSubsystem, joystick1);
  // private final RunShooter runShooter = new RunShooter(shooterSubsystem);
  private final RunShooterWithJoystick runShooterWithJoystick = new RunShooterWithJoystick(shooterSubsystem, joystick2);
  private final RunLoaderWithJoystick runLoaderWithJoystick = new RunLoaderWithJoystick(loaderSubsystem, joystick2);
  private final RunHangar runHangar = new RunHangar(hangarSubsystem, joystick1);
  private final TwoBallAuto twoBallAuto = new TwoBallAuto(driveBaseSubsystem, shooterSubsystem, intakeSubsystem, loaderSubsystem);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    setDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new JoystickButton(joystick1, XboxController.Button.kA.value).whileHeld(runShooter);
    new JoystickButton(joystick2, XboxController.Button.kB.value)
      .whileHeld(turnToTargetClosedLoop);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return twoBallAuto;
  }

  public void setDefaultCommands() {
    driveBaseSubsystem.setDefaultCommand(arcadeDrive);
    intakeSubsystem.setDefaultCommand(runIntake);
    shooterSubsystem.setDefaultCommand(runShooterWithJoystick);
    loaderSubsystem.setDefaultCommand(runLoaderWithJoystick);
    hangarSubsystem.setDefaultCommand(runHangar);
    // limelightSubsystem.setDefaultCommand(turnToTargetClosedLoop);
  }
}
