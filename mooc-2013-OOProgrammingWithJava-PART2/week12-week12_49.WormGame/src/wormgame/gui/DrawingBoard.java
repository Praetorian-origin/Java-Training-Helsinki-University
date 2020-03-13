/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author praetorian
 */
public class DrawingBoard extends JPanel implements Updatable {

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Piece piece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(piece.getX()*pieceLength, piece.getY()*pieceLength, pieceLength, pieceLength, true);
        }

        g.setColor(Color.red);

        g.fillOval(wormGame.getApple().getX()*pieceLength, wormGame.getApple().getY()*pieceLength, pieceLength, pieceLength);

    }



    @Override
    public void update() {
        super.repaint();
    }

}
