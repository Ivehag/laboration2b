package Cars;

import java.awt.*;

public abstract class AbstractPositionable {

    private double x;
    private double y;
    private Color color;

    public AbstractPositionable(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /***
     * Gets the color of the car
     * @return A color
     */
    public Color getColor() {
        return color;
    }

    /***
     * Sets the color of the car
     * @param clr Color of the car
     */
    public void setColor(Color clr) {
        this.color = clr;
    }

    /***
     * Sets x-coordinate
     * @param newX
     */
    void setX(double newX) {
        this.x = newX;
    }

    /***
     * Sets the y-coordinate
     * @param newY
     */
    void setY(double newY) {
        this.y = newY;
    }


    /***
     * Gets the current x-coordinate
     * @return Current x-coordinate
     */
    public double getX() {
        double copy = this.x;
        return copy;
    }

    /***
     * Gets the current y-coordinate
     * @return Current y-coordinate
     */
    public double getY() {
        double copy = this.y;
        return copy;
    }

}
