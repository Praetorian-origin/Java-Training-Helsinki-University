
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
public class AirportServicePanel {

    public static void startAirportService(Scanner reader, Airport airport) {

        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
        String command = "";
        while (true) {
            if (command.equals("x")) {
                System.out.println();
                break;
            }
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            command = reader.nextLine();

            if (command.equals("1")) {
                addAirplane(reader, airport);
            }

            if (command.equals("2")) {
                addFlight(reader, airport);
            }

        }

    }

    public static void addAirplane(Scanner reader, Airport airport) {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(reader.nextLine());
        airport.addPlane(planeID, planeCapacity);
    }

    public static void addFlight(Scanner reader, Airport airport) {
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        Plane plane = airport.getPlane(planeID);
        if (plane == null) {
            return;
        }
        System.out.print("Give departure airport code: ");
        String departureAirportCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationAirportCode = reader.nextLine();
        airport.addFlight(plane, departureAirportCode, destinationAirportCode);

    }
}
