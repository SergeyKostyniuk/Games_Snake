package ua.serhiiKostyniuk.main;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

public class SnakeGame extends JPanel{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int NEWWIDTH = WIDTH * SCALE + 7;
    public static final int NEWHEIGHT = HEIGHT * SCALE + 30;

    public SnakeGame() {}

    public void paint (Graphics graphics) {
        graphics.setColor(color(5, 50, 10));
        graphics.fillRect(0, 0, NEWWIDTH, NEWHEIGHT);
        graphics.setColor(color(255, 216,0));

        for(int x = 0; x <= NEWWIDTH; x += SCALE) {
            graphics.drawLine(x, 0 , x, NEWHEIGHT);
        }

        for(int y = 0; y <= NEWHEIGHT; y += SCALE) {
            graphics.drawLine(0, y, NEWWIDTH, y);
        }
    }

    private Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(NEWWIDTH, NEWHEIGHT);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);
    }
}
