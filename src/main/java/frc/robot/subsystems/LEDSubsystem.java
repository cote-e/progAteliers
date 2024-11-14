//doesn't work rn

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**adjustable leds*/
public class LEDSubsystem extends SubsystemBase{

    AddressableLED ledStrip = new AddressableLED(6);
    AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(60);

    /**(Rainbow first pixel hue)*/
    int rainbowFPH = 0;
    /**no clue why this exists*/
    double zeroPos = 0;
    private int firstPos = 0;

    public LEDSubsystem() {
        ledStrip.setLength(ledBuffer.getLength());
        ledStrip.setData(ledBuffer);
        ledStrip.start();
    }

    /**rainbow yippee (doesn't fucking work)*/
    private void rainbow() {

        for (var i =0; i < ledBuffer.getLength(); i++) {
            final var hue = (rainbowFPH+ (i * 180 / ledBuffer.getLength())) % 180;
            ledBuffer.setHSV(i, hue, 255, 128);
        }
        rainbowFPH += 5;
        rainbowFPH %= 180;
    }

    private void blue() {
        for (var i = 0; i < ledBuffer.getLength(); i++) {            
            ledBuffer.setRGB(i, 0, 0, 255);
         }

    }

    @Override
        public void periodic() {

            blue();
            // rainbow();
            ledStrip.setData(ledBuffer);
        }
}



