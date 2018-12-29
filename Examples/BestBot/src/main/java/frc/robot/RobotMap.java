/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.XboxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Joysticks
  public static int XboxPort = 0;
  public static int A_Button = 1;
  public static int B_Button = 2;
  public static int X_Button = 3;
  public static int Y_Button = 4;
  public static int RightBumper = 6;
  //drivetrain
  public static int LeftBack = 12;
  public static int RightBack = 15;
  public static int RightFront = 17;
  public static int LeftFront = 13;
  //Elevator DIO's
  public static int BotSwitch = 7;
  public static int TopSwitch = 8;
  //Elevator Motors
  public static int Motor1 = 10;
  public static int Motor2 = 11;
  //Elevator Pnuematics
  public static int Break = 4;
  //Claw Motors
  public static int IntakeRight = 14;
  public static int IntakeLeft = 16;
  //Claw Pnuematics
  public static int In = 0;
  public static int Out = 1;
  public static int Up = 2;
  public static int Down = 3;


  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;


  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
