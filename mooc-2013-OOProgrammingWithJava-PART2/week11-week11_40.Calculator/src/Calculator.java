/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author praetorian
 */
public class Calculator {

    private int value;
    private GraphicCalculator graphicCalculator;

    public Calculator() {
        value = 0;
    }

    public void setGraphicCalculator(GraphicCalculator graphicCalculator) {
        this.graphicCalculator = graphicCalculator;
    }

    public int getValue() {
        return value;
    }

    public void increase(int number) throws Exception {
        value += number;
        disableOrEnableButton();
    }

    public void decrease(int number) throws Exception {
        value -= number;
        disableOrEnableButton();
    }

    public void disableOrEnableButton() {
        if (this.graphicCalculator != null) {
            if (value == 0) {
                graphicCalculator.setButtonResetDisabled();
            } else {
                graphicCalculator.setButtonResetEnabled();
            }
        }
    }

    public void reset() {
        value = 0;
        disableOrEnableButton();
    }

}
