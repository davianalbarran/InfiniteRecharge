/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ChuteCommand;

/**
 * Add your docs here.
 */
public class Chute extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CANSparkMax chuteMotor;
  public CANEncoder chuteEncoder;
  public CANPIDController chutePID;

  public Chute() {
    chuteMotor = new CANSparkMax(6, MotorType.kBrushless);
    chuteEncoder = chuteMotor.getEncoder();
    chutePID = chuteMotor.getPIDController();
    chuteMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ChuteCommand());
  }
}
