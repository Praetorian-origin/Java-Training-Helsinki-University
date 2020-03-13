/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author praetorian
 */
public class Dungeon {

    private int moves;
    private final boolean vampiresMove;
    private GameBoard ui;
    private List<Vampire> vampiresList;
    private Player player;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {

        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.ui = new GameBoard(length, height);

        vampiresList = new ArrayList<Vampire>();
        this.player = new Player(ui);
        for (int i = 0; i < vampires; i++) {
            vampiresList.add(new Vampire(ui, vampiresMove));
        }

    }

    public void setInitialPosOfVampires() {

        Random r = new Random();
              
        
        for (Vampire vampire : vampiresList) {
             
            while (vampireAlreadyThere(vampire.getX(), vampire.getY(), vampire) || (vampire.getX() == 0 && vampire.getY() == 0)) {
                
                vampire.setX(r.nextInt(ui.getHeight() - 1) + 1);
               
                vampire.setY(r.nextInt(ui.getLength() - 1) + 1);
            }
          
        }
    }

    public boolean vampireAlreadyThere(int x, int y, Vampire v) {
        boolean alreadyThere = false;
        for (Vampire vampire : vampiresList) {
            if (vampire.getX() == x && vampire.getY() == y && v != vampire) {
                alreadyThere = true;
               
            }
        }
        return alreadyThere;
    }

    public void moveVampires() {
        Random r = new Random();
        for (Vampire vampire : vampiresList) {
            int dx = r.nextInt(2) - 1;
            int dy = r.nextInt(2) - 1;
            if (!vampireAlreadyThere(dx + vampire.getX(), dy + vampire.getY(), vampire)) {
                vampire.move(dx, dy);
            }
        }

    }

    public void run() {
        
        this.reader = new Scanner(System.in);
       
        setInitialPosOfVampires();
  
        while (moves > 0 && vampiresList.size() > 0) {
            System.out.println(moves);
            System.out.println();

            ui.getPositionningOfPiece(vampiresList, player);
            System.out.println();
            ui.reset();
            ui.replace(vampiresList, player);
            ui.display();

            System.out.println();

            String userMoves = reader.nextLine();
            player.TranslatePayerMoves(userMoves);
            ui.piecesToDestroy(vampiresList, player);
            moveVampires();
            moves --;

        }
        
        if(moves == 0) {
            System.out.println("YOU LOSE");
        }
        else {
            System.out.println("YOU WIN");
        }

    }
}
