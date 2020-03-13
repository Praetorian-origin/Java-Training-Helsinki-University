
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//arrayList de jumpers ???
public class Main {

    public static void start(Scanner reader) {
        ArrayList<Jumper> jumpers = new ArrayList<Jumper>();
        int round = 1;
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        String participantName = "";
        while (true) {
            System.out.print("  Participant name: ");
            participantName = reader.nextLine();
            if (participantName.equals("")) {
                break;
            }

            jumpers.add(new Jumper(participantName));
        }
        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println();
        String command;

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit:");
     

            command = reader.nextLine();
            System.out.println();
            if (!command.equals("jump")) {
                break;
            }

            System.out.println("Round " + round);
            System.out.println();

            System.out.println("Jumping order:");
            // Collections.reverse( ) only accept List<E> as its argument ! and it will not even throw an error
            Collections.sort(jumpers, Collections.reverseOrder());
            int index = 1;
            for (Jumper jumper : jumpers) {
                System.out.println("  " + index + ". " + jumper.getParticipant() + " (" + jumper.sumPoints() + " points)");
                index++;
            }

            System.out.println("Results of round " + round);
            for (Jumper jumper : jumpers) {
                System.out.println("  " + jumper.getParticipant());
                int length = jumper.jumpLength();
                ArrayList<Integer> judgeScores;
                judgeScores = jumper.JudgeVotes();
                System.out.println("    length: " + length);
                System.out.println("    judge votes: " + judgeScores);
                jumper.addPoints(length, judgeScores);
            }
            round++;
            System.out.println();
        }
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results:");
        Collections.sort(jumpers);
        System.out.println("Position    Name");
        int index = 1;
        for (Jumper jumper : jumpers) {
            System.out.println(index + "           " + jumper.getParticipant() + " (" + jumper.sumPoints() + " points)");
            System.out.print("            jump lengths:");
            ArrayList<Integer> jumps = jumper.getJumpsLengths();
            int pos = 1;
            for (Integer jumpsLength : jumps) {
                if (pos == jumps.size()) {
                    System.out.print(" "+jumpsLength + " m");
                } else {
                    System.out.print(" "+jumpsLength + " m,");
                }

                pos++;
            }
            System.out.println();
            index++;
        }

    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        start(reader);

    }
}
