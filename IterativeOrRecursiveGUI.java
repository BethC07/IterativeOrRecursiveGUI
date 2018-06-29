/*
 * FileName: Week4GUI.java
 * Author: Beth Carmichael
 * Date: 06/14/2018
 * Purpose: 
 *
 *
 */
package iterativeorrecursivegui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IterativeOrRecursiveGUI {

    // Initialize JFrame
    private JFrame frame;
    // Initialize JTextField
    private JTextField userInput, result, efficiency;
    // Initialize JLabel
    private JLabel userInputLabel, resultLabel, efficiencyLabel;
    // Initialize JButtons
    private JButton compute;
    // Initialize JRadioButtons
    private JRadioButton iterative, recursive;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 200;
    // Initialize variables used within the ATMGUI methods
    // accounts sets the radio button checking to be selected
    // as soon as the GUI is called
    private String function = "Iterative";
    // balance will hold the accounts current balance
    // for checking and viewing purposes
    private double balance;
    // withdrawsMade is the counter to determine when more than 4
    // withdraws are made to add the service charge
    private int withdrawsMade;
    // Instances of Sequence class
    Sequence iterativeSequence = new Sequence();
    Sequence recursiveSequence = new Sequence();
    
    // The ATMGUI() method will create the GUI showed to the user
    public IterativeOrRecursiveGUI() {
        new BorderLayout();
        // Calling the createPanel class to create the components in the box
        createPanel();
    }
    
    private void createPanel() {      
        frame = new JFrame("Project 3");
        // Setting the width and hight of the box
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        // Setting the JLabel variables
        userInputLabel = new JLabel("Enter n:");
        resultLabel = new JLabel("Result");
        efficiencyLabel = new JLabel("Efficiency");
        
        // Setting the JTextField variables
        userInput = new JTextField(16);
        userInput.setMaximumSize(userInput.getPreferredSize());
        result = new JTextField(16);
        result.setMaximumSize(result.getPreferredSize());
        efficiency = new JTextField(16);
        efficiency.setMaximumSize(efficiency.getPreferredSize());
        
        // Setting the JRadioButton variables
        iterative = new JRadioButton("Iterative");
        iterative.setActionCommand("Iterative");
        iterative.setSelected(true);
        // Creation of ActionListener for the checking radio button
        // that sets the account string variable to equal checking
        // for determining which account is selected
        iterative.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                if("Iterative".equals(ae.getActionCommand())) {
                    function = "Iterative";
                }
            }
        });
        recursive = new JRadioButton("Recursive");
        recursive.setActionCommand("Recursive");
        recursive.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                if("Recursive".equals(ae.getActionCommand())) {
                    function = "Recursive";
                }
            }
        });
        
        // Group the radio buttons together to prevent
        // both buttons being pressed at once
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(iterative);
        radioGroup.add(recursive);
        
        
        // Setting the JButton variable
        compute = new JButton("Compute");
        // calculateWithdraw actionListener
        compute.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userInputString = userInput.getText();
                int userInputIntegar = Integer.parseInt(userInputString);
                if(function == "Iterative") {
                    
                    result.setText("" + iterativeSequence.computeIterative(userInputIntegar));
                    efficiency.setText("" + iterativeSequence.getEfficiency());
                }
                else {
                    result.setText("" + recursiveSequence.computeRecursive(userInputIntegar));
                    efficiency.setText("" + recursiveSequence.getEfficiency());
                }
            }
        });

        
        // Base container to ensure the X_AXIS panels go from left to right
        // and down the GUI correctly
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        
        // The panel that is holding the Withdraw and Deposit buttons
        JPanel Xpanel1 = new JPanel();
        BoxLayout layout1 = new BoxLayout(Xpanel1, BoxLayout.Y_AXIS);
        Xpanel1.setLayout(layout1);
        
        JPanel panel2 = new JPanel();
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(layout2);
        panel2.add(iterative);
        panel2.add(recursive);
        Xpanel1.add(panel2);
        
        // The panel that is holding the Withdraw and Deposit buttons
        JPanel Xpanel2 = new JPanel();
        BoxLayout layout3 = new BoxLayout(Xpanel2, BoxLayout.X_AXIS);
        Xpanel2.setLayout(layout3);
        
        // The panel that is holding the Checking and Savings radio buttons
        JPanel panel3 = new JPanel();
        BoxLayout layout4 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        panel3.setLayout(layout4);
        userInputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        userInput.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel3.add(userInputLabel);
        panel3.add(userInput);
        Xpanel2.add(panel3);
        
        // The panel that is holding the Checking and Savings radio buttons
        JPanel panel4 = new JPanel();
        BoxLayout layout5 = new BoxLayout(panel4, BoxLayout.Y_AXIS);
        panel4.setLayout(layout5);
        panel4.add(compute);

        // The panel that is holding the Withdraw and Deposit buttons
        JPanel Xpanel3 = new JPanel();
        BoxLayout layout6 = new BoxLayout(Xpanel3, BoxLayout.X_AXIS);
        Xpanel3.setLayout(layout6);
        
        // The panel that is holding the Checking and Savings radio buttons
        JPanel panel5 = new JPanel();
        BoxLayout layout7 = new BoxLayout(panel5, BoxLayout.X_AXIS);
        panel4.setLayout(layout7);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        result.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel5.add(resultLabel);
        panel5.add(result);
        Xpanel3.add(panel5);
        
        // The panel that is holding the Checking and Savings radio buttons
        JPanel panel6 = new JPanel();
        BoxLayout layout8 = new BoxLayout(panel6, BoxLayout.X_AXIS);
        panel6.setLayout(layout8);
        efficiencyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        efficiency.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel6.add(efficiencyLabel);
        panel6.add(efficiency);
        Xpanel3.add(panel6);
        
        // Adding all the panels together for the finished result
        panel.add(Xpanel1);
        panel.add(Xpanel2);
        panel.add(panel4);
        panel.add(Xpanel3);
        frame.add(panel);
        
        // Exiting the program once "X" button on the window is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new IterativeOrRecursiveGUI();
    }
    
}
