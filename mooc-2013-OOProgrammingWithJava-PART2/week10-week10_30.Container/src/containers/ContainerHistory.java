/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        double maxValue = history.get(0);
        for (int i = 1; i < history.size(); i++) {
            if (maxValue < history.get(i)) {
                maxValue = history.get(i);
            }
        }
        return maxValue;
    }

    public double minValue() {
        double minValue = history.get(0);
        for (int i = 1; i < history.size(); i++) {
            if (minValue > history.get(i)) {
                minValue = history.get(i);
            }
        }
        return minValue;
    }

    public double average() {
        double sum = 0;
        for (Double value : history) {
            sum += value;
        }
        return sum / (double) history.size();
    }

    public double greatestFluctuation() {

        if (history.size() > 1) {

            double greatestfluctuation = Math.abs(history.get(1) - history.get(0));
            
            for (int i = 2; i < history.size(); i++) {
                Double fluctuation = Math.abs(history.get(i) - history.get(i - 1));
                if (fluctuation > greatestfluctuation) {
                    greatestfluctuation = fluctuation;
                }
            }
            return greatestfluctuation;
        }
        return 0;

    }

    public double variance() {
        if (history.isEmpty() || history.size() < 2) {
            return 0;
        }

        double avg = average();
        double sum = 0;

        for (double item : history) {

            sum += Math.pow((item - avg), 2);
        }

        return sum / (history.size() - 1);

    }

}
