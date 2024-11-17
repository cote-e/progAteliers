// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
    /**Constants for servo positions*/
  public static class ServoPositions {
    /**0°*/
    public static final int kServoPos0 = 0;
    /**45°*/
    public static final int kServoPos1 = 45;
    /**90°*/
    public static final int kServoPos2 = 90;
    /**135°*/
    public static final int kServoPos3 = 135;
    /**180°*/
    public static final int kServoPos4 = 180;
    /**80°*/
    public static final int kServoPos5 = 80;
    /**100°*/
    public static final int kServoPos6 = 100;
  }
}
