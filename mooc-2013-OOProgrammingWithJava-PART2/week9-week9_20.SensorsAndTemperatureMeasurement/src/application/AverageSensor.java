/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        boolean allOn;
        allOn = true;
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                allOn = false;
            }
        }
        return allOn;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {

        if (this.isOn()) {
            int measures_sum = 0;
            for (Sensor sensor : sensors) {
                measures_sum += sensor.measure();
            }
            readings.add(measures_sum / sensors.size());
            return measures_sum / sensors.size();
        }
        throw new IllegalStateException("Sorry, one or many sensors are off");

    }
    
    public List<Integer> readings() {
        return readings;
    }

}
