/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author praetorian
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory containerHistory;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        containerHistory = new ContainerHistory();
        this.addToTheContainer(initialVolume);
        //containerHistory.add(initialVolume);
    }

    public String history() {
        return containerHistory.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.containerHistory.add(this.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double vol = super.takeFromTheContainer(amount);
        
        this.containerHistory.add(this.getVolume());
        return vol;
    }
    
    public void printAnalysis()   {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + containerHistory.maxValue());
        System.out.println("Smallest product amount: " + containerHistory.minValue());
        System.out.println("Average: " + containerHistory.average());
        System.out.println("Greatest change: " + containerHistory.greatestFluctuation());
        System.out.println("Variance: " + containerHistory.variance());
    }   
}
