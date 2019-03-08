import Cars.AbstractCar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements IObserver /*implements KeyListener*/ {
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    //private CarModel carModel = CarModel.getInstance();

    DrawPanel drawPanel = new DrawPanel(X, Y - 340);
    CarControlPanel controlPanel = new CarControlPanel();
    CarSpeedPanel carSpeedPanel = new CarSpeedPanel();


    // Constructor
    public CarView(String framename) {
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        if (CarModel.getInstance().getNrCars() > 0) {
            this.add(carSpeedPanel);
        }
        this.add(controlPanel);


        // This actionListener is for the gas button only
      /*  turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOff();
            }
        });
*/


        // Make the frame pack all it's components by respecting the sizes if possible.
        // addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void update() {
        repaint();
    }


/*
    @Override
    public void keyTyped(KeyEvent e) {
       // carModel.
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            carModel.setAllDirections();

        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            carModel.setAllDirections(AbstractCar.Direction.WEST);
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            carModel.setAllDirections(AbstractCar.Direction.SOUTH);
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            carModel.setAllDirections(AbstractCar.Direction.NORTH);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            carModel.setAllDirections(AbstractCar.Direction.EAST);
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            carModel.setAllDirections(AbstractCar.Direction.WEST);
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            carModel.setAllDirections(AbstractCar.Direction.SOUTH);
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            carModel.setAllDirections(AbstractCar.Direction.NORTH);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            carModel.setAllDirections(AbstractCar.Direction.EAST);
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            carModel.setAllDirections(AbstractCar.Direction.WEST);
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            carModel.setAllDirections(AbstractCar.Direction.SOUTH);
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            carModel.setAllDirections(AbstractCar.Direction.NORTH);
    }
    */
}