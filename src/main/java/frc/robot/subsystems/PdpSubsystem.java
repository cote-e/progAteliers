package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** mon code youpi */
public class PdpSubsystem extends SubsystemBase{
  private final PowerDistribution m_pdp = new PowerDistribution();
  /** temperature du pdp en celsius */
  public Command readPDTemp() {
    return runOnce(
      () -> {
        double pdTempC = m_pdp.getTemperature();
        System.out.println(pdTempC + " Celsius");
      }
    );  
  }
  /** "total current" (aucune idee ca veut dire quoi) */
  public Command readPDTotalC() {
    return runOnce(  () -> {
        double pdTotalC = m_pdp.getTotalCurrent();
        System.out.println(pdTotalC + " Total current");
      }
    );  
  }
  /** total power (???) */
  public Command readPDTotalP() {
    return runOnce(  () -> {
        double pdTotalP = m_pdp.getTotalPower();
        System.out.println(pdTotalP + " Total power");
      }
    );  
  }
  /** total energy (huh??) */
  public Command readPDTotalE() {
    return runOnce(  () -> {
        double pdTotalE = m_pdp.getTotalEnergy();
        System.out.println(pdTotalE + " Total energy");
      }
    );  
  }
} 
//yippee