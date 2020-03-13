/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author praetorian
 */
public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        ArrayList<Box> boxs = new ArrayList<Box>();

        for (Thing thing : things) {

            if (boxs.isEmpty()) {
                boxs.add(new Box(this.boxesVolume));
            }
            if (boxs.get(boxs.size() - 1).addThing(thing) == false) {
                boxs.add(new Box(this.boxesVolume));
                boxs.get(boxs.size() - 1).addThing(thing);
            }

        }
        return boxs;
    }

}
