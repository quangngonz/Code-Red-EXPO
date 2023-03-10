// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.Drive;
import frc.robot.commands.Elevate;
import frc.robot.Constants.JOYSTICK;

import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Joystick taycam = new Joystick(0);
  private final Drivebase drivebase = new Drivebase();
  private final Elevator elevator = new Elevator();

  // Nhớ sủa hết speed mấy cái này!!!!
  private final Drive drive = new Drive(drivebase, 0, 0);
  private final Elevate elevateUp = new Elevate(elevator, 0.8, 0.8);
  private final Elevate elevateDown = new Elevate(elevator, -0.8, -0.8);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(taycam, JOYSTICK.Button_Y).whileActiveOnce(elevateUp);
    new JoystickButton(taycam, JOYSTICK.Button_A).whileActiveOnce(elevateDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return drive;
  }
}
