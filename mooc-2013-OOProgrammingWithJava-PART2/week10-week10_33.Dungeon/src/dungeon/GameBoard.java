/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class GameBoard {

    private int height;
    private int length;

    List<String> gamingBoard;

    public GameBoard(int length, int height) {
        gamingBoard = new ArrayList<String>();
        this.length = length;
        this.height = height;
    }

    public void reset() {
        gamingBoard.clear();
        for (int i = 0; i < height; i++) {
            String ligne = "";
            for (int j = 0; j < length; j++) {
                ligne += ".";
            }

            gamingBoard.add(ligne);
        }

    }

    public void display() {
        for (String string : gamingBoard) {
            System.out.println(string);
        }
    }
    
    
    public void piecesToDestroy(List<Vampire> vampires, Player p) {
          ArrayList<Vampire> toBeRemoved = new ArrayList<Vampire>();
          
        for (Vampire vampire : vampires) {
            if(p.getX() == vampire.getX() && p.getY() == vampire.getY()) {
                toBeRemoved.add(vampire);
            }
        }
        vampires.removeAll(toBeRemoved);
    }

    public void replace(List<Vampire> vampires, Player p) {
        StringBuilder sb;

        for (Vampire vampire : vampires) {
            int x = vampire.getX();
            int y = vampire.getY();

            sb = new StringBuilder(gamingBoard.get(y));
            sb.setCharAt(x, 'V');
            gamingBoard.set(y, sb.toString());
        }

        sb = new StringBuilder(gamingBoard.get(p.getY()));
        sb.setCharAt(p.getX(), '@');
        gamingBoard.set(p.getY(), sb.toString());
    }

    public void getPositionningOfPiece(List<Vampire> vampires, Player p) {
        System.out.println(p.toString());
        for (Vampire vampire : vampires) {
            System.out.println(vampire.toString());
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

}
