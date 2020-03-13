
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Hand hand = new Hand();
        hand.add(new Card(14, Card.SPADES));
        hand.add(new Card(12, Card.HEARTS));
        hand.add(new Card(14, Card.DIAMONDS));
        hand.add(new Card(2, Card.SPADES));
        hand.add(new Card(7, Card.DIAMONDS));
        hand.sortAgainstSuit();
        hand.print();
        /*
        With code 
Hand hand = new Hand();
hand.add( new Card(14,Card.SPADES) ); 
hand.add( new Card(12,Card.HEARTS) ); 
hand.add( new Card(14,Card.DIAMONDS) ); 
hand.add( new Card(2,Card.SPADES) ); 
hand.add( new Card(7,Card.DIAMONDS) ); 
hand.sortAgainstSuit();
hand.print()
first should be printed 7 of Diamonds
print output was
A of Diamonds
7 of Diamonds
Q of Hearts
A of Clubs
2 of Clubs
                 */

    }
}
