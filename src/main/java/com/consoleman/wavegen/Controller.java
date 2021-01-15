package com.consoleman.wavegen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Slider sliderFrequency;
    @FXML
    Label labelValueFrequency;
    @FXML
    Slider sliderVolume;
    @FXML
    Label labelValueVolume;
    @FXML
    RadioButton radioButtonSin;
    @FXML
    RadioButton radioButtonTriangle;
    @FXML
    RadioButton radioButtonSquare;
    @FXML
    RadioButton radioButtonSawtooth;
    @FXML
    RadioButton radioButtonNoise;
    @FXML
    Label test;
    @FXML
    Button play;
    @FXML
    LineChart lineChart;
    @FXML
    Button Plot;

    private double frequency = 220;
    private String waveType;
    private double volume;
    private boolean isPlay = true;
    private Oscillator oscillator;
    XYChart.Series<Number, Number> series1 = new XYChart.Series<>();

    public void menuItemFileExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void initialize(URL location, ResourceBundle resources) {
        sliderFrequency.setValue(880);
        sliderVolume.setValue(25);

        labelValueFrequency.setText("" + (int) sliderFrequency.getValue());
        labelValueVolume.setText("" + (int) sliderVolume.getValue());

        ToggleGroup groupTypeWaveForms = new ToggleGroup();
        radioButtonSin.setToggleGroup(groupTypeWaveForms);
        radioButtonTriangle.setToggleGroup(groupTypeWaveForms);
        radioButtonSquare.setToggleGroup(groupTypeWaveForms);
        radioButtonSawtooth.setToggleGroup(groupTypeWaveForms);
        radioButtonNoise.setToggleGroup(groupTypeWaveForms);
        test.setText("Sin");

        oscillator = new Oscillator(this, frequency);

        waveType = "Noise";
        volume = 327.67;


        series1.setName("Sin");
//        series1.getData().add(new XYChart.Data<>(1, -285.0));
//        series1.getData().add(new XYChart.Data<>(2, -294.0));
//        series1.getData().add(new XYChart.Data<>(3, -303.0));
//        series1.getData().add(new XYChart.Data<>(4, -310.0));
//        series1.getData().add(new XYChart.Data<>(5, -316.0));
//        series1.getData().add(new XYChart.Data<>(6, -321.0));
//        series1.getData().add(new XYChart.Data<>(7, -324.0));
//        series1.getData().add(new XYChart.Data<>(8, -326.0));
//        series1.getData().add(new XYChart.Data<>(9, -327.0));
//        series1.getData().add(new XYChart.Data<>(10, -325.0));
//        series1.getData().add(new XYChart.Data<>(11, -322.0));
//        series1.getData().add(new XYChart.Data<>(12, -327.0));
//        series1.getData().add(new XYChart.Data<>(13, -318.0));
//        series1.getData().add(new XYChart.Data<>(14, -313.0));
//        series1.getData().add(new XYChart.Data<>(15, -306.0));
//        series1.getData().add(new XYChart.Data<>(16, -298.0));
//        series1.getData().add(new XYChart.Data<>(17, -306.0));
//        series1.getData().add(new XYChart.Data<>(18, -289.0));
//        series1.getData().add(new XYChart.Data<>(19, -279.0));
//        series1.getData().add(new XYChart.Data<>(20, -267.0));
//        series1.getData().add(new XYChart.Data<>(21, -255.0));
//        series1.getData().add(new XYChart.Data<>(22, -242.0));
//        series1.getData().add(new XYChart.Data<>(23, -227.0));
//        series1.getData().add(new XYChart.Data<>(24, -212.0));
//        series1.getData().add(new XYChart.Data<>(25, -196.0));
//        series1.getData().add(new XYChart.Data<>(26, -179.0));
//        series1.getData().add(new XYChart.Data<>(27, -162.0));
//        series1.getData().add(new XYChart.Data<>(28, -144.0));
//        series1.getData().add(new XYChart.Data<>(29, -125.0));
//        series1.getData().add(new XYChart.Data<>(30, -106.0));
//        series1.getData().add(new XYChart.Data<>(31, -86.0));
//        series1.getData().add(new XYChart.Data<>(32, -66.0));
//        series1.getData().add(new XYChart.Data<>(33, -46.0));
//        series1.getData().add(new XYChart.Data<>(34, -26.0));
//        series1.getData().add(new XYChart.Data<>(35, -5.0));
//        series1.getData().add(new XYChart.Data<>(36, 14.0));
//        series1.getData().add(new XYChart.Data<>(37, 35.0));
//        series1.getData().add(new XYChart.Data<>(38, 55.0));
//        series1.getData().add(new XYChart.Data<>(39, 75.0));
//        series1.getData().add(new XYChart.Data<>(40, 95.0));
//        series1.getData().add(new XYChart.Data<>(41, 115.0));
//        series1.getData().add(new XYChart.Data<>(42, 134.0));
//        series1.getData().add(new XYChart.Data<>(43, 152.0));
//        series1.getData().add(new XYChart.Data<>(44, 170.0));
//        series1.getData().add(new XYChart.Data<>(45, 187.0));
//        series1.getData().add(new XYChart.Data<>(46, 204.0));
//        series1.getData().add(new XYChart.Data<>(47, 219.0));
//        series1.getData().add(new XYChart.Data<>(48, 234.0));
//        series1.getData().add(new XYChart.Data<>(49, 248.0));
//        series1.getData().add(new XYChart.Data<>(50, 261.0));
//        series1.getData().add(new XYChart.Data<>(51, 273.0));
//        series1.getData().add(new XYChart.Data<>(52, 284.0));
//        lineChart.getData().add(series1);
    }

    public void setFrequency() {
        setSliderValue(sliderFrequency, labelValueFrequency);
//        labelValueHz.setText("Value: " +  String.valueOf((int) sliderHz.getValue()) + " Hz");
        frequency =  sliderFrequency.getValue();
    }

    public void setVolume() {
        setSliderValue(sliderVolume, labelValueVolume);
        volume = (sliderVolume.getValue() * Short.MAX_VALUE)/100 ;
    }

    public void setSliderValue(Slider slider, final Label label)
    {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValueSlider, Number newValueSlider) {
                label.setText(String.valueOf((int) newValueSlider.doubleValue()));
            }
        });
    }

    public void getSelectRadioButtons(ActionEvent actionEvent) {
        if(radioButtonSin.isSelected()){
            test.setText("Sin");
            waveType = "Sin";
        }
        if(radioButtonTriangle.isSelected()){
            test.setText("Triangle");
            waveType = "Triangle";
        }
        if(radioButtonSquare.isSelected()){
            test.setText("Square");
        }
        if(radioButtonSawtooth.isSelected()){
            test.setText("Saw");
            waveType = "Saw";
        }
        if(radioButtonNoise.isSelected()){
            test.setText("Noise");
            waveType = "Noise";
        }
    }
    public double getSliderPitch() {
        return sliderFrequency.getValue();
    }

    public void play() {
        if(isPlay){
            oscillator.start();
        } else {
            oscillator.exit();
//            oscillator.stop();
        }
        setClickPlayStatus();
    }

    public void setClickPlayStatus() {
        isPlay = !isPlay;
    }

    public String getWaveType() {
        return waveType;
    }

    public double getVolume() {
        return volume;
    }

    public XYChart.Series<Number, Number> getSeries() {
        return series1;
    }

    public void plot() {
        byte[] array = oscillator.samplesArray.clone();
        for (int i = 0; i < 600; i++) {
            series1.getData().add(new XYChart.Data<>(i, array[i]));
            System.out.println(array[i]);
        }

        lineChart.getData().add(series1);
    }
}
