package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

//driveTrain Stuff
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
//Commands Used
import frc.robot.commands.ExampleCommand;
//CTRE stuff
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.Encoder;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Motors
  public WPI_TalonSRX LeftBack = new WPI_TalonSRX(RobotMap.LeftBack);
  public WPI_TalonSRX LeftFront = new WPI_TalonSRX(RobotMap.LeftFront);
  public WPI_TalonSRX RightBack = new WPI_TalonSRX(RobotMap.RightBack);
  public WPI_TalonSRX RightFront = new WPI_TalonSRX(RobotMap.RightFront);
  //Grouping
  public SpeedControllerGroup m_Left = new SpeedControllerGroup(LeftFront, LeftBack);
  public SpeedControllerGroup m_Right = new SpeedControllerGroup(RightFront, RightBack);
  //DriveTrain
  public DifferentialDrive m_dDrive;
  //PigeonStuff
  public PigeonIMU pigeonGyro = new PigeonIMU(RobotMap.Pigeon);
  int timeout = 100;
  //Encoders

  public DriveTrain(){
    //Gyro Timeout
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
    pigeonGyro.setYaw(0, timeout);
  }

  @Override 
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ExampleCommand());
  }

  public void drive(XboxController box)
  {
    m_dDrive.arcadeDrive(box.getRawAxis(1), -box.getRawAxis(0));
  }

  public void drive(double speed, double rotation)
  {
    m_dDrive.arcadeDrive(rotation, speed);
  }

  public void ResetPig()
  {
    pigeonGyro.setYaw(0, timeout);
  }
  public double GetRawAngle(){
    double[] temp = new double[3];
    pigeonGyro.getYawPitchRoll(temp);
    return temp[0];
  }
}