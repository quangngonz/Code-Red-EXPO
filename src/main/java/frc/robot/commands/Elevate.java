// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class Elevate extends CommandBase {
  private final Elevator m_elevator;
  private double m_BarSpeed, m_RailSpeed;
  /** Creates a new Elevate. */
  public Elevate(Elevator elevator, double BarSpeed, double RailSpeed) {
    m_elevator = elevator;
    m_BarSpeed = BarSpeed;
    m_RailSpeed = RailSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevator.suck(m_BarSpeed, m_RailSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.suck(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
