package frc.robot.commands;

import java.util.Set;
import java.util.HashSet;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.*;

public class DriveCommand implements Command {

    private static boolean isKilled;
    private IntakeCommand intake;

    @Override
    public Set<Subsystem> getRequirements() {
        // TODO Auto-generated method stub
        Set<Subsystem> s = new HashSet<Subsystem>(){{
            add(new Drive());
        }};
        return s;
    }
    @Override
    public void initialize() {
        isKilled = false;
        intake = new IntakeCommand();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        isKilled = Robot.oi.joystick.getRawButton(12);
        if(isKilled){
            Robot.drive.robotDrive.arcadeDrive(0, 0);
        }
        else {
            Robot.drive.robotDrive.arcadeDrive(Robot.oi.joystick.getY()*-1, Robot.oi.joystick.getZ());
        }
    }
  

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    public void end() {
        Robot.drive.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run

    protected void interrupted() {
        Robot.drive.robotDrive.arcadeDrive(0, 0);
    }

    public static boolean isKilled() {
        return isKilled;
    }
}