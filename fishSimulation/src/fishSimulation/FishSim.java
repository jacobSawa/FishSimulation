/*
 * Jacob Sawatzky, Nicholas Bergen, Carter Reid
 * October 3, 2022
 * Fish/Shark Simulation
 */

package fishSimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class FishSim {
	ImageIcon water;
	JFrame frame;
	JPanel panel;
	JButton[][] button;
	JButton startButton;
	
	

	public FishSim() {
		frame = new JFrame("FishSim"); 
		frame.setSize(1250, 2500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		water = new ImageIcon(getClass().getClassLoader().getResource("Water.jpg"));

		button = new JButton[15][15]; 
		
		startButton = new JButton();
		startButton.setText("PRESS TO START SIMULATION");
		
		
		String[][] ac;
		
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
			
		});
		
		
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[i][j] = new JButton(water);
				button[i][j].setBorder(null); 

				//button[i][j].setActionCommand(ac[i][j]);

				button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int num1, num2;
						num1 = Integer.valueOf(e.getActionCommand()) / 10;

						num2 = Integer.valueOf(e.getActionCommand()) % 10;

					}

				});

				c.gridx = i;
				c.gridy = j;
				panel.add(button[i][j], c);
				
				
			}
		}
		
		c.gridx = -1;
		c.gridy = 7;
		panel.add(startButton, c);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
