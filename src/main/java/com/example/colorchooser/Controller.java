package com.example.colorchooser;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controller {
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), converter);
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), converter);
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), converter);
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), converter);

        redSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                red = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                green = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                blue = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        alphaSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                alpha = newValue.doubleValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
    }

}