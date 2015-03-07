package edu.berkeley.aep;

/**
 * Understands a four sided figure with four right angles
 */
public class Rectangle {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {

        this.length = length;
        this.width = width;
    }

    public int area() {
        return 0;
    }

    public int perimeter() {
        return 2 * length + 2 * width;
    }
}
