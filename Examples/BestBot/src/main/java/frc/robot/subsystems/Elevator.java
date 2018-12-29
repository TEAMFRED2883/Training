
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorTriggerControl;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    //Motors
    final WPI_TalonSRX ElevatorMotor_1 = new WPI_TalonSRX(RobotMap.Motor1);
    final WPI_TalonSRX ElevatorMotor_2 = new WPI_TalonSRX(RobotMap.Motor2);
    //Inputs
    DigitalInput topSwitch = new DigitalInput(RobotMap.TopSwitch);
    DigitalInput botSwitch = new DigitalInput(RobotMap.BotSwitch);
    //Pnuematics
    final Solenoid Break = new Solenoid(RobotMap.Break);
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorTriggerControl());
  }

  /**Moves the Elevator according to an Xbox controller's
   * trigger input. Left trigger controls downward, right trigger
   * controls upward.
  */
  public void ElevatorControl(XboxController box)
  {
      if(botSwitch.get() && box.getRawAxis(2) != 0){
        Break.set(false);
        ElevatorMotor_1.set(-box.getRawAxis(2));
        ElevatorMotor_2.set(-box.getRawAxis(2));
      }
      else if(topSwitch.get() && box.getRawAxis(3) != 0)
      {
        Break.set(false);
        ElevatorMotor_1.set(box.getRawAxis(3));
        ElevatorMotor_2.set(box.getRawAxis(3));
      }
      else{
        ElevatorMotor_1.set(0);
        ElevatorMotor_2.set(0);
        Break.set(true);
      }
  }

  public void ElevatorControl(double speed)
  {
    if(botSwitch.get() && speed < 0){
      Break.set(false);
      ElevatorMotor_1.set(speed);
      ElevatorMotor_2.set(speed);
    }
    else if(topSwitch.get() && speed > 0)
    {
      Break.set(false);
      ElevatorMotor_1.set(speed);
      ElevatorMotor_2.set(speed);
    }
    else
      Break();
    
  }

  public void Break()
  {
    Break.set(true);
    ElevatorMotor_1.set(0);
    ElevatorMotor_2.set(0);
  }
}