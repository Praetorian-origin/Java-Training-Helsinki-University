/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author praetorian
 */
public class Worm {

    private int x;
    private int y;
    private Direction direction;
    private List<Piece> pieces;
    private int maxLength;

    private int moves = 0;
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(x, y));
        maxLength = 3;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return getPieces().size();
    }

    public List<Piece> getPieces() {

        return this.pieces;
    }

    public void move() {
        moves++;
        switch (direction) {
            case UP: {
                this.y--;
                break;
            }
            case DOWN: {
                this.y++;
                break;
            }
            case LEFT: {
                this.x--;
                break;
            }
            case RIGHT: {
                this.x++;
                break;
            }
            default:
                break;
        }
        if (pieces.size() < maxLength) {
            pieces.add(new Piece(x, y));
        } else if (pieces.size() == maxLength) {
            pieces.add(new Piece(x, y));
            pieces.remove(0);
        }

    }

    public void grow() {
        if(pieces.size() >= 3) {
          
             maxLength++;
               System.out.println(maxLength);
        }
       
    }

    public boolean runsInto(Piece piece) {
        for (Piece pieceOfWorm : pieces) {
            if (pieceOfWorm.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
      
        for (Piece piece : pieces) {
            for (Piece piece1 : pieces) {
                if(piece != piece1 && piece.runsInto(piece1)) {
                    return true;
                }
            }
        }
    
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMoves() {
        return moves;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
    

}
