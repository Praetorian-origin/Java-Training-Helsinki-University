/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author praetorian
 */
public class Barn {

    private BulkTank bulkTank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank bulkTank) {
        this.bulkTank = bulkTank;
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(bulkTank);
    }

    public void takeCareOf(Cow cow) {
        checkInstalled();
        milkingRobot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) {
        checkInstalled();
        for (Cow cow : cows) {
            milkingRobot.milk(cow);
        }
    }

    public void checkInstalled() {

        if (this.milkingRobot == null) {

            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }

    @Override
    public String toString() {
        return "Barn: " + Math.ceil(this.bulkTank.getVolume()) + "/" + this.bulkTank.getCapacity();
    }

}
