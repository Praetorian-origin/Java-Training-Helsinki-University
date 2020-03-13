
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class RingingCentre {

    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        observations = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!observations.containsKey(bird)) {
            observations.put(bird, new ArrayList<String>());
        }
        observations.get(bird).add(place);
    }

    public void observations(Bird bird) {
        if (observations.containsKey(bird)) {
            System.out.println(bird.toString() + " observations: " + observations.get(bird).size());
            for (String observation : observations.get(bird)) {
                System.out.println(observation);
            }
        } else {
System.out.println(bird.toString() + " observations: " + "0");
        }

    }

}
