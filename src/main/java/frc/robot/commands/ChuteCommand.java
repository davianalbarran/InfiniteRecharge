/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import java.util.Set;
import java.util.HashSet;

public class ChuteCommand implements Command {

  @Override
  public Set<Subsystem> getRequirements() {
      // TODO Auto-generated method stub
      Set<Subsystem> s = new HashSet<Subsystem>(){{
        add(Robot.chute);
      }};
      return s;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.chute.chuteMotor.set(0);
    System.out.println("Chute Initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    System.out.println("Check E");
    if(Robot.oi.joystick.getRawButtonPressed(5)) {
      Robot.chute.chuteMotor.set(.5);
    }
    if(Robot.oi.joystick.getRawButtonPressed(3)) {
      Robot.chute.chuteMotor.set(-.5);
    }
    if(Robot.oi.joystick.getRawButtonReleased(5) || Robot.oi.joystick.getRawButtonReleased(3)) {
    Robot.chute.chuteMotor.set(0);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}