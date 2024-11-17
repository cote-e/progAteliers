// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ServoSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  public static Command servoAutoCmd(ServoSubsystem subsystem) {
    return Commands.run(() -> new servoAuto(subsystem, 120, 60), subsystem);
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
