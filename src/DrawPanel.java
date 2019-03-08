import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    private final int MAX_CARS = 10;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
       // try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("pics/Cars.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
        /*    for (int i = 0; i < CarModel.getInstance().getNrCars(); i++) {
                //    System.out.println(carImages);
                carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/" + cM.getModelName(i) + ".jpg")));
            }
            for (int i = 0; i < CarModel.getInstance().getNrCars(); i++) {
                coordinates.add(cM.getCarPoint(cM.getModelName(i)));
            }*/

   /*         volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
   */
      /*  } catch (IOException ex) {
            ex.printStackTrace();
        }*/

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       /* for (int i = 0; i < CarModel.getInstance().getNrCars(); i++) {
            g.drawImage(carImages.get(i), coordinates.get(i).x, coordinates.get(i).y, null);
        }*/
        for (int i = 0; i < CarModel.getInstance().getNrCars(); i++) {
            g.drawImage(CarModel.getInstance().getImage(i), CarModel.getInstance().getX(i), CarModel.getInstance().getY(i), null);
        }
    }
}
