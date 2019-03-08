/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int X = 800;
    private final int Y = 800;
    private CarView frame;
    private CarModel carModel = CarModel.getInstance();


    public CarController() {

    }

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
CarModel.getInstance().init();

        //DrawPanel drawPanel = frame.drawPanel;

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");
        cc.frame.initComponents("CarSim 1.0");
        CarModel.getInstance().observers.add(cc.frame);

    }

    public void addCar() {
        carModel.addCar();
    }

    public void removeCar() {

            carModel.removeCar();

    }

    public void startAllEngines() {
        carModel.startAllEngines();
    }

    public void turnOffAllEngines() {
        carModel.turnOffAllEngines();
    }

    public void gas(int gasAmount) {
        carModel.gas(gasAmount);
    }

    public void turboOn() {
        carModel.turboOn();
    }

    public void liftTruckBed() {
        carModel.liftTruckBed();
    }

    public void brake(int gasAmount) {
        carModel.brake(gasAmount);
    }

    public void turboOff() {
        carModel.turboOff();
    }

    public void lowerTruckBed() {
        carModel.lowerTruckBed();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
// TODO: Create more for each component as necessary


       /*public void changeDirectionBasedOnKeyHit(KeyEvent e) {
            for (Cars.AbstractCar car : cars) {
                if (e.equals(KeyEvent.VK_RIGHT)) {
                    car.direction = Cars.AbstractCar.Direction.EAST;
                } else if (e.equals(KeyEvent.VK_DOWN)) {
                    car.direction = Cars.AbstractCar.Direction.SOUTH;
                } else if (e.equals(KeyEvent.VK_LEFT)) {
                    car.direction = Cars.AbstractCar.Direction.WEST;
                } else if (e.equals(KeyEvent.VK_UP)) {
                    car.direction = Cars.AbstractCar.Direction.NORTH;
                }
            }
        }*/

}
