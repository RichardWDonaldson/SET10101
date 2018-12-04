package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;

import controller.Controller;
import model.Hospital;
import model.Login;
import model.Request;
import model.Response;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PDAView {

	private JFrame frame;
	private Controller controller = new Controller();
	private JTextField txtCHI;
	private JTextField txtHouseNumber;
	private JTextField txtName;
	private JTextField txtDOB;
	private JTextField txtGender;
	private JTextField txtPhone1;
	private JTextField txtPhone2;
	private JTextField txtLine1;
	private JTextField txtLine2;
	private JTextField txtTown;
	private JTextField txtPostcode;
	ArrayList<Request> requests = new ArrayList<Request>();
	ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
	Request selectedRequest;

	/**
	 * Launch the application.
	 */
	
	public static void NewScreen(Login login) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDAView window = new PDAView(login);
					window.frame.setVisible(true);
					//Controller.initialize();
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
	public PDAView(Login login) throws IOException {
	//	System.out.println(login.toString());
		Controller controller = new Controller();
		controller.initialize();
		requests = controller.getRequests(login);
		hospitals = controller.getHospitals();
		
//		for(Request r: requests) {
//			System.out.println(r.toString());
//			
//		}
		
		
		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 2;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 1;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel Panel = new JPanel();
		tabbedPane.addTab("Personal details", null, Panel, null);
		GridBagLayout gbl_Panel = new GridBagLayout();
		gbl_Panel.columnWidths = new int[]{60, 0, 0, 286, 0};
		gbl_Panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Panel.setLayout(gbl_Panel);
		
		JLabel lblNewLabel = new JLabel("CHI");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		Panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtCHI = new JTextField();
		txtCHI.setEditable(false);
		GridBagConstraints gbc_txtCHI = new GridBagConstraints();
		gbc_txtCHI.insets = new Insets(0, 0, 5, 5);
		gbc_txtCHI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCHI.gridx = 1;
		gbc_txtCHI.gridy = 0;
		Panel.add(txtCHI, gbc_txtCHI);
		txtCHI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("House Number");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		Panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtHouseNumber = new JTextField();
		txtHouseNumber.setEditable(false);
		GridBagConstraints gbc_txtHouseNumber = new GridBagConstraints();
		gbc_txtHouseNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtHouseNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHouseNumber.gridx = 3;
		gbc_txtHouseNumber.gridy = 0;
		Panel.add(txtHouseNumber, gbc_txtHouseNumber);
		txtHouseNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		Panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		Panel.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Line 1");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 1;
		Panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtLine1 = new JTextField();
		txtLine1.setEditable(false);
		GridBagConstraints gbc_txtLine1 = new GridBagConstraints();
		gbc_txtLine1.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine1.gridx = 3;
		gbc_txtLine1.gridy = 1;
		Panel.add(txtLine1, gbc_txtLine1);
		txtLine1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DOB");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		Panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtDOB = new JTextField();
		txtDOB.setEditable(false);
		GridBagConstraints gbc_txtDOB = new GridBagConstraints();
		gbc_txtDOB.insets = new Insets(0, 0, 5, 5);
		gbc_txtDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDOB.gridx = 1;
		gbc_txtDOB.gridy = 2;
		Panel.add(txtDOB, gbc_txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Line 2");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		Panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtLine2 = new JTextField();
		txtLine2.setEditable(false);
		GridBagConstraints gbc_txtLine2 = new GridBagConstraints();
		gbc_txtLine2.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine2.gridx = 3;
		gbc_txtLine2.gridy = 2;
		Panel.add(txtLine2, gbc_txtLine2);
		txtLine2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		Panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtGender = new JTextField();
		txtGender.setEditable(false);
		GridBagConstraints gbc_txtGender = new GridBagConstraints();
		gbc_txtGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGender.gridx = 1;
		gbc_txtGender.gridy = 3;
		Panel.add(txtGender, gbc_txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Town");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 3;
		Panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		txtTown = new JTextField();
		txtTown.setEditable(false);
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 0);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 3;
		gbc_txtTown.gridy = 3;
		Panel.add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone1");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		Panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtPhone1 = new JTextField();
		txtPhone1.setEditable(false);
		GridBagConstraints gbc_txtPhone1 = new GridBagConstraints();
		gbc_txtPhone1.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone1.gridx = 1;
		gbc_txtPhone1.gridy = 4;
		Panel.add(txtPhone1, gbc_txtPhone1);
		txtPhone1.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Postcode");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 4;
		Panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtPostcode = new JTextField();
		txtPostcode.setEditable(false);
		GridBagConstraints gbc_txtPostcode = new GridBagConstraints();
		gbc_txtPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostcode.gridx = 3;
		gbc_txtPostcode.gridy = 4;
		Panel.add(txtPostcode, gbc_txtPostcode);
		txtPostcode.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Phone2");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 5;
		Panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtPhone2 = new JTextField();
		txtPhone2.setEditable(false);
		GridBagConstraints gbc_txtPhone2 = new GridBagConstraints();
		gbc_txtPhone2.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone2.gridx = 1;
		gbc_txtPhone2.gridy = 5;
		Panel.add(txtPhone2, gbc_txtPhone2);
		txtPhone2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Incident Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridwidth = 4;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		Panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{60, 0, 0, 286, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JTextArea txtAIncident = new JTextArea();
		txtAIncident.setEditable(false);
		//TODO FIX THIS
	//	txtAIncident.setText(selectedRequest.getIncident().getNotes());
		GridBagConstraints gbc_txtAIncident = new GridBagConstraints();
		gbc_txtAIncident.fill = GridBagConstraints.BOTH;
		gbc_txtAIncident.gridwidth = 4;
		gbc_txtAIncident.insets = new Insets(0, 0, 0, 5);
		gbc_txtAIncident.gridx = 0;
		gbc_txtAIncident.gridy = 0;
		panel_3.add(txtAIncident, gbc_txtAIncident);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Response", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_1.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextArea txtAResponce = new JTextArea();
		GridBagConstraints gbc_txtAResponce = new GridBagConstraints();
		gbc_txtAResponce.fill = GridBagConstraints.BOTH;
		gbc_txtAResponce.gridx = 0;
		gbc_txtAResponce.gridy = 0;
		panel.add(txtAResponce, gbc_txtAResponce);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Hospital", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		
		JList<Object> listHospital = new JList<Object>(hospitals.toArray());
		GridBagConstraints gbc_listHospital = new GridBagConstraints();
		gbc_listHospital.fill = GridBagConstraints.BOTH;
		gbc_listHospital.gridx = 0;
		gbc_listHospital.gridy = 0;
		panel_4.add(listHospital, gbc_listHospital);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Pending Requests", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_5.add(scrollPane, gbc_scrollPane);
		//populate List
		JList<Object> listRequests = new JList<Object>(requests.toArray());
		scrollPane.setViewportView(listRequests);
		
		JButton btnNewButton = new JButton("Select Incident");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Ambulance selectedAmbulance = (Ambulance) list.getSelectedValue();
			
			selectedRequest = (Request) listRequests.getSelectedValue();	
				
			//System.out.println("Selected Request" + selectedRequest.toString());
			
			
			populateFields(selectedRequest);
				
			
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit Responce");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String strResponse = txtAResponce.getText();
				
				Hospital selectedHospital = (Hospital) listHospital.getSelectedValue();
				
				
				//create responce and then send to the nearest Hospital
				
				//Request, notes, hospital
				Response response = new Response(selectedRequest, strResponse, selectedHospital);
				System.out.println("Response created");
		//		System.out.println("This is the responce" + response.toString());	
				
				//Change addResponse to Boolean to test for success
				controller.addResponce(response);
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
	}
	
	public void populateFields(Request request) {
		
		txtCHI.setText(request.getIncident().getPatient().getChiNumber());
		txtName.setText(request.getIncident().getPatient().getName());
		txtDOB.setText(request.getIncident().getPatient().getDob());
		txtGender.setText(request.getIncident().getPatient().getGender());
		txtPhone1.setText(request.getIncident().getPatient().getPhone1());
		txtPhone2.setText(request.getIncident().getPatient().getPhone2());
		txtHouseNumber.setText(request.getIncident().getPatient().getHouseNumber());
		txtLine1.setText(request.getIncident().getPatient().getLine1());
		txtLine2.setText(request.getIncident().getPatient().getLine2());
		txtTown.setText(request.getIncident().getPatient().getTown());
		txtPostcode.setText(request.getIncident().getPatient().getPostcode());
		
	
		
		
		
	}
	
	
	

}
