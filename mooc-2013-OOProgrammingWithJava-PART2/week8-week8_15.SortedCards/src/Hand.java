
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        for (Card card : hand) {
            System.out.println(card.toString());
        }
    }

    public void sort() {
        Collections.sort(hand);
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuit());
    }

    @Override
    public int compareTo(Hand t) {
        int sumValuesthis = 0;
        int sumValuest = 0;

        for (Card card : hand) {
            sumValuesthis += card.getValue();
        }

        for (Card card : t.hand) {
            sumValuest += card.getValue();
        }

        if (sumValuest > sumValuesthis) {
            return -1;
        } else if (sumValuest == sumValuesthis) {
          return 0;

        } else {
            return 1;
        }
    }
}
