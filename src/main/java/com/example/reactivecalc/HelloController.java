package com.example.reactivecalc;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    Slider sliderValue;

    @FXML
    Button bPlus, bMinus;

    @FXML
    TextField textValue, textBind;
    @FXML
    TextArea log;

    @FXML
    Slider slider2;

    SimpleIntegerProperty x = new SimpleIntegerProperty();

    public void initialize()
    {
        bMinus.setOnAction(actionEvent ->
            x.set(x.get()-1)
        );
        bPlus.setOnAction(actionEvent -> x.set(x.get()+1));

        x.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) {
                //log.setText(log.getText()+"\n"+"x изменился: "+oldVal+" ==> "+newVal);
                log.setText("x изменился: "+oldVal+" ==> "+newVal+"\n"+log.getText());
                slider2.adjustValue(x.get());
                textValue.setText(String.valueOf(x.get()));
            }
        });

        textValue.setOnAction(actionEvent -> x.set(Integer.parseInt(textValue.getText())));

        sliderValue.valueProperty().bindBidirectional(x);
        textBind.textProperty().bindBidirectional(x, new DecimalFormat());
    }

}