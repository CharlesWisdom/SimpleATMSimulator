package com.sch.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ATM_UI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	static JFrame fDisplay;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField txtNumbers;
	private static JLabel lblInstructionInfo;
	private static JButton btnDeposit;
	private static JButton btnExit;
	private static JButton btnCheckBalance;
	private static JButton btnWithdraw;
	private static JButton btnEnter;
	private static JLabel lblWarning;
	private static Integer bankBalance = 2000;
	//private static String Currency = "ZMW";
	private static String PIN = "1234";
	
	public ATM_UI() {}
	

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		fDisplay = new JFrame("Simple ATM");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}



	/*
	 * setForeground(Color.RED); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * setBounds(100, 100, 459, 145);//setBounds(100, 100, 460, 252); contentPane =
	 * new JPanel(); contentPane.setBackground(new Color(0, 51, 102));
	 * contentPane.setForeground(Color.RED); contentPane.setBorder(new
	 * EmptyBorder(5, 5, 5, 5)); setContentPane(contentPane);
	 * contentPane.setLayout(null);
	 */
		
		ATM_UI atmInstance = new ATM_UI();
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		lblInstructionInfo = new JLabel("Please Enter Your PIN");
		//lblInstructionInfo.setForeground(new Color(255, 255, 255));
		lblInstructionInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInstructionInfo.setBounds(10, 11, 304, 23);
		contentPane.add(lblInstructionInfo);
		
		txtNumbers = new JTextField();
		txtNumbers.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		txtNumbers.setForeground(new Color(0, 0, 0));
		txtNumbers.setBounds(10, 33, 304, 34);
		contentPane.add(txtNumbers);
		txtNumbers.setColumns(10);
		
		btnDeposit = new JButton("Deposit");
		//btnDeposit.setForeground(new Color(255, 255, 255));
		btnDeposit.setBackground(new Color(0, 128, 128));
		btnDeposit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeposit.setBounds(10, 113, 138, 34);
		contentPane.add(btnDeposit);
		btnDeposit.setVisible(false);
		btnDeposit.addActionListener(atmInstance);
		
		btnExit = new JButton("Exit");
		//btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBackground(new Color(0, 128, 128));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(10, 168, 138, 34);
		contentPane.add(btnExit);
		btnExit.setVisible(false);
		btnExit.addActionListener(atmInstance);
		
		btnCheckBalance = new JButton("Check Balance");
		//btnCheckBalance.setForeground(new Color(255, 255, 255));
		btnCheckBalance.setBackground(new Color(0, 128, 128));
		btnCheckBalance.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCheckBalance.setBounds(179, 112, 138, 34);
		contentPane.add(btnCheckBalance);
		btnCheckBalance.setVisible(false);
		btnCheckBalance.addActionListener(atmInstance);
		
		btnWithdraw = new JButton("Withdraw");
		//btnWithdraw.setForeground(new Color(255, 255, 255));
		btnWithdraw.setBackground(new Color(0, 128, 128));
		btnWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnWithdraw.setBounds(179, 167, 138, 34);
		contentPane.add(btnWithdraw);
		btnWithdraw.setVisible(false);
		btnWithdraw.addActionListener(atmInstance);
		
		btnEnter = new JButton("Enter");
		//btnEnter.setForeground(new Color(255, 255, 255));
		btnEnter.setBackground(new Color(0, 128, 0));
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEnter.setBounds(324, 33, 110, 34);
		contentPane.add(btnEnter);
		btnEnter.addActionListener(atmInstance);
		
		lblWarning = new JLabel("Warning!");
		lblWarning.setForeground(new Color(255, 51, 0));
		lblWarning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblWarning.setBounds(32, 78, 249, 24);
		contentPane.add(lblWarning);
		lblWarning.setVisible(false);
		
		fDisplay.add(contentPane);
		fDisplay.setSize(460, 145);
		fDisplay.show();
	
}
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			
			if( s.contains("Enter")){
				if(btnCheckBalance.isVisible() == false && btnWithdraw.isVisible() == false && btnDeposit.isVisible() == false && btnExit.isVisible() == false) {
					if(txtNumbers.getText().matches(PIN))
					{
						lblWarning.setForeground(new Color(0, 0, 0));
						lblWarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
						lblWarning.setText("Please Select Your Operation:");
						
						fDisplay.setSize(460, 252);
						fDisplay.show();
						
						btnCheckBalance.setVisible(true);
						btnDeposit.setVisible(true);
						btnWithdraw.setVisible(true);
						btnExit.setVisible(true);
						
						lblInstructionInfo.setVisible(false);
						txtNumbers.setText("");
						txtNumbers.setEnabled(false);
						btnEnter.setEnabled(false);
					}else
					{
						lblWarning.setText("Wrong PIN! Please Try Again");
						lblWarning.setVisible(true);
					}
				}
				
				//Withdraw action
				if(btnCheckBalance.isEnabled() == false  && btnDeposit.isEnabled() == false  && btnExit.isEnabled() == false ) {
					
					Integer withdrawAmount;
					
					try {
						withdrawAmount = Integer.parseInt(txtNumbers.getText());
						if(bankBalance < withdrawAmount) {
							lblWarning.setForeground(new Color(255, 51, 0));
							lblWarning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
							lblWarning.setText("Insufficient Funds! Your Balance Is: ZMW " + bankBalance.toString());
							lblWarning.setVisible(true);
						}else {
							bankBalance = bankBalance - withdrawAmount;
						}
					}catch(Exception ex) {
						System.err.println(ex.getMessage());
						
						lblWarning.setForeground(new Color(255, 51, 0));
						lblWarning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblWarning.setText("Invalid Amount, Please Enter Numbers Only");
						lblWarning.setVisible(true);
					}	
					
					btnCheckBalance.setEnabled(true);
					btnDeposit.setEnabled(true);
					btnWithdraw.setEnabled(true);
					btnExit.setEnabled(true);					
				}
				
				//Deposit action
				if(btnCheckBalance.isEnabled() == false && btnWithdraw.isEnabled() == false && btnExit.isEnabled() == false) {
					
					Integer DepositAmount;
					
					try {
						DepositAmount = Integer.parseInt(txtNumbers.getText());
						bankBalance = bankBalance + DepositAmount;
					}catch(Exception ex) {
						System.err.println(ex.getMessage());
						
						lblWarning.setForeground(new Color(255, 51, 0));
						lblWarning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
						lblWarning.setText("Invalid Amount, Please Enter Numbers Only");
						lblWarning.setVisible(true);
					}
					
					btnCheckBalance.setEnabled(true);
					btnDeposit.setEnabled(true);
					btnWithdraw.setEnabled(true);
					btnExit.setEnabled(true);					
				}

			}else if( s.contains("Withdraw")){
				btnCheckBalance.setEnabled(false);
				btnDeposit.setEnabled(false);
				btnExit.setEnabled(false);
				
				lblInstructionInfo.setVisible(true);
				lblInstructionInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblInstructionInfo.setText("Please Enter Withdraw Amount:");
				txtNumbers.setText("");
				//txtNumbers.setFocusable(true);
				txtNumbers.setEditable(true);
				txtNumbers.setEnabled(true);
				btnEnter.setEnabled(true);				
				
			}else if( s.contains("Check Balance")) {
				
				//Check Balance action
				btnDeposit.setEnabled(true);
				btnWithdraw.setEnabled(true);
				btnExit.setEnabled(true);				
				
				lblWarning.setForeground(new Color(0, 0, 0));
				lblWarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblWarning.setText("Please Select Your Operation:");
				
				lblInstructionInfo.setVisible(true);
				lblInstructionInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblInstructionInfo.setText("Your Bank Balance Is:");
				
				txtNumbers.setEnabled(true);
				//txtNumbers.setFocusable(true);
				txtNumbers.setText("ZMW " + bankBalance.toString());
				txtNumbers.setEditable(false);
				
				btnEnter.setEnabled(false);				
				
			}else if( s.contains("Deposit")) {
				
				btnCheckBalance.setEnabled(false);
				btnWithdraw.setEnabled(false);
				btnExit.setEnabled(false);
			
				lblInstructionInfo.setVisible(true);
				lblInstructionInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblInstructionInfo.setText("Please Enter Deposit Amount");
				txtNumbers.setText("");
				//txtNumbers.setCursor(getCursor());
				txtNumbers.setEditable(true);
				txtNumbers.setEnabled(true);
				btnEnter.setEnabled(true);				
				
			}else if( s.contains("Exit")) {
				btnCheckBalance.setEnabled(true);
				btnDeposit.setEnabled(true);
				btnWithdraw.setEnabled(true);
				btnExit.setEnabled(true);
				
				btnCheckBalance.setVisible(false);
				btnDeposit.setVisible(false);
				btnWithdraw.setVisible(false);
				btnExit.setVisible(false);
				
				lblInstructionInfo.setVisible(true);
				lblInstructionInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblInstructionInfo.setText("Please Enter Your PIN");
				txtNumbers.setText("");
				txtNumbers.setEnabled(true);
				txtNumbers.setEditable(true);
				//txtNumbers.setCursor(getCursor());
				btnEnter.setEnabled(true);
				
				lblWarning.setForeground(new Color(255, 51, 0));
				lblWarning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
				lblWarning.setText("");
				lblWarning.setVisible(false);
				
				fDisplay.setSize(460, 145);
				fDisplay.show();								
			}
			
			
		
		}
	
}
