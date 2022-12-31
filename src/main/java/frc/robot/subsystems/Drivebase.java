// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotContainer;
import frc.robot.Constants.SUBSYSTEM;
import frc.robot.Constants.JOYSTICK;

public class Drivebase extends SubsystemBase {
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(SUBSYSTEM.RIGHT_MASTER);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(SUBSYSTEM.RIGHT_FOLLOW);
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(SUBSYSTEM.LEFT_MASTER);
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(SUBSYSTEM.LEFT_FOLLOW);

  /** Creates a new Drivebase. */
  public Drivebase() {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
  }

  public void drive(double leftdrive, double rightdrive){
    leftMaster.set(leftdrive);
    rightMaster.set(rightdrive);

    leftFollow.setInverted(true);
    rightFollow.setInverted(true);

    rightMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double boost =  RobotContainer.taycam.getRawButton(JOYSTICK.Right_Bumper)? 0.8 : 0.4;
    drive(RobotContainer.taycam.getRawAxis(JOYSTICK.Left_Stick_Y)*boost, RobotContainer.taycam.getRawAxis(JOYSTICK.Right_Stick_Y)*boost);
  }
}
