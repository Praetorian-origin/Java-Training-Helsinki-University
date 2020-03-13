/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author praetorian
 */
public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        capacity = 2000;
        volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        if (amount <= howMuchFreeSpace()) {
            this.volume += amount;            
        } else {
            this.volume += howMuchFreeSpace();
        }
    }

    public double getFromTank(double amount) {
        if (amount <= this.volume) {
            this.volume -= amount;
               return amount;
        }
        else {
            double rest = this.volume;
            this.volume = 0;
            return rest;
        }
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
    
    

}
