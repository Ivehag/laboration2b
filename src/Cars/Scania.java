package Cars;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends AbstractCar implements ITruckBed {
    private double currentTruckBedGradient;

    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double currentTruckBedGradient) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
        this.currentTruckBedGradient = currentTruckBedGradient;
        try {
            image = ImageIO.read(Scania.class.getResourceAsStream("../pics/Scania.jpg"));
        } catch (IOException ex) {
        }
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void gas(double amount) {
        boolean isTruckBedLifted = getCurrentTruckBedGradient() < 1;
        boolean isIncrementSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) > getCurrentSpeed();
        boolean isInCurrentSpeedInterval = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) >= 0 && Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) <= getEnginePower();
        if (amount >= 0 && amount <= 1 && isIncrementSpeed && isInCurrentSpeedInterval && isTruckBedLifted) {
            incrementSpeed(amount);
        }
    }

    /***
     * Get method
     * @return
     */
    public double getCurrentTruckBedGradient() {
        return currentTruckBedGradient;
    }


    /***
     * Set method
     * @param gradient
     */
    public void setTruckBedGradient(double gradient) {
        this.currentTruckBedGradient = gradient;
    }

    /***
     * Tips the truck bed
     * @param gradients Amount of gradients we would like to tip the truck bed
     */
    public void tipTruckBed(double gradients) {
        double maxTruckBedGradient = 70.0;
        if (getCurrentTruckBedGradient() + gradients <= maxTruckBedGradient && getCurrentSpeed() == 0) {
            setTruckBedGradient(getCurrentTruckBedGradient() + gradients);
        }
    }

    /***
     * Lifts the truck bed
     * @param gradients Amount of gradients we would like to tip the truck bed
     */
    public void liftTruckBed(double gradients) {
        setCurrentSpeed(0);
        double minTruckBedGradient = 0.0;
        if (getCurrentTruckBedGradient() - gradients >= minTruckBedGradient /*&& getCurrentSpeed() == 0*/) {
            setTruckBedGradient(getCurrentTruckBedGradient() - gradients);
        }
    }


    public void startEngine() {
        if (Math.abs(currentTruckBedGradient - 0) <= 1) {
            setCurrentSpeed(0.1);
        }
    }

    /***
     * Speed factor
     * @return
     */
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


}
