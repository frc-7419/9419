package frc.robot.commands;

import com.team7419.InterpolatedTreeMap;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RunShooterWithLimelight extends CommandBase {

  private ShooterSubsystem shooterSubsystem;
  private LimelightSubsystem limelightSubsystem;

  private InterpolatedTreeMap shooterReferencePoints;

  private double kp = 0;

  private double targetVelocity;

  public RunShooterWithLimelight(ShooterSubsystem shooterSubsystem, LimelightSubsystem limelightSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(shooterSubsystem);

    shooterReferencePoints = new InterpolatedTreeMap();

    // config reference points from constants file
    shooterSubsystem.configInterpolatedTreeMapReferencePoints(Constants.kDistanceToShooterVelocity, shooterReferencePoints);
  }

  @Override
  public void initialize() {
    targetVelocity = shooterReferencePoints.get(limelightSubsystem.getDistance()).doubleValue();

    shooterSubsystem.setPIDF(kp, 0, 0, 0);

    shooterSubsystem.setClosedLoopVelocity(targetVelocity);
  }

  @Override
  public void execute() {
    targetVelocity = shooterReferencePoints.get(limelightSubsystem.getDistance()).doubleValue();

    shooterSubsystem.setPIDF(kp, 0, 0 , 0);
    shooterSubsystem.setClosedLoopVelocity(targetVelocity);
  
    // SmartDashboard.putBoolean("Top On Target", shooterSubsystem.topOnTarget());
    // SmartDashboard.putBoolean("Bottom on Target", shooterSubsystem.bottomOnTarget());
    // SmartDashboard.putBoolean("Both on Target", shooterSubsystem.bothOnTarget());
  }

  @Override
  public void end(boolean interrupted) {
    // SmartDashboard.putBoolean("Shooter Running", false);
    shooterSubsystem.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
