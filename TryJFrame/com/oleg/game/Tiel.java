package com.oleg.game;



import java.awt.*;

public class Tiel {
    private Coord coord;
    private Color color;

    Tiel(Coord coord, Color color) {
        this.coord = coord;
        this.color = color;
    }

    static Tiel getTielByCoords(int x, int y) {
        for (int i = 0; i < Game.tiels.size(); i++) {
            if (Game.tiels.get(i).coord.x == x && Game.tiels.get(i).coord.y == y) {
                return Game.tiels.get(i);
            }
        }
        return null;
    }

    Coord getCoord() {
        return coord;
    }

    void setCoord(Coord coord) {
        this.coord = coord;
    }

    Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coord=" + coord + "   Color=" + color.toString();
    }
}
