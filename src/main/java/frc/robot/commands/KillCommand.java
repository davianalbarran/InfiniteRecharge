package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class KillCommand extends Command {

    public KillCommand(){
        requires(Robot.drive);
    }

    @Override
    protected void initialize() {
      
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      Robot.drive.robotDrive.arcadeDrive(Robot.oi.joystick.getY()*-1, Robot.oi.joystick.getZ());
      if(Robot.oi.joystick.getRawButton(12)){
        Robot.drive.robotDrive.arcadeDrive(0, 0);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }


}
