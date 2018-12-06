package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.Incident;
import model.Patient;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;


public class OperatorView {

	private JFrame frame;
	private JTextField txtCHI;
	private JTextField txtName;
	private JTextField txtDOB;
	private JTextField txtGender;
	private JTextField txtHouseNumber;
	private JTextField txtLine1;
	private JTextField txtLine2;
	private JTextField txtTown;
	private JTextField txtPostcode;
	private JTextField txtPhone1;
	private JTextField txtPhone2;
	private JTextField txtDate;
	
	String lastCrawlDate = "2018-12-07";
	Controller controller = new Controller();
	Date utilDate;
	java.sql.Date sqlDate;
	Patient selectedPatient;

	/**
	 * Launch the application.
	 */
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorView window = new OperatorView();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		
			});
		
	}
	
	

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public OperatorView() throws IOException {
		
//	Boolean databaseSuccess =	controller.initialize();
//	if(!databaseSuccess) {
//		JOptionPane.showMessageDialog(frame, "Database Error - Could not connect to Database", "Critical Error", 0);
//	}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 355);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{245, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridwidth = 3;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Patient Information", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_3.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("CHI");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		txtCHI = new JTextField();
		GridBagConstraints gbc_txtCHI = new GridBagConstraints();
		gbc_txtCHI.insets = new Insets(0, 0, 5, 0);
		gbc_txtCHI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCHI.gridx = 1;
		gbc_txtCHI.gridy = 0;
		panel_2.add(txtCHI, gbc_txtCHI);
		txtCHI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panel_2.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DOB");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtDOB = new JTextField();
		GridBagConstraints gbc_txtDOB = new GridBagConstraints();
		gbc_txtDOB.insets = new Insets(0, 0, 5, 0);
		gbc_txtDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDOB.gridx = 1;
		gbc_txtDOB.gridy = 2;
		panel_2.add(txtDOB, gbc_txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtGender = new JTextField();
		GridBagConstraints gbc_txtGender = new GridBagConstraints();
		gbc_txtGender.insets = new Insets(0, 0, 5, 0);
		gbc_txtGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGender.gridx = 1;
		gbc_txtGender.gridy = 3;
		panel_2.add(txtGender, gbc_txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Phone 1");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 4;
		panel_2.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtPhone1 = new JTextField();
		GridBagConstraints gbc_txtPhone1 = new GridBagConstraints();
		gbc_txtPhone1.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone1.gridx = 1;
		gbc_txtPhone1.gridy = 4;
		panel_2.add(txtPhone1, gbc_txtPhone1);
		txtPhone1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Phone 2");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 5;
		panel_2.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtPhone2 = new JTextField();
		GridBagConstraints gbc_txtPhone2 = new GridBagConstraints();
		gbc_txtPhone2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone2.gridx = 1;
		gbc_txtPhone2.gridy = 5;
		panel_2.add(txtPhone2, gbc_txtPhone2);
		txtPhone2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 2;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 0;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_5.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("House/Flat Number");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtHouseNumber = new JTextField();
		GridBagConstraints gbc_txtHouseNumber = new GridBagConstraints();
		gbc_txtHouseNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtHouseNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHouseNumber.gridx = 1;
		gbc_txtHouseNumber.gridy = 0;
		panel_4.add(txtHouseNumber, gbc_txtHouseNumber);
		txtHouseNumber.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Line 1");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtLine1 = new JTextField();
		GridBagConstraints gbc_txtLine1 = new GridBagConstraints();
		gbc_txtLine1.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine1.gridx = 1;
		gbc_txtLine1.gridy = 1;
		panel_4.add(txtLine1, gbc_txtLine1);
		txtLine1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Line 2");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtLine2 = new JTextField();
		GridBagConstraints gbc_txtLine2 = new GridBagConstraints();
		gbc_txtLine2.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine2.gridx = 1;
		gbc_txtLine2.gridy = 2;
		panel_4.add(txtLine2, gbc_txtLine2);
		txtLine2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Town");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 3;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtTown = new JTextField();
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 0);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 1;
		gbc_txtTown.gridy = 3;
		panel_4.add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Postcode");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 4;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		txtPostcode = new JTextField();
		GridBagConstraints gbc_txtPostcode = new GridBagConstraints();
		gbc_txtPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostcode.gridx = 1;
		gbc_txtPostcode.gridy = 4;
		panel_4.add(txtPostcode, gbc_txtPostcode);
		txtPostcode.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Incident Details", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 0;
		panel_1.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 0};
		gbl_panel_13.rowHeights = new int[]{0, 0};
		gbl_panel_13.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_13.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_13.setLayout(gbl_panel_13);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 0;
		panel_13.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel lblNewLabel_14 = new JLabel("Date");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 0;
		panel_10.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		txtDate = new JTextField();
		GridBagConstraints gbc_txtDate = new GridBagConstraints();
		gbc_txtDate.insets = new Insets(0, 0, 5, 0);
		gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDate.gridx = 1;
		gbc_txtDate.gridy = 0;
		panel_10.add(txtDate, gbc_txtDate);
		txtDate.setColumns(10);
		
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		} 
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
		
		
		txtDate.setText(sqlDate.toString());
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 1;
		panel_1.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{0, 0};
		gbl_panel_12.rowHeights = new int[]{0, 0};
		gbl_panel_12.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		panel_12.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0, 0};
		gbl_panel_11.rowHeights = new int[]{0, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JTextArea txtANotes = new JTextArea();
		GridBagConstraints gbc_txtANotes = new GridBagConstraints();
		gbc_txtANotes.gridwidth = 2;
		gbc_txtANotes.fill = GridBagConstraints.BOTH;
		gbc_txtANotes.gridx = 0;
		gbc_txtANotes.gridy = 0;
		panel_11.add(txtANotes, gbc_txtANotes);
		
		JButton btnRegister = new JButton("Register Patient");
		btnRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			Patient patient = getPatientInput();
			
			if(patient == null) {
				JOptionPane.showMessageDialog(frame, "Please check inputted information", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				Boolean Success = controller.addPatient(patient);
				
					if(Success == true) {
						selectedPatient = patient;
					} else {
					JOptionPane.showMessageDialog(null, "Error in patient Registration", "Input Error", 0);
					}
				
				}
			
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 0;
		gbc_btnRegister.gridy = 1;
		frame.getContentPane().add(btnRegister, gbc_btnRegister);
		
		JButton btnIncident = new JButton("Submit Incident");
		btnIncident.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				String notes = txtANotes.getText();
				if(notes.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No incident notes added", "Input Error", 0);
				return;

				} else if (selectedPatient == null) {
					JOptionPane.showMessageDialog(frame, "No patient has been selected", "Input Error", 0);
					return;
				}
				
				
				else {
					
					int size = (controller.getSize() + 1);
						
					Incident incident = new Incident(size, selectedPatient, sqlDate, notes);
			
				boolean success = controller.addIncident(incident);
					if(success) { 
						AmbulanceFinderView.NewScreen(incident);
						clearView();		
						txtANotes.setText("");
						JOptionPane.showMessageDialog(frame,"Incident Created", "KwikMedical", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, "Error adding Incident" + "\n" + "Please try again", "Input Error", JOptionPane.WARNING_MESSAGE);
					}
					
					
				}
				
					
			}
		});
		
		JButton btnSearch = new JButton("Patient Search");
		btnSearch.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent arg0) {
				String chi = txtCHI.getText();
				
				if ( (chi.isEmpty()) || (!chi.matches("[0-9]+")) || (chi.length() > 10) ) {
					JOptionPane.showMessageDialog(frame, "Invalid CHI Number, please re-enter", "Input Error", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					
					selectedPatient = controller.findPatient(chi);
					
					if(selectedPatient == null) {
						int result = JOptionPane.showConfirmDialog(frame, "Do you wish to Register a New User?", "No Patient Found", 0);
						if(result == JOptionPane.YES_OPTION) {

						} else {
							//Do Nothing
						}
					
					} else {
						
						populateFields(selectedPatient);
		
					}
					
				}
 	
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 1;
		frame.getContentPane().add(btnSearch, gbc_btnSearch);
		GridBagConstraints gbc_btnIncident = new GridBagConstraints();
		gbc_btnIncident.gridx = 2;
		gbc_btnIncident.gridy = 1;
		frame.getContentPane().add(btnIncident, gbc_btnIncident);
	}
	

	
	public void populateFields(Patient patient) {
		
		txtName.setText(patient.getName());
		txtDOB.setText(patient.getDob());
		txtGender.setText(patient.getGender());
		txtPhone1.setText(patient.getPhone1());
		txtPhone2.setText(patient.getPhone2());
		txtHouseNumber.setText(patient.getHouseNumber());
		txtLine1.setText(patient.getLine1());
		txtLine2.setText(patient.getLine2());
		txtTown.setText(patient.getTown());
		txtPostcode.setText(patient.getPostcode());
		
	}
	
	public Patient getPatientInput() {
		String chi = txtCHI.getText();
		String name = txtName.getText();
		String dob = txtDOB.getText();
		String gender = txtGender.getText();
		String phone1 = txtPhone1.getText();
		String phone2 = txtPhone2.getText();
		String houseNumber = txtHouseNumber.getText();
		String line1 = txtLine1.getText();
		String line2 = txtLine2.getText();
		String town = txtTown.getText();
		String postcode = txtPostcode.getText();
		
		
		if(name.toLowerCase().matches(".*\\d+.*")) {
			//error
		} else if((gender.toLowerCase() != "male") || (gender.toLowerCase() != "female") ) {
			//error
		} else if(town.toLowerCase().matches(".*\\d+.*")) {
			//error
		} else if((line1.toLowerCase().matches(".*\\d+.*")) || line2.toLowerCase().matches(".*\\d+.*")) {
			//error
		} else {
			Patient patient = new Patient(chi, name,dob , gender, phone1, phone2, houseNumber, line1, line2, town, postcode );	
			
			return patient;
			
		}
		
		return null;
		//TODO Add data validation with Regex

		
	}
	
	public void clearView() {
		txtCHI.setText("");
		txtName.setText("");
		txtDOB.setText("");
		txtGender.setText("");
		txtPhone1.setText("");
		txtPhone2.setText("");
		txtHouseNumber.setText("");
		txtLine1.setText("");
		txtLine2.setText("");
		txtTown.setText("");
		txtPostcode.setText("");
				
	}

}
