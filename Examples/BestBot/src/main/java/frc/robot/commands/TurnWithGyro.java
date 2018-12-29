package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TurnWithGyro extends Command {
    double driveAngle = 0;
    double rotationSpeed = 0;
    boolean done = false;
  public TurnWithGyro(double speed, double angle) {
    // Use requires() here to declare subsystem dependencies
    driveAngle = angle;
    if(angle < 0)
        rotationSpeed = -speed;
    else
        rotationSpeed = speed;
        
    requires(Robot.m_driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      Robot.m_driveTrain.ResetPig();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_driveTrain.drive(0, rotationSpeed);
    if(Robot.m_driveTrain.GetRawAngle() > driveAngle && driveAngle > 0)
    {
        done = true;
    }
    else if (Robot.m_driveTrain.GetRawAngle() < driveAngle && driveAngle < 0)
    {
        done = true;
    }
    isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.m_driveTrain.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}