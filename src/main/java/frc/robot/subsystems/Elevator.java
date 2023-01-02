// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.SUBSYSTEM;

public class Elevator extends SubsystemBase {
  public WPI_VictorSPX intakeBarMotor = new WPI_VictorSPX(SUBSYSTEM.INTAKE_BAR_MOTOR);
  public WPI_TalonFX leftRailMotor = new WPI_TalonFX(SUBSYSTEM.LEFT_RAIL_MOTOR);
  public WPI_TalonSRX rightRailMotor = new WPI_TalonSRX(SUBSYSTEM.RIGHT_RAIL_MOTOR);

  /** Creates a new Elevator. */
  public Elevator() {
    rightRailMotor.setInverted(true);
    intakeBarMotor.setInverted(true);
    
    intakeBarMotor.setNeutralMode(NeutralMode.Brake);
    leftRailMotor.setNeutralMode(NeutralMode.Brake);
    rightRailMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void suck(double BarSpeed, double RailSpeed) {
    intakeBarMotor.set(BarSpeed);
    leftRailMotor.set(RailSpeed*0.5);
    rightRailMotor.set(RailSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
