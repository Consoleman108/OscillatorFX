package com.consoleman.wavegen;
import javax.sound.sampled.*;

public class Audio {
    private SourceDataLine sourceDataLine;
    private AudioFormat audioFormat;
    private DataLine.Info dataLineInfo;

    public Audio() {
        this.audioFormat = new AudioFormat(Constants.SAMPLING_RATE,
                Constants.SAMPLE_SIZE_IN_BITS,
                Constants.CHANNELS,
                Constants.SIGNED,
                Constants.BIG_ENDIAN);
        this.dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat, Constants.SINE_PACKET_SIZE * 2);
        try {
            if (!AudioSystem.isLineSupported(dataLineInfo))
                throw new LineUnavailableException();
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
        } catch (LineUnavailableException e) {
            System.out.println("Line of that type is not available");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public SourceDataLine getSourceDataLine() {
        return sourceDataLine;
    }

    public int getLineSampleCount() {
        return sourceDataLine.getBufferSize() - sourceDataLine.available();
    }
}