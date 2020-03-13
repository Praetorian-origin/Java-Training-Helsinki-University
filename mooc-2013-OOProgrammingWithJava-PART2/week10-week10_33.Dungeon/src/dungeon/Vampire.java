/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author praetorian
 */
public class Vampire extends GamePiece {

    boolean vampiresMove;
   

    public Vampire(GameBoard ui, boolean vampiresMove) {
        super(ui);
        this.vampiresMove = vampiresMove;
    }



    @Override
    void move(int dx, int dy) {
        if (vampiresMove) {
           if(ui.getHeight() < x + dx || x + dx < 0  || ui.getLength() < x + dx || y + dy < 0) {
               return;
           }
            this.setX(x + dx);
            this.setY(y + dy);
        }

    }

    @Override
    public String toString() {
        return "v " + super.toString();
    }



}
