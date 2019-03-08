import Cars.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarModel implements IObservable {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    private static final int X = 800;
    private static final int Y = 800;
    private static final int MAX_CARS = 10;

    private ArrayList<AbstractCar> cars = new ArrayList<>();
    private ArrayList<ITurbo> saabs = new ArrayList<>();
    private ArrayList<ITruckBed> scanias = new ArrayList<>();

//    private Point volvoPoint = new Point();
//    private Point saabPoint = new Point();
//    private Point scaniaPoint = new Point();

    //CarView frame;
    private static CarModel instance;
    ArrayList<IObserver> observers = new ArrayList<>();

    private CarModel() {
        //init();
        TimerListener timerListener = new TimerListener();
    }

    void removeCar() {
        if (cars.size() > 0) {
            cars.remove(cars.size() - 1);
        }
    }

    void addCar() {
        CarFactory carFactory = new CarFactory();
        if (cars.size() <= MAX_CARS) {
            AbstractCar newCar = carFactory.createVolvo240();
            newCar.setDirectionWest();
            cars.add(newCar);
        }
    }

    double getCurrentSpeed(int index) {
        double copy = cars.get(index).getCurrentSpeed();
        return copy;
    }

    public static CarModel getInstance() {
        if (instance == null) {
            instance = new CarModel();
        }
        return instance;
    }

    @Override
    public void pingAll() {
        for (IObserver o : observers) {
            o.update();
        }
    }

   public void init() {
        CarFactory carFactory = new CarFactory();
        AbstractCar saab = carFactory.createSaab95();
        AbstractCar scania = carFactory.createScania();
        //     Cars.Saab95 saab = new Cars.Saab95(4, 100, 0, Color.CYAN, "Cars.Saab95", 300, 300, false);
        //     Cars.Scania scania = new Cars.Scania(2, 100, 0, Color.BLUE, "Cars.Scania", 700, 500, 0);

        cars.add(carFactory.createVolvo240());
        cars.add(saab);
        cars.add(scania);
        saabs.add((ITurbo) saab);
        scanias.add((ITruckBed) scania);
        setAllDirectionsWest();
        // Start the timer
        timer.start();
    }

    void setAllDirectionsWest() {
        for (AbstractCar car : cars) {
            car.setDirectionWest();
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractCar car : cars) {
                //          System.out.println(car.direction);
                //  changeDirectionBasedOnKeyHit();
                changeDirectionIfCarHitsFrame(car);
                //     System.out.println(car.direction);
                //   System.out.println(car.getY());
                //    System.out.println(saabs.get(0).getTurboStatus());
                car.move();
            //    int x = (int) Math.round(car.getX());
           //     int y = (int) Math.round(car.getY());

                //compares each car to lists of Cars.ITurbo and Cars.ITruckBed
                //to choose the correct image to move
             //   moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
//                frame.drawPanel.repaint();
            }
            pingAll();
        }
    }

    int getNrCars() {
        int copy = cars.size();
        return copy;
    }

    //void setAllDire
    // TODO: Make this general for all cars
    String getModelName(int INDEX) {

        String copy = cars.get(INDEX).getModelName();
        return copy;
    }

   // void moveit(AbstractCar car, int x, int y) {
    //    car.setX((double) x);
     //   car.setY((double) y);
       /* if (scanias.contains(car)) {
            updateCarPoints(x, y, scaniaPoint);
        } else if (saabs.contains(car)) {
            updateCarPoints(x, y, saabPoint);
        } else {
            updateCarPoints(x, y, volvoPoint);
        }*/
   // }

    BufferedImage getImage(int index) {
        BufferedImage copy = cars.get(index).getImage();
        return copy;
    }

  /*  private void updateCarPoints(int x, int y, Point carPoints) {
        carPoints.x = x;
        carPoints.y = y;
    }*/

    int getX(int index) {
        int temp = (int) cars.get(index).getX();
        return temp;
    }

    int getY(int index) {
        int temp = (int) cars.get(index).getY();
        return temp;
    }
/*    Point getCarPoint(String modelName) {
        if (modelName.equals("Scania")) {
            return scaniaPoint;
        } else if (modelName.equals("Saab95")) {
            return saabPoint;
        }
        return volvoPoint;
    }*/


    private void changeDirectionIfCarHitsFrame(AbstractCar car) {
        if (car.getX() > X - 100) {
            car.setDirectionWest();
        } else if (car.getX() < 0) {
            car.setDirectionEast();
        } else if (car.getY() < 0) {
            car.setDirectionSouth();
        } else if (car.getY() > Y - 300) {
            car.setDirectionNorth();
        }
    }


    /**
     * Calls cas method for each car
     *
     * @param amount
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar c : cars) {
            if (scanias.contains(c)) {
                ((ITruckBed) c).gas(gas);
            } else {
                c.gas(gas);
            }
        }
    }

    /**
     * Starts engine based on which car
     */
    void startAllEngines() {
        for (AbstractCar c : cars) {
            if (scanias.contains(c)) {
                ((ITruckBed) c).startEngine();
            } else {
                c.startEngine();
            }
        }
    }

    /**
     * Turns off all engines
     */
    void turnOffAllEngines() {
        for (AbstractCar c : cars) {
            c.stopEngine();
        }
    }

    /**
     * Uses brake on all cars
     *
     * @param amount
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.brake(brake);
        }
    }


    /**
     *
     */
    void turboOn() {
        for (ITurbo saab : saabs) {

            saab.setTurboOn();

        }
    }

    void turboOff() {
        for (ITurbo saab : saabs) {

            saab.setTurboOff();

        }
    }

    void lowerTruckBed() {
        for (ITruckBed sc : scanias) {
            sc.tipTruckBed(70);
        }
    }

    void liftTruckBed() {
        for (ITruckBed sc : scanias) {
            sc.liftTruckBed(70);
        }
    }

}

