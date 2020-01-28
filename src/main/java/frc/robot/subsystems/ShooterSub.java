/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.Shooter;

public class ShooterSub extends Subsystem {
  /**
   * Creates a new ShooterSub.
   */

  public CANSparkMax shooterMotor;

  public ShooterSub() {
    shooterMotor = new CANSparkMax(7, MotorType.kBrushless);
  }

  @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Shooter());
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
