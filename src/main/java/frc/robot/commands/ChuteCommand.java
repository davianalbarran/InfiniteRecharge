/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.Chute;
import java.util.Set;
import java.util.HashSet;

public class ChuteCommand implements Command {
  private boolean isFrontPressed;
  private boolean isBackPressed;

  @Override
  public Set<Subsystem> getRequirements() {
      // TODO Auto-generated method stub
      Set<Subsystem> s = new HashSet<Subsystem>(){{
          add(new Chute());
      }};
      return s;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.chute.chuteMotor.set(0);
    isFrontPressed = false;
    isBackPressed = false;

    System.out.println("Chute Initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
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
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true

  public void end() {
    Robot.chute.chuteMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
 
  protected void interrupted() {
    Robot.chute.chuteMotor.set(0);
  }
}