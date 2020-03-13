package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random r;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);

        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        // random.nextInt(max + 1 - min) + min;
        r = new Random();

        apple = new Apple(r.nextInt(width), r.nextInt(height));
        while (apple.getX() == worm.getX() && apple.getY() == worm.getY()) {
            apple = new Apple(r.nextInt(width), r.nextInt(height));
        }

    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {

        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {

        if (worm.getX() + 1 > width || worm.getX() - 1 < 0 || worm.getY() - 1 < 0 || worm.getY() + 1 > height) {
            continues = false;
        }

        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues()) {
            return;
        }

        worm.move();

        if (worm.runsInto(apple)) {

            worm.grow();

             setApple(new Apple(r.nextInt(width), r.nextInt(height)));
            while (apple.getX() == worm.getX() && apple.getY() == worm.getY()) {
                setApple(new Apple(r.nextInt(width), r.nextInt(height)));
            }
          
        }
        if (worm.runsIntoItself()) {
            continues = false;
        }

        super.setDelay(1000 / worm.getLength());
        updatable.update();

    }

}
