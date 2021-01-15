package com.consoleman.wavegen;

import java.util.Random;

public class Waves {

    public static short Sin(double cyclePosition, double volume) {
//        return (short)(Short.MAX_VALUE * Math.sin(2 * Math.PI * cyclePosition));
        return (short) (volume * Math.sin(2 * Math.PI * cyclePosition));
    }

    public static short Triangle(double cyclePosition) {
        return (short) ( ( (2 * Short.MAX_VALUE)/Math.PI ) * Math.asin( Math.sin( 2 * Math.PI * cyclePosition)));
    }

    public static short Saw(double cyclePosition) {
        return ( (short) ( ((2 * Short.MAX_VALUE)/Math.PI ) * Math.atan(-1 * Math.tan(Math.PI * cyclePosition) + Math.PI/2) ) );
    }

    public static short Noise() {
        Random random = new Random();
        return (short) (Short.MAX_VALUE * random.nextGaussian());
    }
    static void printInfo (int frequency) {
        System.out.println("Sampling Frequency  : " + Constants.SAMPLE_RATE);
        System.out.println("Frequency of Signal : " + frequency);
        System.out.println("Sampling Interval   : " + Constants.SAMPLE_TIME);
    }
}
