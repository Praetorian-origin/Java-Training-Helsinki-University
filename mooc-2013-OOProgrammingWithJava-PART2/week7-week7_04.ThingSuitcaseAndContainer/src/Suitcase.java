
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
public class Suitcase {

    private ArrayList<Thing> things;
    private int maximumWeight;

    public Suitcase(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        things = new ArrayList<Thing>();
    }

    public int totalWeight() {
        int weight = 0;
        for (Thing thing1 : things) {
            weight += thing1.getWeight();
        }
        return weight;
    }

    public void addThing(Thing thing) {

        if (this.maximumWeight >= totalWeight() + thing.getWeight()) {
            things.add(thing);
        }
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing.getName() + " (" + thing.getWeight() + " kg)");
        }
    }

    public Thing heaviestThing() {
        if (things.isEmpty()) {
            return null;
        }
        
        Thing thingMaxWeightSoFar = things.get(0);
        for (Thing thing : things) {
            if (thing.getWeight() > thingMaxWeightSoFar.getWeight()) {
                thingMaxWeightSoFar = thing;
            }
        }
        return thingMaxWeightSoFar;
    }

    @Override
    public String toString() {
        int nbOfThings = this.things.size();

        if (nbOfThings == 0) {
            return "empty (0 kg)";
        }
        if(nbOfThings == 1) {
            return this.things.size() + " thing (" + totalWeight() + " kg)";
        }
        return this.things.size() + " things (" + totalWeight() + " kg)";
    }

}
