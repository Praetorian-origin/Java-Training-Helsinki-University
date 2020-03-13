
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
public class Box implements ToBeStored {

    private double maximumWeight;
    private ArrayList<ToBeStored> thingsInBox;

    public Box(double maximumWeight) {
        this.maximumWeight = maximumWeight;
        thingsInBox = new ArrayList<ToBeStored>();

    }

    public void add(ToBeStored thing) {

        if (thing.weight() + weight() <= maximumWeight) {
            thingsInBox.add(thing);
        }

    }

    @Override
    public String toString() {
//        if (this.thingsInBox.isEmpty() || thingsInBox.size() < 2) {
//            return "Box: " + thingsInBox.size() + " thing, total weight " + this.weight() + " kg";
//        }
        return "Box: " + thingsInBox.size() + " things, total weight " + this.weight() + " kg";
    }

    @Override
    public double weight() {
        double weight = 0;
        for (ToBeStored toBeStored : thingsInBox) {
            weight += toBeStored.weight();
        }
        return weight;
    }

}
