/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        String s;
        s = "Farm owner: " + this.owner + "\n";
        s += "Barn bulk tank: " + this.barn.getBulkTank().toString() + "\n";
        s += "Animals: " + "\n";
        for (Cow cow : cows) {
            s += "        " + cow.toString() + "\n";
        }
        return s;

    }
}
