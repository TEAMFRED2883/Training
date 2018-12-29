package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Toggles the Claw up or Down
 */
public class ToggleClaw extends Command {
  boolean IsUp = false;
  boolean done = false;
  public ToggleClaw() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  @Override
  public void start() {
    done = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(IsUp){
      Robot.m_claw.Tip(false);
    }
    else{
      Robot.m_claw.Tip(true);
    }
    IsUp = !IsUp;
    done = true;
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}