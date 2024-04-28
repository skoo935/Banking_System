package gui.ATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Map;
import java.util.Vector;

import main.*;
import message.*;


public class MainPage {
	JFrame frame = null;
	JPanel southPanel = null;
	JPanel centerPanel = null;
	JPanel eastPanel = null;

	Vector<String> entries = null;
	boolean show = true;
	boolean AccIn = false;
	
	public static ATMGUIClient client;
	public static AccountSelection accsel;
	
	public MainPage(ATMGUIClient client, AccountSelection accsel, boolean AccIn){
		this.client = client;
		this.accsel = accsel;
		this.AccIn = AccIn;
		
		this.accsel.setMainPage(this);
	}
	
	public static ATMGUIClient getClient() {
		return client;
	}
	
	public static AccountSelection getAccSel() {
		return accsel;
	}
	
	public void go() {
		// create new frame
		frame = new JFrame("ATM MainPage");
		
		// create new panel
		southPanel = new JPanel();
		centerPanel = new JPanel();
		eastPanel = new JPanel();

		JButton showButton = new JButton("Show");
		eastPanel.setLayout(new FlowLayout());
		eastPanel.add(showButton);
		
		if(AccIn == false){
			getClient().getAccountsInfo();
			AccIn = true;
		}
		Map<Integer, BankAccount> accounts = getClient().getAccounts();
		String acc = "Bank Account Infomation:\n" + accounts + "\nSelect a command\n";
		JTextArea textArea = new JTextArea(acc);
		centerPanel.add(textArea);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		// Add components to panel
		createUIView();
		
		// add components to frame
		frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
		frame.getContentPane().add(BorderLayout.EAST, eastPanel);
		
		// show frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void createUIView() {
		
		// create JButtons
		JButton WithdrawButton = new JButton("Withdraw");
		JButton depositButton = new JButton("Deposit");
		JButton transferButton = new JButton("Transfer");
		JButton logoutButton = new JButton("Logout");
		// add to south panel
		southPanel.add(WithdrawButton);
		southPanel.add(depositButton);
		southPanel.add(transferButton);
		southPanel.add(logoutButton);
		
		WithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String operation = "withdraw";
				frame.setVisible(false);
				getAccSel().go(operation);
			}
		});
		
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String operation = "deposit";
				frame.setVisible(false);
				getAccSel().go(operation);
			}
		});
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String operation = "transfer";
				frame.setVisible(false);
				getAccSel().go(operation);
			}
		});
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				String status = getClient().logoutRequest();
				if (status == "SUCCESS") {
					AccountSelection AS = new AccountSelection(getClient());
				MainPage MP = new MainPage(getClient(), AS, false);
				ATMLogin AL = new ATMLogin(getClient(), MP);
				AL.createWindow();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invaild ID or password. Try again");
				}
				
			}
		});
		
	}

	
	class showButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(show == false) {
				entries.clear();
				String[] input = {"alpha", 
						"beta", 
						"gamma", "sigma", "phi", "omega"};
				
				for (String s : input) {
					entries.add(s);
				}; // end of for
				frame.repaint();
				show = true;
			} // end of if
			else {
				entries.clear();
				entries.add("A");
				entries.add("B");
				entries.add("G");
				entries.add("S");
				entries.add("P");
				entries.add("W");
				frame.repaint();
				show = false;
			} // end of else
			
		} // end of action
	} // end of show
}
