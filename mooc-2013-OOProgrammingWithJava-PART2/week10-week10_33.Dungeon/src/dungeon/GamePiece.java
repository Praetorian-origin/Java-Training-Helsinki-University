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
public abstract class GamePiece {
    protected int x;
    protected int y;
    protected GameBoard ui;

    public GamePiece(GameBoard ui) {
        this.ui = ui;
    }

      abstract void move (int dx, int dy);

   public int getX() {
       return this.x;
   }

    public int getY() {
        return y;
    }

    protected void setX(int x) {
        this.x = x;
    }
    
    protected void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
       return getX() + " " + getY();
    }
    
    
    
    
   
    
    
}
