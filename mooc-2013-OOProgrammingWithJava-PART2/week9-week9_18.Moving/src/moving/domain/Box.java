/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class Box implements Thing {

    private int maximumCapacity;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        things = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (thing.getVolume() + this.getVolume() <= this.maximumCapacity) {
            things.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : things) {
            volume += thing.getVolume();
        }
        return volume;
    }

    @Override
    public String toString() {
       return "things in the box: " + things.size(); 
    }
    
    

}
