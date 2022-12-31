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
    public static final class SUBSYSTEM {
        public static final int RIGHT_MASTER =  1;
        public static final int RIGHT_FOLLOW =  2;
        public static final int LEFT_MASTER =   3;
        public static final int LEFT_FOLLOW =   4;

        public static final int INTAKE_BAR_MOTOR =  5;
        public static final int LEFT_RAIL_MOTOR =   6;
        public static final int RIGHT_RAIL_MOTOR =  7;
    }

    public static final class JOYSTICK {
        public static final int Left_Stick_X =  0;
        public static final int Left_Stick_Y =  1;
        public static final int Right_Stick_X = 4;
        public static final int Right_Stick_Y = 5;
        public static final int Left_Trigger =  2;
        public static final int Right_Trigger = 3;

        public static final int Button_A =      1;
        public static final int Button_B =      2;
        public static final int Button_X =      3;
        public static final int Button_Y =      4;
        public static final int Left_Bumper =   5;
        public static final int Right_Bumper =  6;
        public static final int Back =          7;
        public static final int Start =         8;
        public static final int Left_Stick =    9;
        public static final int Right_Stick =  10;
    }
}
