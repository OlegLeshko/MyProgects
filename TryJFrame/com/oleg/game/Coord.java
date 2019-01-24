package com.oleg.game;

public class Coord {
    public int x=0;
    public int y=0;

    public Coord() {
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return this.x == getX() && this.y == getY();
    }

    @Override
    public String toString() {
        return "x= " + x + " y= " + y;
    }
}
