package com.consoleman.wavegen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
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

    private double frequency = 440;
    private String waveType;
    private double volume;
    private boolean isPlay = true;
    private Oscillator oscillator;

    public void menuItemFileExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void initialize(URL location, ResourceBundle resources) {
        sliderFrequency.setValue(440);
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

        waveType = "Sin";
        volume = 327.67;
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
//            oscillator.exit();
            oscillator.stop();
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
}
