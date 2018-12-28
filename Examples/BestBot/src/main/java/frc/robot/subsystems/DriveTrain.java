package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

//driveTrain Stuff
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SpeedController;
//Commands Used
import frc.robot.commands.ExampleCommand;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Motors
  public SpeedController LeftBack = new WPI_TalonSRX(RobotMap.LeftBack);
  public SpeedController LeftFront = new WPI_TalonSRX(RobotMap.LeftFront);
  public SpeedController RightBack = new WPI_TalonSRX(RobotMap.RightBack);
  public SpeedController RightFront = new WPI_TalonSRX(RobotMap.RightFront);
  //Grouping
  public SpeedControllerGroup m_Left = new SpeedControllerGroup(LeftFront, LeftBack);
  public SpeedControllerGroup m_Right = new SpeedControllerGroup(RightFront, RightBack);
  //DriveTrain
  public DifferentialDrive m_dDrive;

  public DriveTrain(){
    //SmartDashboard Stuff
    addChild("FrontLeft", (WPI_TalonSRX) LeftFront);
    addChild("FrontRight", (WPI_TalonSRX) RightFront);
    addChild("BackLeft", (WPI_TalonSRX) LeftBack);
    addChild("BackRight", (WPI_TalonSRX) RightBack);
    //initialize Drive Train
    m_dDrive = new DifferentialDrive(m_Left, m_Right);
    m_Left.setInverted(true); //Neccessary to keep from grinding our gears
    m_dDrive.setSafetyEnabled(true); //Always be safe!
    m_dDrive.setExpiration(0.1);//updatetimer
    m_dDrive.setMaxOutput(1.0);//setting max power
  }

  @Override 
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ExampleCommand());
  }

  public void DriveWithXbox(XboxController box)
  {
      m_dDrive.tankDrive(box.getX(), box.getY());
  }
}