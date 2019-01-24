package com.oleg.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int SIZE = 25;
    public static ArrayList<Tiel> tiels = new ArrayList<>();
    private Random random = new Random();
    private Coord keyCoord = new Coord();


    private Game() {
        initTiels();
        initPanel();
        initFrame();
    }

    public static void main(String[] args) {
        new Game();
    }

    private void initFrame() {

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("GAME");
        pack();
        setLocationRelativeTo(null);
    }

    private void initPanel() {

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                for (int i = 0; i < tiels.size(); i++) {
                    g.setColor(tiels.get(i).getColor());
                    g.fillRect(tiels.get(i).getCoord().x, tiels.get(i).getCoord().y, SIZE, SIZE);
                }
            }
        };
        panel.setFocusable(true);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / SIZE;
                int y = e.getY() / SIZE;
                Coord mouseCoord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    for (int i = 0; i < tiels.size(); i++) {
                        if (tiels.get(i).getColor() == Color.BLUE) {
                            tiels.get(i).setColor(Color.GREEN);
                        }
                    }
                    for (int i = 0; i < tiels.size(); i++) {
                        if (tiels.get(i).getCoord().x / SIZE == mouseCoord.x && tiels.get(i).getCoord().y / SIZE == mouseCoord.y) {
                            tiels.get(i).setColor(Color.BLUE);
                        }
                    }
                    repaint();
                }
            }
        });
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) pressUp();
                if (e.getKeyCode() == KeyEvent.VK_DOWN) pressDown();
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) pressRight();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) pressLeft();
                if (e.getKeyCode() == KeyEvent.VK_SPACE) pressSpace();
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);
    }

    private void initTiels() {
        for (int y = 0; y < HEIGHT; y += SIZE) {
            for (int x = 0; x < WIDTH; x += SIZE) {
                tiels.add(new Tiel(new Coord(x, y), Color.GREEN));
            }
        }
        tiels.get(389).setColor(Color.BLUE);
        tiels.get(22).setColor(Color.BLACK);
    }

    private void pressUp() {
        for (int i = 0; i < tiels.size(); i++) {
            if (tiels.get(i).getColor() == Color.BLUE && tiels.get(i).getCoord().y - SIZE >= 0
                    && Tiel.getTielByCoords(tiels.get(i).getCoord().x, tiels.get(i).getCoord().y - SIZE).getColor() != Color.BLACK) {
                keyCoord.x = tiels.get(i).getCoord().x;
                keyCoord.y = tiels.get(i).getCoord().y - SIZE;
                tiels.get(i).setColor(Color.GREEN);
            }
        }
        setMainTielColor();
    }

    private void pressDown() {
        for (int i = 0; i < tiels.size(); i++) {
            if (tiels.get(i).getColor() == Color.BLUE && tiels.get(i).getCoord().y + SIZE < HEIGHT
                    && Tiel.getTielByCoords(tiels.get(i).getCoord().x, tiels.get(i).getCoord().y + SIZE).getColor() != Color.BLACK) {
                keyCoord.x = tiels.get(i).getCoord().x;
                keyCoord.y = tiels.get(i).getCoord().y + SIZE;
                tiels.get(i).setColor(Color.GREEN);
            }
        }
        setMainTielColor();
    }

    private void pressRight() {
        for (int i = 0; i < tiels.size(); i++) {
            if (tiels.get(i).getColor() == Color.BLUE && tiels.get(i).getCoord().x + SIZE < HEIGHT
                    && Tiel.getTielByCoords(tiels.get(i).getCoord().x + SIZE, tiels.get(i).getCoord().y).getColor() != Color.BLACK) {
                keyCoord.x = tiels.get(i).getCoord().x + SIZE;
                keyCoord.y = tiels.get(i).getCoord().y;
                tiels.get(i).setColor(Color.GREEN);
            }
        }
        setMainTielColor();
    }

    private void pressLeft() {
        for (int i = 0; i < tiels.size(); i++) {
            if (tiels.get(i).getColor() == Color.BLUE && tiels.get(i).getCoord().x - SIZE >= 0
                    && Tiel.getTielByCoords(tiels.get(i).getCoord().x - SIZE, tiels.get(i).getCoord().y).getColor() != Color.BLACK) {
                keyCoord.x = tiels.get(i).getCoord().x - SIZE;
                keyCoord.y = tiels.get(i).getCoord().y;
                tiels.get(i).setColor(Color.GREEN);
            }
        }
        setMainTielColor();
    }

    private void pressSpace() {
        for (int i = 0; i < tiels.size(); i++) {
            if (tiels.get(i).getColor() == Color.BLUE || tiels.get(i).getColor() != Color.GREEN) {
                tiels.get(i).setColor(randomColor());
            }
        }
    }

    private void setMainTielColor () {
        for (Tiel tiel : tiels) {
            if (tiel.getCoord().x == keyCoord.x && tiel.getCoord().y == keyCoord.y) {
                tiel.setColor(Color.BLUE);
            }
        }
    }

    private Color randomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }
}