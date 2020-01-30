/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ChuteCommand extends Command {
  private boolean isFrontPressed;
  private boolean isBackPressed;

  public ChuteCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chute);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.chute.chuteMotor.set(0);
    isFrontPressed = false;
    isBackPressed = false;

    System.out.println("Chute Initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    isFrontPressed = Robot.oi.joystick.getRawButtonReleased(10);
    isBackPressed = Robot.oi.joystick.getRawButton(9);
    if(isBackPressed) {
      Robot.chute.chuteMotor.set(-.3);
    }
    else {
      Robot.chute.chuteMotor.set(0);
    }

    if(isFrontPressed) {
      Robot.chute.chuteMotor.set(.3);
    }
    else {
      Robot.chute.chuteMotor.set(0);
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
    Robot.chute.chuteMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.chute.chuteMotor.set(0);
  }
}
