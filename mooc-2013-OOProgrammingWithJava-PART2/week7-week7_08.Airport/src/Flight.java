/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author praetorian
 */
public class Flight {
    
    
    private String departureAiportCode;
    private String destinationAirportCode;
    private Plane plane;

    public Flight(String departureAiportCode, String destinationAirportCode, Plane plane) {
        this.departureAiportCode = departureAiportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getDepartureAiportCode() {
        return departureAiportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }
    
    
    
    
    
    
   
    
    
}
