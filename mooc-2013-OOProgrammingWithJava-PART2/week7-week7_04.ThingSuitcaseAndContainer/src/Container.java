
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class Container {

    private int maximumWeight;
    private ArrayList<Suitcase> suitcases;

    public Container(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        suitcases = new ArrayList<Suitcase>();
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitcase : suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }

    public void addSuitcase(Suitcase suitcase) {

        if (suitcase.totalWeight() + totalWeight() <= maximumWeight) {
            this.suitcases.add(suitcase);
        }

    }

    public void printThings() {

        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }

    }

    public String toString() {
        if (this.suitcases.isEmpty()) {
            return null;
        }

        if (this.suitcases.size() == 1) {
            return this.suitcases.size() + " suitcase (" + totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
