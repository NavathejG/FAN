package com.fan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.GridLayout;
import javax.swing.JSplitPane;

public class FanUI {
	private static JTextArea textArea;
	
	public static void main(String[] args) {
		setSystemLookFeel();
        JFrame frame = new JFrame("Fan Control Panel");
        frame.setBounds(0, 0, 800, 400);

        JPanel jpan = new JPanel();
        frame.getContentPane().add(jpan, BorderLayout.CENTER);
        GridBagLayout gbl_jpan = new GridBagLayout();
        gbl_jpan.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_jpan.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_jpan.columnWeights = new double[]{0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_jpan.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        jpan.setLayout(gbl_jpan);
        
        textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(false);
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.gridheight = 5;
        gbc_textArea.gridwidth = 18;
        gbc_textArea.insets = new Insets(0, 0, 5, 0);
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 1;
        gbc_textArea.gridy = 2;
        jpan.add(textArea, gbc_textArea);
        
        JButton btnSpeedCord = new JButton("Speed Cord");
        GridBagConstraints gbc_btnSpeedCord = new GridBagConstraints();
        gbc_btnSpeedCord.insets = new Insets(0, 0, 5, 5);
        gbc_btnSpeedCord.gridx = 9;
        gbc_btnSpeedCord.gridy = 7;
        jpan.add(btnSpeedCord, gbc_btnSpeedCord);
        
        JButton btnDirectionCord = new JButton("Direction Cord");
        GridBagConstraints gbc_btnDirectionCord = new GridBagConstraints();
        gbc_btnDirectionCord.insets = new Insets(0, 0, 5, 5);
        gbc_btnDirectionCord.gridx = 14;
        gbc_btnDirectionCord.gridy = 7;
        jpan.add(btnDirectionCord, gbc_btnDirectionCord);
        
        FanOperations fanOper = new FanOperations();
        btnSpeedCord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		btnSpeedCord.setEnabled(false);
        		fanOper.changeSpeed();
        		if(fanOper.getSpeed() == 0 ) {
        			textArea.setText("Fan is off,  \n" + "Direction set to " + fanOper.getCurrentDirection() );
        		}else {
        			textArea.setText("Speed = Speed " + fanOper.getSpeed() + " \n" + "Direction = " + fanOper.getCurrentDirection() );
        		}
        		btnSpeedCord.setEnabled(true);
        	}
        });
        
        btnDirectionCord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		btnDirectionCord.setEnabled(false);
        		fanOper.changeDirection();
        		if(fanOper.getSpeed() == 0 ) {
        			textArea.setText("Fan is off,  \n" + "Direction set to " + fanOper.getCurrentDirection() );
        		}else {
        			textArea.setText("Speed = Speed " + fanOper.getSpeed() + " \n" + "Direction = " + fanOper.getCurrentDirection() );
        		}
        		btnDirectionCord.setEnabled(true);
        	}
        });
        textArea.setText("Fan is off,  \n" + "Direction set to " + fanOper.getCurrentDirection() );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);	}
	private static void setSystemLookFeel() {
        String laf = UIManager.getSystemLookAndFeelClassName();
        try
        {
            UIManager.setLookAndFeel(laf);
        }
        catch (UnsupportedLookAndFeelException exc )
        {
            System.err.println("Unsupported: " + laf);
        }
        catch (Exception exc)
        {
            System.err.println("Error loading " + laf);
        }
    }
}
