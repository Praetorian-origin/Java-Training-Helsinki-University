
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class Jumper implements Comparable<Jumper> {

    private String participant;
    private ArrayList<Integer> jumpsLengths;
    private ArrayList<Integer> points;
    private Random r;

    public Jumper(String participant) {
        this.participant = participant;
        jumpsLengths = new ArrayList<Integer>();
        points = new ArrayList<Integer>();
        r = new Random();

    }

    public int jumpLength() {
        int jumpLength = r.nextInt(61) + 60;
        jumpsLengths.add(jumpLength);
        return jumpLength;
    }

    public String getParticipant() {
        return participant;
    }
    

    public ArrayList<Integer> JudgeVotes() {
        ArrayList<Integer> judgeVotes = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            judgeVotes.add(r.nextInt(11) + 10);
        }
        return judgeVotes;

    }

    public ArrayList<Integer> getJumpsLengths() {
        return jumpsLengths;
    }
    
    
    
    public void addPoints(int jumpLength, ArrayList<Integer> judgeVotes) {
        Collections.sort(judgeVotes);
        judgeVotes.remove(0);
        judgeVotes.remove(judgeVotes.size() - 1);
        int judgePoints = 0;
        for (Integer judgeVote : judgeVotes) {
            judgePoints += judgeVote;
        }
        points.add(jumpLength + judgePoints);
    }

    public int sumPoints() {
        int jumperPoints = 0;
        for (Integer jumperPoint : points) {
            jumperPoints += jumperPoint;
        }
        return jumperPoints;
    }

    @Override
    public int compareTo(Jumper t) {

        return t.sumPoints() - this.sumPoints();
        
    }

}
