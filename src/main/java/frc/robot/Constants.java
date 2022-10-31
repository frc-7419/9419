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
    public static final double g = 9.81;
    public static final double pi = 3.14159;
    public static enum CanIds {
        leftmast(2),
        rightmast(4),
        leftfollow(3),
        rightfollow(5),
        hangar(69), //placeholder
        loader(12),
        shoter(62);
        public final int id;
        private CanIds(int id) {
            this.id = id;
        }
    }
    public static class PIDConstants {
        //drive
        public static final double DriveBaseMotionMagickP = 0.5;
        public static final double DriveBaseMotionMagickI = 0;
        public static final double DriveBaseMotionMagickD = 0;

        // turn with gyro gains:
        public static final double GyrokP = 0.0085;
        public static final double GyrokI = 0.00;
        public static final double GyrokD = 0.0001;

    }
}
