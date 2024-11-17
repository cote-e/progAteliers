package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitch extends SubsystemBase {
  private DigitalInput limitSwitch = new DigitalInput(1);
  public LimitSwitch() {}
  @Override
  public void periodic() {
    System.out.println(limitSwitch.get());
  }
}
//please work please work please work