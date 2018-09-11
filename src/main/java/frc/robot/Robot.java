/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.driveSystem.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
  private final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(new Spark(0), new Spark(1));
  private final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(new Spark(2), new Spark(3));
  private final DifferentialDrive driveTrain = new DifferentialDrive(leftDriveTrain, rightDriveTrain);
  private final Spark lift = new Spark(4);
  private final Spark intake = new Spark(5);
  private final Joystick leftStick = new Joystick(0);
  private final Joystick rightStick = new Joystick(1);
  private final XboxController xboxController = new XboxController(2);
  private final Timer m_timer = new Timer();
  private final ControlSet controlSet = new ControlSet(leftStick, rightStick, xboxController);

  private ArcadeDriver currentDriverArcade;
  private TankDriver currentDriverTank;
  private Operator currentOperator;

  private String driveType;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    String driver = "One";
    switch(driver) {
      case "One":
        currentDriverArcade = new OneDriver(controlSet);
        driveType = "Arcade";
        break;
      case "Two":
        currentDriverArcade = new TwoDriver(controlSet);
        driveType = "Arcade";
        break;
      case "Three":
        currentDriverTank = new ThreeDriver(controlSet);
        driveType = "Tank";
        break;
    }
    String operator = "Two";
    switch(operator) {
      case "One":
        break;
      case "Two":
        break;
    }
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      driveTrain.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      driveTrain.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    switch(driveType) {
      case "Arcade":
        driveTrain.arcadeDrive(currentDriverArcade.getSpeed(), currentDriverArcade.getRotation(), currentDriverArcade.getUseSquares());
        break;
      case "Tank":
        driveTrain.tankDrive(currentDriverTank.getLeftSpeed(), currentDriverTank.getRightSpeed(), currentDriverTank.getUseSquares());
        break;
    }
    processOperator();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void processOperator() {
    lift.setSpeed(currentOperator.getLiftSpeed());
    intake.setSpeed(currentOperator.getIntakeSpeed());
  }
}
