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
import java.util.Random;
import java.util.Date;

public class FishSim {
	ImageIcon[] icons;
	JFrame frame;
	JPanel panel;
	JButton[][] button;
	JButton start;
	JButton stop;
	JButton reset;
	int rep = 0;

	public FishSim() {

		frame = new JFrame("FishSim");
		frame.setSize(1250, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		icons = new ImageIcon[10];

		icons[0] = new ImageIcon(getClass().getClassLoader().getResource("Water.jpg"));
		icons[1] = new ImageIcon(getClass().getClassLoader().getResource("Start.png"));
		icons[2] = new ImageIcon(getClass().getClassLoader().getResource("Stop.png"));
		icons[3] = new ImageIcon(getClass().getClassLoader().getResource("Reset.png"));
		icons[4] = new ImageIcon(getClass().getClassLoader().getResource("SeaWeed.jpg"));
		icons[5] = new ImageIcon(getClass().getClassLoader().getResource("FishPH.png"));
		icons[6] = new ImageIcon(getClass().getClassLoader().getResource("SharkPH.png"));

		start = new JButton(icons[1]);
		start.setBorder(null);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i>button.length; i++) {
					for(int j=0; j>button[0].length; j++) {
						
					}
				}
				
			}

		});

		c.gridheight = 2;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(start, c);

		stop = new JButton(icons[2]);
		stop.setBorder(null);

		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});

		c.gridheight = 2;
		c.gridwidth = 5;
		c.gridx = 10;
		c.gridy = 0;
		panel.add(stop, c);

		reset = new JButton(icons[3]);
		reset.setBorder(null);

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reset(0);

			}

		});

		c.gridheight = 2;
		c.gridwidth = 5;
		c.gridx = 5;
		c.gridy = 0;
		panel.add(reset, c);

		button = new JButton[15][15];

		String[][] ac = new String[15][15];

		for (int i = 0; i < ac.length; i++) {
			for (int j = 0; j < ac[0].length; j++) {
				ac[i][j] = Integer.toString(i) + "-" + Integer.toString(j);
			}
		}

		// clear buttons
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {

				button[i][j] = new JButton(icons[4]);

				button[i][j].setBorder(null);

				button[i][j].setActionCommand((ac[i][j]));

				button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int num1, num2;

						String[] str = e.getActionCommand().split("-");

						num1 = Integer.valueOf(str[0]);
						num2 = Integer.valueOf(str[1]);
						
						if (button[num1][num2].getIcon().equals(icons[4])) {
							button[num1][num2].setIcon(icons[6]);
						}
					}

				});

				c.gridheight = 1;
				c.gridwidth = 1;
				c.gridx = i;
				c.gridy = j + 2;
				panel.add(button[i][j], c);
			}
		}

		reset(1);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	public void reset(int go) {
		Random r = new Random();
		if (go == 1) {
			for (int s = 0; s < 15; s++) {
				int x = r.nextInt(15);
				int y = r.nextInt(15);
				button[x][y].setIcon(icons[5]);
			}
		} else {
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button.length; j++) {
					button[i][j].setIcon(icons[4]);
				}
			}

			for (int s = 0; s < 15; s++) {
				int x = r.nextInt(15);
				int y = r.nextInt(15);
				if (!button[x][y].getIcon().equals(icons[5])) {
					button[x][y].setIcon(icons[5]);
				}else {
					s += 1;
				}
				
			}

		}
	}

}
