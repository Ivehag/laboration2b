import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarControlPanel extends JPanel {
    private static final int X = 800;
    private CarController carController = new CarController();
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Cars.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove\nCar");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JSpinner gasSpinner = new JSpinner();

    int gasAmount = 0;

    public CarControlPanel() {
        initComponents();
    }

    private void initComponents() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        1000, //max
                        1);//step
        gasSpinner = new

                JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new

                                             ChangeListener() {
                                                 public void stateChanged(ChangeEvent e) {
                                                     gasAmount = (int) ((JSpinner) e.getSource()).getValue();
                                                 }
                                             });
        gasPanel.setLayout(new

                BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new

                Dimension(X / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new

                Dimension(X / 5 - 15, 200));
        this.add(stopButton);

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.removeCar();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.addCar();
            }
        });
        startButton.addActionListener(new

                                              ActionListener() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      carController.startAllEngines();
                                                  }
                                              });

        stopButton.addActionListener(new

                                             ActionListener() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent e) {
                                                     carController.turnOffAllEngines();
                                                 }
                                             });

        gasButton.addActionListener(new

                                            ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    carController.gas(gasAmount);
                                                }
                                            });

        turboOnButton.addActionListener(new

                                                ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        carController.turboOn();
                                                    }
                                                });

        liftBedButton.addActionListener(new

                                                ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        carController.liftTruckBed();
                                                    }
                                                });

        brakeButton.addActionListener(new

                                              ActionListener() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      carController.brake(gasAmount);
                                                  }
                                              });

        turboOffButton.addActionListener(new

                                                 ActionListener() {
                                                     @Override
                                                     public void actionPerformed(ActionEvent e) {
                                                         carController.turboOff();
                                                     }
                                                 });

        lowerBedButton.addActionListener(new

                                                 ActionListener() {
                                                     @Override
                                                     public void actionPerformed(ActionEvent e) {
                                                         carController.lowerTruckBed();
                                                     }
                                                 });

        turboOffButton.addActionListener(new

                                                 ActionListener() {
                                                     @Override
                                                     public void actionPerformed(ActionEvent e) {
                                                         carController.turboOff();
                                                     }
                                                 });
    }
}
