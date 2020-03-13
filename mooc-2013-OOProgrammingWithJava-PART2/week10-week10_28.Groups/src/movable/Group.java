/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class Group implements Movable {

    private List<Movable> objects;

    public Group() {
        objects = new ArrayList<Movable>();
    }
    
    
    
    
    public void addToGroup (Movable movable) {
        objects.add(movable);
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable object : objects) {
            object.move(dx, dy);
        }
    }
    
    public String toString() {
        String pos_objects ="";
        for (Movable object : objects) {
            pos_objects += object.toString() + "\n";
        }
        return pos_objects;
    }
    
}
