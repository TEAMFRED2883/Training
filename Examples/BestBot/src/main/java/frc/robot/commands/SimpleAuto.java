package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Toggles the Claw up or Down
 */
public class SimpleAuto extends CommandGroup {

  public SimpleAuto() {
    // Use requires() here to declare subsystem dependencies
    addSequential(new Drive(.25, 0), 2);
  }
}