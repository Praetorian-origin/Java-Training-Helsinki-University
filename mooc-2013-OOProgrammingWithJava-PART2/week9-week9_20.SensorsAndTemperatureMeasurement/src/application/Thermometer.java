/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author praetorian
 */
public class Thermometer implements Sensor {

    private boolean on;
  

    public Thermometer() {
        on = false;

    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void on() {
        on = true;
    }

    @Override
    public void off() {
        on = false;
    }

    @Override
    public int measure() {
        if(isOn()) {
           Random r = new Random();
           return r.nextInt(61) - 30;
           
        }
        throw new IllegalStateException("Sorry, but thermometer is off");
    }

}
