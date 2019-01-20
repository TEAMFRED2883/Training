package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.TurnWithGyro;

/**
 * Toggles the Claw up or Down
 */
public class SimpleAuto extends CommandGroup {

  public SimpleAuto() {
    // Use requires() here to declare subsystem dependencies
    addSequential(new Drive(.5, .50), 2);
    //addSequential(new TurnWithGyro(.25, 90.0));
  }
}