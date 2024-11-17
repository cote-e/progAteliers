// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ServoSubsystem;

/**Auto sequence for the servos (hopefully doesn't explode anything)*/
public class servoAuto extends Command {
  private ServoSubsystem m_servo = new ServoSubsystem();
  private DigitalInput m_limit = new DigitalInput(1);
  private boolean limitPresssed = m_limit.get();
  /**Angle when limit switch is pressed*/
  double SwitchAngle;
  /**Maximum angle in the cycle*/
  double MaxAngle;
  /**Current angle in the cycle*/
  double CycleAngle;
  /**If the angle is going up or not in the cycle*/
  boolean degUp;
  /** Auto mode sequence for the servos. 
   * See {@link frc.robot.Constants.OperatorConstants Constants} for servo positions
   * @param servo Servo Subsystem
   * @param Max Max degrees for the servo cycle
   * @param Switch Degrees to set the servo to when the limit switch is pressed
  */
  public servoAuto(ServoSubsystem servo, double Max, double Switch) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_servo = servo;
    Max %= 180;
    MaxAngle = Max;
    SwitchAngle = Switch;
    addRequirements(servo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_servo.setServoAngle(0);
    CycleAngle=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //I hope you like italian food because this code is complete spaghetti.
    limitPresssed = m_limit.get();
    
    if (limitPresssed == true) {
      //Set servo to limit switch angle
      m_servo.setServoAngle(SwitchAngle);
      CycleAngle = SwitchAngle;
    }
    else {
      //check if angle is going up or down
      if (degUp == true){
        //If else in an if else in an if else
        //Check if the angle + 1 is over the max or not
        if ((CycleAngle + 1)>= MaxAngle) {
          //Time to go down >:)
          degUp = false;
        } 
        else {
          // go up
          CycleAngle += 1;
          m_servo.setServoAngle(CycleAngle);
        }
      }
      else {
        //Angle going down
        //Check if the angle -1 is lower than 0 or not
        if ((CycleAngle - 1) <= 0) {
          //Time to go up :D
          degUp = true;
        } else {
          CycleAngle-= 1;
          m_servo.setServoAngle(CycleAngle);
        }
      }
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
