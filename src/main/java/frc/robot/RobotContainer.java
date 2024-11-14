package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PdpSubsystem;
import frc.robot.subsystems.ServoSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final ServoSubsystem m_servoSubsystem = new ServoSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final PdpSubsystem m_pdp = new PdpSubsystem();
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  
    configureBindings();
  }

  private void configureBindings() {
    //Commandes du power distribution :
    m_driverController.y().onTrue(m_pdp.readPDTemp());
    m_driverController.x().onTrue(m_pdp.readPDTotalC());
    m_driverController.b().onTrue(m_pdp.readPDTotalP());
    m_driverController.a().onTrue(m_pdp.readPDTotalE());
    //Commandes servo (hold)
    m_driverController.rightBumper().onTrue(m_servoSubsystem.setServoAngle(180.0));
    m_driverController.rightBumper().onFalse(m_servoSubsystem.setServoAngle(0.0));
    //Commandes servo (positions)
    m_driverController.povLeft().onTrue(m_servoSubsystem.setServoAngle(0.0));
    m_driverController.povUp().onTrue(m_servoSubsystem.setServoAngle(45.0));
    m_driverController.povRight().onTrue(m_servoSubsystem.setServoAngle(90.0));
    m_driverController.povDown().onTrue(m_servoSubsystem.setServoAngle(135.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
