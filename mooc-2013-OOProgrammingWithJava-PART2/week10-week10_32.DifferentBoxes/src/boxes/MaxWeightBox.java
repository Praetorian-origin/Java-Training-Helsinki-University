/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class MaxWeightBox extends Box {
    
    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }
    
    public int sumThingsWeight() {
        int sumWeight = 0;
        for (Thing thing : things) {
            sumWeight += thing.getWeight();
        }
        return sumWeight;
    }

    @Override
    public void add(Thing thing) {
        if(thing.getWeight() + sumThingsWeight() <= this.maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
       return things.contains(thing);
    }
    
    
}
