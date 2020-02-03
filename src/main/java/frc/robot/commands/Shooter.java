/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.ShooterSub;

import java.util.Set;
import java.util.HashSet;
public class Shooter implements Command {
  /**
   * Creates a new Shooter.
   */
  @Override
  public Set<Subsystem> getRequirements() {
      // TODO Auto-generated method stub
      Set<Subsystem> s = new HashSet<Subsystem>(){{
          add(Robot.shooter);
      }};
      return s;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Check D");
    if(Robot.oi.joystick.getRawButtonPressed(1)) {
      Robot.shooter.shooterMotor.set(-1);
    }
    if(Robot.oi.joystick.getRawButtonReleased(1)) {
      Robot.shooter.shooterMotor.set(0);
    }
  }
// Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
      return false;
  }

}
