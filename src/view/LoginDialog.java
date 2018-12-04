package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9112440214382519601L;
	private JFrame frame;
	private JTextField txtDriverID;
	private JTextField txtSupportID;
	private JTextField txtAmbulanceID;
	Login login;
	boolean dialogOpen;
	/**
	 * Launch the application.
	 * @return 
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog window = new LoginDialog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginDialog() {

		initialize();
		pack();
		dialogOpen = true;
		setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(getPreferredSize().width * 2, getPreferredSize().height * 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, -3, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Ambulance ID");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtAmbulanceID = new JTextField();
		GridBagConstraints gbc_txtAmbulanceID = new GridBagConstraints();
		gbc_txtAmbulanceID.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmbulanceID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmbulanceID.gridx = 1;
		gbc_txtAmbulanceID.gridy = 1;
		getContentPane().add(txtAmbulanceID, gbc_txtAmbulanceID);
		txtAmbulanceID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Driver ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtDriverID = new JTextField();
		GridBagConstraints gbc_txtDriverID = new GridBagConstraints();
		gbc_txtDriverID.gridwidth = 3;
		gbc_txtDriverID.insets = new Insets(0, 0, 5, 5);
		gbc_txtDriverID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDriverID.gridx = 1;
		gbc_txtDriverID.gridy = 3;
		getContentPane().add(txtDriverID, gbc_txtDriverID);
		txtDriverID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Support ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtSupportID = new JTextField();
		GridBagConstraints gbc_txtSupportID = new GridBagConstraints();
		gbc_txtSupportID.gridwidth = 3;
		gbc_txtSupportID.insets = new Insets(0, 0, 5, 5);
		gbc_txtSupportID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSupportID.gridx = 1;
		gbc_txtSupportID.gridy = 5;
		getContentPane().add(txtSupportID, gbc_txtSupportID);
		txtSupportID.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogOpen = false;
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			//Login button
			public void actionPerformed(ActionEvent e) {
				
				String ambulanceID = txtAmbulanceID.getText();
		//		System.out.println("ambulance is " + ambulanceID);
				String driverID = txtDriverID.getText();
		//		System.out.println("driver is " + driverID);
				String supportID = txtSupportID.getText();
		//		System.out.println("support is " + supportID);
				
				login = new Login(ambulanceID, driverID,supportID);
				if(login != null) {
					System.out.println("login created");
				dialogOpen = false;	
				PDAView.NewScreen(login);
				dispose();
				}
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

	
	public Login getLogin() {
		return login;
	}
	
	
	
	
}
