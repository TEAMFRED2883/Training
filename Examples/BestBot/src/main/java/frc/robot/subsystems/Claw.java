package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Motors
  final WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.IntakeLeft);
  final WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.IntakeRight);
  //Pnuematics
  final DoubleSolenoid horizontal = new DoubleSolenoid(RobotMap.In, RobotMap.Out);
  final DoubleSolenoid vertical = new DoubleSolenoid(RobotMap.Up, RobotMap.Down);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public Claw(){
    horizontal.set(Value.kForward);
  }

  /**Tips the intake up if true, down if false */
  public void Tip(boolean Up){
    if(Up)
        vertical.set(Value.kForward);
    else
        vertical.set(Value.kReverse);
  }
  /**Opens the intake if true, closes if false */
  public void InOut(boolean Out){
    if(Out)
        horizontal.set(Value.kReverse);
    else
        horizontal.set(Value.kForward);
  }

  /**Sets the motor speed */
  public void SetMotor(double speed){
    rightMotor.set(speed);
    leftMotor.set(speed);
  }

}