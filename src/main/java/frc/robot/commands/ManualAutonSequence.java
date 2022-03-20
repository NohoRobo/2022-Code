// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.ShooterWheel;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Indexer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ManualAutonSequence extends SequentialCommandGroup {
  // drop intake
  // turn towards 2nd ball
  // drive
  // intake
  // move indexer
  // turn towards goal
  // drive
  // aim 
  // rev flywheel
  // shoot
  // rev flywheel 
  // shoot
  // drive off tarmac

  private Drive drive = Drive.getInstance();
  /** Creates a new ManualAutonSequence. */
  public ManualAutonSequence(IntakeMotor intakeMotor, Indexer indexer, ShooterWheel shooterWheel, Limelight limelight, Turret turret) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    // this is a generic idea
    addCommands(
      new InstantCommand(shooterWheel::run, shooterWheel),
      new WaitCommand(1.5),
      new InstantCommand(shooterWheel::run, shooterWheel),
      new InstantCommand(indexer::run, indexer),
      new WaitCommand(1.5),
      // it has shot
      new InstantCommand(shooterWheel::stop, shooterWheel),
      new InstantCommand(indexer::stop, indexer),
      new DriveNormal(-0.2, 0.2),
      new WaitCommand(2.5),
      new DriveNormal(0, 0),
      new DriveNormal()
    );
  }
}
