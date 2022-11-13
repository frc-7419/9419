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
        leftmast(5),
        rightmast(2),
        leftfollow(4),
        rightfollow(3),
        hangar(12),
        intake(40),
        loader(53), 
        shooter(62),
        beambreak(1);
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

         //shooter, meters
         public static final double TopShooterkP = .0014651; //insert here
         public static final double TopShooterkI = 0;
         public static final double TopShooterkD = 0;

    }

    //for shooter
    public static class RobotConstants {
        public static final double TalonFXTicksPerRotation = 2048;

        public static final double BottomShooterWheelRadius = 0.0508; // meters
        public static final double TopShooterWheelRadius = 0.0508;

        public static final double RotationsPerMeter = 1/(2*Math.PI*0.0508);

        // top shooter kS, kV, kA
        public static final double TopShooterKs = 0.56452;
        public static final double TopShooterKv = 0.11144;
        public static final double TopShooterKa = 0.026061;

        // bottom shooter kS, kV, kA, meters
        public static final double BottomShooterKs = 0.67661;
        public static final double BottomShooterKv = 0.10994;
        public static final double BottomShooterKa = 0.0060832;;

        public static final double trackWidth = 0.69; // meters
    }
    public static class LimelightConstants {
        public static final double kTargetHeight = 2.6416;//meters
        public static final double mountingAngle = 50; //degrees
        public static final double kCameraHeight = 1.02235; //meters 
    }
    public static final Double[][] kDistanceToShooterVelocity = {//7419 values
        {0.738, 19.5},
        // {1.03, 31.5},
        {1.098, 19.5},
        {1.3, 26.0},
        {1.5, 25.0},
        {1.92, 28.5},
        {2.3, 30.0},
        {2.5, 34.6},
        {2.7, 36.5},
        {2.9, 38.0},
    };

    public static final Double[][] kRawVelocityToFf = {//7419 values
        {1000.0, 0.06365},
        {1500.0, 0.058615},
        {2000.0, 0.0555},
        {2500.0, 0.0535},
        {3000.0, 0.0525},
        {3500.0, 0.0506},
        {4000.0, 0.0495},
        {4500.0, 0.049425},
        {5000.0, 0.0488},
        {5500.0, 0.0491},
        {6000.0, 0.048305},
        {6500.0, 0.048305},
        {7000.0, 0.0486},
        {7500.0, 0.048875},
        {8000.0, 0.04874},
        {8500.0, 0.04876},
        {9000.0, 0.048},
        {10000.0, 0.04785},
        {10500.0, 0.04775},
        {11000.0, 0.04775},
        {12000.0, 0.049},
        {12500.0, 0.0491},
        {13000.0, 0.0484},
        {13500.0, 0.0525},
        {14000.0, 0.0545}
    };
}
