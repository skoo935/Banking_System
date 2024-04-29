package gui.Teller;

import javax.swing.*;

import main.BankAccount;
import main.TellerGUIClient;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class TellerUserAccount {
	JButton button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;
	JLabel label;
	JFrame frame;
	JPanel panel = null;
	JPanel panel2 = null;
	public TellerGUIClient client;
	boolean AccIn = false;

	public static void main(String[] args) {
		TellerUserAccount tellerUser = new TellerUserAccount();
		tellerUser.run();
	}

	public TellerGUIClient getClient() {
		return this.client;
	}

	public void run() {
		frame = new JFrame("Teller(User)");
		Container contentPane = frame.getContentPane(); 
		contentPane.setLayout(new FlowLayout());
		
		button = new JButton("Create Account");
		button2 = new JButton("Delete Account");
		button3 = new JButton("Add User");
		button4 = new JButton("Delete User");
		button5 = new JButton("Back");
		button6 = new JButton("Forget Password");
		button7 = new JButton("Change PIN");
		button8 = new JButton("Transfer Admin");
		button9 = new JButton("Withdraw");
		button10 = new JButton("Deposit");
		button11 = new JButton("Transfer");

		JPanel panel = new JPanel();
		/*
		 * Placeholder Comment for Acc list of user to go into textArea
		 */
		JTextArea textArea = new JTextArea("test");
		contentPane.add(textArea);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 4));
		panel2.add(button);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(button7);
		panel2.add(button8);
		panel2.add(button9);
		panel2.add(button10);
		panel2.add(button11);

		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, panel2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});

		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code here
			}
		});
	}
}