package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**Subsystem des servos*/
public class ServoSubsystem extends SubsystemBase {
    /**Moteur servo*/
    private Servo exampleServo = new Servo(2);
    
    public ServoSubsystem() {}

    /**Set l'angle du servo a un double entre 0-180*/
    //si le code du servo marche pas c'est la faute du if/else
    public Command setServoAngle(double angle) {
      return runOnce(
            () -> {
                if (angle > 180 || angle < 0)  {
                    System.err.println("invalid angle");
                }
                else {
                    exampleServo.setAngle(angle);
                }
            });
    }
}   