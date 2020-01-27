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
        isKilled = false;
        Robot.drive.robotDrive.arcadeDrive(Robot.oi.joystick.getY()*-1, Robot.oi.joystick.getZ());
        while(Robot.oi.joystick.getRawButton(12)){
            isKilled = true;
            Robot.drive.robotDrive.arcadeDrive(0, 0);
            intake.start();
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

    public static boolean isKilled() {
        return isKilled;
    }
}