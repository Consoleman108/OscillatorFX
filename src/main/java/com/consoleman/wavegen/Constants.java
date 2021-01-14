package com.consoleman.wavegen;

public class Constants {
    final static public int SAMPLING_RATE = 44100;
    final static public int SAMPLE_SIZE_IN_BITS = 16;
    final static public int CHANNELS = 1;
    final static public boolean SIGNED = true;
    final static public boolean BIG_ENDIAN = true;

    final static public int SAMPLE_SIZE = 2;                 //Sample size in bytes
    final static public double BUFFER_DURATION = 0.100;      //About a 100ms buffer
    final static public int SINE_PACKET_SIZE = (int)(BUFFER_DURATION * SAMPLING_RATE * SAMPLE_SIZE);
    public static final int BUFFER_LENGTH = 4096;
    public static final int SEC = 10;
    public static final int SAMPLE_RATE = 44100;
    public static final int FREQ = 440;
    public static final int SAMPLE_TIME =  SAMPLE_RATE / FREQ / 2;
    public static final int WAVE_PERIOD = SAMPLE_RATE / FREQ;

    final static public double A0  =    27.5000;
    final static public double Bb0 =    29.1353;
    final static public double B0  =    30.8677;
    final static public double C1  =    32.7032;
    final static public double Db1 =    34.6479;
    final static public double D1  =    36.7081;
    final static public double Eb1 =	38.8909;
    final static public double E1  =    41.2035;
    final static public double F1  =    43.6536;
    final static public double Gb1 =    46.2; //46.2493;
    final static public double G1  =    48.9995;
    final static public double Ab1 =    51.9130;
    final static public double A1  =    55.0000;
    final static public double Bb1 =    58.2706;
    final static public double B1  =    61.7354;
    final static public double C2  =    65.4064;
    final static public double A2  =    110.0000;
    final static public double Bb2 =    116.5412;

}
