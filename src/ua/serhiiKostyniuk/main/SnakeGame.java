package ua.serhiiKostyniuk.main;

import ua.serhiiKostyniuk.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int NEWWIDTH = WIDTH * SCALE + 7;
    public static final int NEWHEIGHT = HEIGHT * SCALE + 30;
    public static final int SPEED = 5;

    Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000/SPEED, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

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

        for(int d = 0; d < snake.lenght; d++) {
            graphics.setColor(color(200, 0, 150));
            graphics.fillRect(snake.snakeX[d]*SCALE+1, snake.snakeY[d]*SCALE+1, SCALE-1, SCALE-1);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        repaint();
    }

    private  class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();

            if((key == KeyEvent.VK_RIGHT) & snake.direction != 2) snake.direction = 0;
            if((key == KeyEvent.VK_DOWN) & snake.direction != 3) snake.direction = 1;
            if((key == KeyEvent.VK_LEFT) & snake.direction != 0) snake.direction = 2;
            if((key == KeyEvent.VK_UP) & snake.direction != 1) snake.direction = 3;
        }
    }
}
