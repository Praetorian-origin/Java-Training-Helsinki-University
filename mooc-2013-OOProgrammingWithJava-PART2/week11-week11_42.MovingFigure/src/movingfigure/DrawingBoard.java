/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author praetorian
 */
public class DrawingBoard extends JPanel {
    private Figure figure;

    public DrawingBoard(Figure figure) {
        this.figure = figure;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        figure.draw(grphcs);
        
    }
    
    
}
