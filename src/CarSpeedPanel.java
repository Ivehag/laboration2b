import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CarSpeedPanel extends JPanel {
    private int currentCarIndex = 0;
    private int currentNrOfCars = CarModel.getInstance().getNrCars();

    JPanel speedPanel = new JPanel();
    JPanel carPanel = new JPanel();

    JSpinner carSpinner = new JSpinner();

    JLabel carLabel = new JLabel();
    JLabel currentSpeedLabel = new JLabel();
    JLabel showCurrentSpeedLabel = new JLabel();

    public CarSpeedPanel() {
        initComponents();
    }

    private void initComponents() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        currentNrOfCars - 1, //max
                        1);//step
        carSpinner = new JSpinner(spinnerModel);
        carSpinner.addChangeListener(new ChangeListener() {
                                                 public void stateChanged(ChangeEvent e) {
                                                     System.out.println("hejsan");
                                                     if (CarModel.getInstance().getNrCars()<1){
                                                         System.out.println("hello");
                                                        return;
                                                     }
                                                     currentNrOfCars = CarModel.getInstance().getNrCars() - 1;
                                                     SpinnerModel spinnerModel =
                                                             new SpinnerNumberModel(0, //initial value
                                                                     0, //min
                                                                     currentNrOfCars , //max
                                                                     1);//step
                                                     carSpinner = new JSpinner(spinnerModel);
                                                     currentCarIndex = (int) ((JSpinner) e.getSource()).getValue();
                                                     carLabel.setText("Bil:" + CarModel.getInstance().getModelName(currentCarIndex));
                                                     showCurrentSpeedLabel.setText(Double.toString(CarModel.getInstance().getCurrentSpeed(currentCarIndex)));

                                                 }
                                             });

        carLabel.setText("Bil:" + CarModel.getInstance().getModelName(currentCarIndex));
        currentSpeedLabel = new JLabel("Current speedster:");
        showCurrentSpeedLabel.setText(Double.toString(CarModel.getInstance().getCurrentSpeed(currentCarIndex)));

        carPanel.setLayout(new BorderLayout());
        carPanel.add(carLabel, BorderLayout.PAGE_START);
        carPanel.add(carSpinner, BorderLayout.PAGE_END);

        this.add(carPanel);

        // speedPanel.setLayout(new GridLayout(1, 1));
        speedPanel.setLayout(new BorderLayout());
        speedPanel.add(currentSpeedLabel, BorderLayout.PAGE_START);
        speedPanel.add(showCurrentSpeedLabel, BorderLayout.PAGE_END);

        this.add(speedPanel);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (CarModel.getInstance().getNrCars()>0) {
            SpinnerModel spinnerModel =
                    new SpinnerNumberModel(0, //initial value
                            0, //min
                            currentNrOfCars - 1, //max
                            1);//step
            carSpinner = new JSpinner(spinnerModel);
            carLabel.setText("Bil:" + CarModel.getInstance().getModelName(currentCarIndex));
            showCurrentSpeedLabel.setText(Double.toString(CarModel.getInstance().getCurrentSpeed(currentCarIndex)));
        }
    }

}
