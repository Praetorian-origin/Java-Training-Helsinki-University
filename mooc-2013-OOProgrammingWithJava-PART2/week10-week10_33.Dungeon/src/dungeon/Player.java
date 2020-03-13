/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author praetorian
 */
public class Player extends GamePiece {

    public Player(GameBoard ui) {
        super(ui);
        this.setX(0);
        this.setY(0);

    }

    public void TranslatePayerMoves(String moves) {
        int move_x = 0;
        int move_y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'w') {
                move_y -= 1;
            }
            if (moves.charAt(i) == 's') {
                move_y += 1;
            }
            if (moves.charAt(i) == 'a') {
                move_x -= 1;
            }
            if (moves.charAt(i) == 'd') {
                move_x += 1;
            }
        }
        move(move_x, move_y);
    }

    @Override
    void move(int dx, int dy) {
//        if (ui.getHeight() < x + dx || x + dx < 0 || ui.getLength() < x + dx || y + dy < 0) {
//            return;
//        }
      
        if (ui.getHeight() < x + dx) {
            this.setX(ui.getHeight() - 1);
        } else if (x + dx < 0) {
            this.setX(0);
        } else {
            this.setX(x + dx);
        }
        if (ui.getLength() < y + dy) {
            this.setY(ui.getLength() - 1);
        } else if (y + dy < 0) {
            this.setY(0);
        } else {
            this.setY(y + dy);
        }

    }

    @Override
    public String toString() {
        return "@ " + super.toString();
    }

}
