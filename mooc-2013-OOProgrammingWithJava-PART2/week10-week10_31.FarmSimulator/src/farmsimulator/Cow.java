/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author praetorian
 */
public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private String name;
    private double capacity;
    private double amount;
    private Random r = new Random();

    public Cow() {
        this.name = NAMES[r.nextInt(NAMES.length)];
        this.capacity = r.nextInt(25) + 15;
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = r.nextInt(25) + 15;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }

    @Override
    public double milk() {
        double amountRetired = amount;
        this.amount = 0;
        return amountRetired;
    }

    @Override
    public void liveHour() {
        double amountToAdd = 0.7 + (r.nextDouble() * (2 - 0.7));
        if (amount + amountToAdd <= capacity) {
            amount += amountToAdd;
        }
        else {
            amount = capacity;
        }

    }
}
