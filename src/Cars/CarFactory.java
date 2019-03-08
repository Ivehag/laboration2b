package Cars;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import java.awt.*;

public class CarFactory {
    public Scania createScania() {
        return new Scania(2, 100, 0, Color.BLUE, "Scania", 700, 400, 0);
    }

    public Saab95 createSaab95() {
        return new Saab95(4, 100, 0, Color.CYAN, "Saab95", 300, 300, false);
    }

    public Volvo240 createVolvo240() {
        return new Volvo240(4, 100, 0, Color.black, "Volvo240", 0, 0);
    }
}
