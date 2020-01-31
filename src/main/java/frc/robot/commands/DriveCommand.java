package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {

    private static boolean isKilled;
    private IntakeCommand intake;

    public DriveCommand(){
        requires(Robot.drive);
    }

    @Override
    protected void initialize() {
        isKilled = false;
        intake = new IntakeCommand();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        isKilled = Robot.oi.joystick.getRawButton(12);
        if(isKilled){
            Robot.drive.robotDrive.arcadeDrive(0, 0);
        }
        else {
            Robot.drive.robotDrive.arcadeDrive(Robot.oi.joystick.getY()*-1, Robot.oi.joystick.getZ());
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
        Robot.drive.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.drive.robotDrive.arcadeDrive(0, 0);
    }

    public static boolean isKilled() {
        return isKilled;
    }
}