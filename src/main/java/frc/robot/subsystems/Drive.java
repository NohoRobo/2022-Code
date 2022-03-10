// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.*;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */

  //Consider changing this so variables are created but only assigned in constructor
  // Mitchell: done this
  private CANSparkMax LF;
  private CANSparkMax LM;
  private CANSparkMax LB;

  private CANSparkMax RF;
  private CANSparkMax RM;
  private CANSparkMax RB;

  /* HOW DO YOU MAKE ENCODERS WITH 2022 REV/WPILIB?
  RelativeEncoder leftFrontEncoder = new RelativeEncoder(LF);
  RelativeEncoder leftMiddleEncoder = new RelativeEncoder(LM);
  RelativeEncoder leftBackEncoder = new RelativeEncoder(LB);
  RelativeEncoder rightFrontEncoder = new RelativeEncoder(RF);
  RelativeEncoder rightMiddleEncoder = new RelativeEncoder(RM);
  RelativeEncoder rightBackEncoder = new RelativeEncoder(RB);
  */

  public Drive() {
    LF = new CANSparkMax(Constants.LFWheel, MotorType.kBrushless);
    LM = new CANSparkMax(Constants.LMWheel, MotorType.kBrushless);
    LB = new CANSparkMax(Constants.LBWheel, MotorType.kBrushless);
    RF = new CANSparkMax(Constants.RFWheel, MotorType.kBrushless);
    RM = new CANSparkMax(Constants.RMWheel, MotorType.kBrushless);
    RB = new CANSparkMax(Constants.RBWheel, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDriveL(double speed){
    LF.set(speed);
    LM.set(speed);
    LB.set(speed);
  }
  public void setDriveR(double speed){
    RF.set(speed);
    RM.set(speed);
    RB.set(speed);
  }
  public void setDrive(double leftSpeed, double rightSpeed){
    setDriveL(leftSpeed);
    setDriveR(rightSpeed);
  }

  public void driveBrake(){
    LF.setIdleMode(IdleMode.kBrake);
    LM.setIdleMode(IdleMode.kBrake);
    LB.setIdleMode(IdleMode.kBrake);
    RF.setIdleMode(IdleMode.kBrake);
    RM.setIdleMode(IdleMode.kBrake);
    RB.setIdleMode(IdleMode.kBrake);
  }

  public void driveCoast(){
    LF.setIdleMode(IdleMode.kCoast);
    LM.setIdleMode(IdleMode.kCoast);
    LB.setIdleMode(IdleMode.kCoast);
    RF.setIdleMode(IdleMode.kCoast);
    RM.setIdleMode(IdleMode.kCoast);
    RB.setIdleMode(IdleMode.kCoast);
  }

  public void driveStop(){
    LF.stopMotor();
    LM.stopMotor();
    LB.stopMotor();
    RF.stopMotor();
    RM.stopMotor();
    RB.stopMotor();
  }
}
