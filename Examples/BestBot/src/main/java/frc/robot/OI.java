/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.OpenClaw;
import frc.robot.commands.CloseClaw;
import frc.robot.commands.ToggleClaw;
import frc.robot.commands.EjectFromClaw;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
   XboxController stick = new XboxController(RobotMap.XboxPort);
   public Button Abutton = new JoystickButton(stick, RobotMap.A_Button);
   public Button Bbutton = new JoystickButton(stick, RobotMap.B_Button);
   public Button Xbutton = new JoystickButton(stick, RobotMap.X_Button);
   public Button Ybutton = new JoystickButton(stick, RobotMap.Y_Button);
   public Button RightBumper = new JoystickButton(stick, RobotMap.RightBumper);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
public OI(){
  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  //button.whenPressed(new ExampleCommand());

  //Configure Claw
  Abutton.whileHeld(new OpenClaw());
  Bbutton.whileHeld(new EjectFromClaw());
  RightBumper.whenPressed(new ToggleClaw());
  Abutton.whenReleased(new CloseClaw());
  Bbutton.whenReleased(new CloseClaw());


  //Configure Elevator
  /*Xbutton.whileHeld(new ElevatorUp());
  Xbutton.whenReleased(new ElevatorStop());
  Ybutton.whileHeld(new ElevatorDown());
  Ybutton.whenReleased(new ElevatorStop());*/

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());
}
  public XboxController GetConch(){
    return stick;
  }
  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
