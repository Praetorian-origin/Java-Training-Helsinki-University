
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
public class FlightServicePanel {
    
    
    
    public static void startFlightService(Scanner reader, Airport airport) {
        System.out.println("Flight service");
        System.out.println("--------------------");
        System.out.println();
        String command = "";
        while (true) {
            if (command.equals("x")) {
                System.out.println();
                break;
            }
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            command = reader.nextLine();

            if (command.equals("1")) {
                airport.printPlanes();
            }

            if (command.equals("2")) {
                airport.printFlights();
            }
            if (command.equals("3")) {
                airport.printPlaneInfo(reader);
            }

        }

    }

}
