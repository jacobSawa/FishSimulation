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

public class FishSim {
	ImageIcon[] icons;
	JFrame frame;
	JPanel panel;
	JButton[][] button;
	JButton start;
	JButton stop;
	JButton reset;
	int st = 0, sharks = 0, fish = 0, speed = 0, sharkDeathTimer = 0, sharkDeathCounter = 0;
	Timer timer;

	public FishSim() {
		speed = 500;
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
		icons[5] = new ImageIcon(getClass().getClassLoader().getResource("Nemor.jpg"));
		icons[6] = new ImageIcon(getClass().getClassLoader().getResource("Shark.jpg"));
		icons[7] = new ImageIcon(getClass().getClassLoader().getResource("SharkW.jpg"));
		icons[8] = new ImageIcon(getClass().getClassLoader().getResource("Blank.jpg"));

		start = new JButton(icons[1]);
		start.setBorder(null);
		
		timer = new Timer(speed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				System.out.println("Jacob sucks");
				if(st == 1 && fish > 0 && sharks > 0) {
					for (int i = 0; i < button.length; i++) {
						for (int j = 0; j < button[0].length; j++) {
							if (button[i][j].getIcon().equals(icons[5])) {
								int rand = r.nextInt(9);
								int eight = 0;

								int right = i + 2, left = i - 1, bottom = j + 2, top = j - 1;

								if (i + 1 >= 15) {
									right = i + 1;
								}
								if (i - 1 < 0) {
									left = i;
								}
								if (j + 1 >= 15) {
									bottom = j + 1;
								}
								if (j - 1 < 0) {
									top = j;
								}

								for (int g = left; g < right; g++) {
									for (int v = top; v < bottom; v++) {
										if (rand == eight) {
											if (button[g][v].getIcon().equals(icons[4])
													|| button[g][v].getIcon().equals(icons[0])) {
												button[i][j].setIcon(icons[0]);
												button[g][v].setIcon(icons[5]);
												g += 10;
												v += 10;

											}
											rand = r.nextInt(9);
										}
										eight += 1;

									}
								}
							}
						
							if (button[i][j].getIcon().equals(icons[6]) || button[i][j].getIcon().equals(icons[7])) {
								int rand = r.nextInt(9);
								int eight = 0;

								int right = i + 2, left = i - 1, bottom = j + 2, top = j - 1;

								if (i + 1 >= 15) {
									right = i + 1;
								}
								if (i - 1 < 0) {
									left = i;
								}
								if (j + 1 >= 15) {
									bottom = j + 1;
								}
								if (j - 1 < 0) {
									top = j;
								}

								for (int g = left; g < right; g++) {
									for (int v = top; v < bottom; v++) {
										if (rand == eight) {
											if(button[g][v].getIcon().equals(icons[5])) {
												sharkDeathTimer = 0;
											}else {
												sharkDeathCounter += 1;
											}
											
											if(sharkDeathCounter == sharks) {
												sharkDeathTimer += 1;
											}
											
											if(sharkDeathTimer != 5) {
												if (button[g][v].getIcon().equals(icons[4])
														|| button[g][v].getIcon().equals(icons[0])
														|| button[g][v].getIcon().equals(icons[5])) {
													if (!button[g][v].getIcon().equals(icons[5])) {
														if (button[g][v].getIcon().equals(icons[6])) {
															button[i][j].setIcon(icons[0]);
														} else {
															button[i][j].setIcon(icons[4]);
														}

													}
													if (button[g][v].getIcon().equals(icons[0])) {
														button[g][v].setIcon(icons[7]);
													} else {
														button[g][v].setIcon(icons[6]);
													}

													g += 10;
													v += 10;

												}
											}else {
												button[g][v].setIcon(icons[0]);
											}
											
											
											rand = r.nextInt(9);
										}
										eight += 1;
									}
								} 
							}

						}
					}
				}
				
				
			}
			
		});
		

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				st = 1;
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
				st = 0;
				timer.stop();
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

						if (button[num1][num2].getIcon().equals(icons[4]) && st == 0
								|| button[num1][num2].getIcon().equals(icons[0]) && st == 0) {
							if (button[num1][num2].getIcon().equals(icons[4])) {
								button[num1][num2].setIcon(icons[6]);
								sharks += 1;
							} else {
								button[num1][num2].setIcon(icons[7]);
								sharks += 1;
							}
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
	
	/**
	 * resets table
	 * @param go
	 */
	public void reset(int go) {
		st = 0;
		int seaWeedGen = 0;
		Random r = new Random();
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				seaWeedGen = r.nextInt(3);
				if(seaWeedGen == 1) {
					button[i][j].setIcon(icons[4]);
				}else {
					button[i][j].setIcon(icons[0]);
				}
			}
		}
		
		if (go == 1) {
			for (int s = 0; s < 15; s++) {
				int x = r.nextInt(15);
				int y = r.nextInt(15);
				button[x][y].setIcon(icons[5]);
				fish += 1;
			}
		} else {
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button.length; j++) {
					seaWeedGen = r.nextInt(3);
					if(seaWeedGen == 1) {
						button[i][j].setIcon(icons[4]);
					}else {
						button[i][j].setIcon(icons[0]);
					}
				}
			}

			for (int s = 0; s < 15; s++) {
				int x = r.nextInt(15);
				int y = r.nextInt(15);
				if (!button[x][y].getIcon().equals(icons[5])) {
					button[x][y].setIcon(icons[5]);
					fish += 1;
				} else {
					s -= 1;
				}

			}

		}
	}

}
