/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Shooter extends Command {
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.oi.joystick.getRawButtonPressed(1)) {
      Robot.shooter.shooterMotor.set(-1);
    }
    if(Robot.oi.joystick.getRawButtonReleased(1)) {
      Robot.shooter.shooterMotor.set(0);
    }
  }
// Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.shooter.shooterMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.shooter.shooterMotor.set(0);
  }

}
