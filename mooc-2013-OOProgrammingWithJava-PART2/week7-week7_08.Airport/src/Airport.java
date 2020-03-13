
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class Airport {

    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;

    public Airport() {
        planes = new ArrayList<Plane>();
        flights = new ArrayList<Flight>();
    }

    public void addPlane(String planeID, int planeCapacity) {
        planes.add(new Plane(planeID, planeCapacity));
    }

    public void addFlight(Plane plane, String departureAirportCode, String destinationAirportCode) {
        flights.add(new Flight(departureAirportCode, destinationAirportCode, plane));

    }

    public Plane getPlane(String planeID) {
        Plane p = null;
        for (Plane plane : planes) {
            if (plane.getId().equals(planeID)) {
                p = plane;
            }
        }
        return p;
    }

    public void printPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane.getId() + " (" + plane.getCapacity() + " ppl)");
        }
    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight.getPlane().getId() + " ("
                    + flight.getPlane().getCapacity() + " ppl) (" + flight.getDepartureAiportCode() + "-"
                    + flight.getDestinationAirportCode() + ")");

        }
    }

    public void printPlaneInfo(Scanner reader) {
        System.out.print("Give plane ID: ");
        String planeID_searched = reader.nextLine();
        for (Plane plane : planes) {
            if (plane.getId().equals(planeID_searched)) {
                System.out.println(plane.getId() + " (" + plane.getCapacity() + " ppl)");
            }
        }
    }

}
