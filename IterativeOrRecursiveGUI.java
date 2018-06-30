package sequence;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainGUI extends JPanel {

    // First, I initiate all the JFrame variables I need to make my GUI work
    // JFrame is the box that will appear
    public JFrame frame;
    // JTextField is an inputable field that can be editied
    public JTextField nInput, result, efficiency;
    public JLabel nLabel, resultLabel, efficiencyLabel;
    // JButton is exactly that, a button
    // It can actually do something if it has a ActionListener
    public JButton computeButton;
    public JRadioButton iterative, recursive;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 250;
    public String compMode = "Iterative";
    
    public MainGUI() {
        super(new BorderLayout());
        
        // Calling the createPanel class to create the components in the box
        createPanel();
    }
    
    private void createPanel() {      
        frame = new JFrame("Project 3");
        // Setting the width and hight of the box
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Setting the JButton variable
        computeButton = new JButton("Compute");
        
        // Setting the JTextField variables
        nInput = new JTextField(5);
        nInput.setMaximumSize(nInput.getPreferredSize());
        result = new JTextField(10);
        result.setMaximumSize(result.getPreferredSize());
        efficiency = new JTextField(10);
        efficiency.setMaximumSize(efficiency.getPreferredSize());
        
        nLabel = new JLabel("Enter n:");
        resultLabel = new JLabel("Result:");
        efficiencyLabel = new JLabel("Efficiency:");
        
        // Setting the JRadioButton variables
        iterative = new JRadioButton("Iterative");
        iterative.setActionCommand("Iterative");
        iterative.setSelected(true);
        iterative.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                if("Iterative".equals(ae.getActionCommand())) {
                    compMode = "Iterative";
                }
            }
        });
        recursive = new JRadioButton("Recursive");
        recursive.setActionCommand("Recursive");
        recursive.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                if("Recursive".equals(ae.getActionCommand())) {
                    compMode = "Recursive";
                }
            }
        });
        
        // Group buttons
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(iterative);
        radioGroup.add(recursive);
        
        // calculateWithdraw actionListener
        computeButton.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
            	String nString = nInput.getText();
            	int nNum;

            	if(checkIfInteger(nString) == true) {
            		
            		int resVal = 0;
            		nNum = Integer.parseInt(nString);
            		
            		if(compMode == "Iterative") {
                        resVal = Sequence.computeIterative(nNum);
                    }
                    else if(compMode == "Recursive") {
                    	resVal = Sequence.computeRecursive(nNum);
                    }
            		result.setText(Integer.toString(resVal));
            		int effVal = Sequence.getEfficiency();
                    efficiency.setText(Integer.toString(effVal));
            	}
            }
            
        });
        
        JPanel mainPanel = new JPanel(new GridLayout(6,5,10,15));
        mainPanel.add(new JLabel(""));
        mainPanel.add(iterative);
        mainPanel.add(new JLabel(""));
        mainPanel.add(recursive);
        mainPanel.add(nLabel);
        mainPanel.add(nInput);
        mainPanel.add(new JLabel(""));
        mainPanel.add(computeButton);
        mainPanel.add(resultLabel);
        mainPanel.add(result);
        mainPanel.add(efficiencyLabel);
        mainPanel.add(efficiency);
        
        frame.add(mainPanel);
        
        // Exiting the program once "X" button on the window is pressed
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event){
            	
            	try {
					writeCSV();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	System.exit(0);
            }
        });
        frame.setVisible(true);
        
    }
    
    public static void writeCSV() throws IOException {
    	File writeFile = new File("H:\\Users\\David\\Desktop\\Project3.txt");
    	FileOutputStream fileOutput = new FileOutputStream(writeFile);
     
    	BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(fileOutput));
    	buffWrite.write("n Value,Iterative Value,Recursive Value");
		buffWrite.newLine();
		
    	int iterVal, recVal;
    	
    	for (int i = 0; i <= 10; i++) {
    		Sequence.computeIterative(i);
    		iterVal = Sequence.getEfficiency();
    		Sequence.computeRecursive(i);
    		recVal = Sequence.getEfficiency();
    		
    		buffWrite.write(i + "," + iterVal + "," + recVal);
    		buffWrite.newLine();
    	}
     
    	buffWrite.close();
    }
    
    public boolean checkIfInteger(String inputText) {
        try {
            Integer.parseInt(inputText);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

 public static void main(String[] args) {
     
	 new MainGUI();

    }   
}
