package com.consoleman.wavegen;

import javafx.collections.FXCollections;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Oscillator extends Thread {
    private Audio audio;
    private Controller controller;
    private boolean exitThread = false;
    private double freq;
    private String waveType;
    private double volume;
    private List<Double> samplesList = new ArrayList();
    byte[] samplesArray;

    public Oscillator(Controller controller, double freq) {
        this.controller = controller;
        this.freq = freq;
        this.waveType = "Sin";
        this.volume = (Short.MAX_VALUE * 30) / 100;
    }

    public void run() {
        audio = new Audio();
        double cyclePosition = 0;
        double cycleInc;
        double sample;


        ByteBuffer buf = ByteBuffer.allocate(Constants.SINE_PACKET_SIZE);

        while (!exitThread) {
            freq = controller.getSliderPitch();
            waveType = controller.getWaveType();
            volume = controller.getVolume();
//            System.out.println(volume);
//            System.out.println(freq);
            cycleInc = freq/Constants.SAMPLING_RATE;
            buf.clear();

            for (int i=0; i < Constants.SINE_PACKET_SIZE/Constants.SAMPLE_SIZE; i++) {
                switch (waveType) {
                    case "Sin":
                        sample = Waves.Sin(cyclePosition, volume);
//                        samplesList.add(sample);
//                        controller.series1.getData().add(new XYChart.Data<>(i, sample));
                        buf.putShort((short) sample);
                        break;
                    case "Triangle":
                        buf.putShort(Waves.Triangle(cyclePosition));
                        break;
                    case "Saw":
                        buf.putShort(Waves.Saw(cyclePosition));
                        break;
                    case "Noise":
                        buf.putShort(Waves.Noise());
                        break;
                }

                cyclePosition += cycleInc;
                if (cyclePosition > 1)
                    cyclePosition -= 1;
            }

            audio.getSourceDataLine().write(buf.array(), 0, buf.position());
            samplesArray = new byte[buf.position()];
//            for (int i = 0; i < samplesArray.length; i++){
                samplesArray = buf.array().clone();
//            }

            try {
                while (audio.getLineSampleCount() > Constants.SINE_PACKET_SIZE)
                    Thread.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        audio.getSourceDataLine().drain();
        audio.getSourceDataLine().close();
    }

    public void exit() {
        exitThread = true;
    }


}

