package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import model.Hospital;
import model.Incident;
import model.Response;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class HospitalView {

	private JFrame frame;
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


	Hospital selectedHospital;
	Response selectedResponse;
	Incident selectedIncident;
	ArrayList<Response> responses = new ArrayList<Response>();
	ArrayList<Incident> incidents = new ArrayList<Incident>();
	DefaultListModel<Incident> model = new DefaultListModel<Incident>();
	
Controller controller = new Controller();
	/**
	 * Launch the application.
	 */	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalView window = new HospitalView();
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
	public HospitalView() throws IOException {
		controller.initialize();
		selectedHospital = controller.getCurrentHospital(100);
		responses = controller.getResponses(selectedHospital);
		initialize();

		//TODO Get incidents involved with patient
		//TODO get patient details
		//TODO Alter details
		//TODO Add details
		//TODO Change toString for Response
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{578, 0};
		gridBagLayout.rowHeights = new int[]{492, 243, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Pending Responses", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{457, 198, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		JList<Object> list_2 = new JList<Object>(responses.toArray());
		scrollPane.setViewportView(list_2);
		
		JButton btnSelectResponse = new JButton("Select Response");
		btnSelectResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
				selectedResponse = (Response) list_2.getSelectedValue();
				
				populateFields(selectedResponse);
				
				String id = selectedResponse.getRequest().getIncident().getPatient().getChiNumber();
				System.out.println("Selected ID " + id);
				
				int selectedID = Integer.parseInt(id);
				
				incidents = controller.getIncidents(selectedID);
				
			
				
				for (Incident incident: incidents) {
					model.addElement(incident);
				}
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnSelectResponse = new GridBagConstraints();
		gbc_btnSelectResponse.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectResponse.gridx = 1;
		gbc_btnSelectResponse.gridy = 0;
		panel_4.add(btnSelectResponse, gbc_btnSelectResponse);
		
		JButton btnRefresh = new JButton("Refresh");
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.gridx = 1;
		gbc_btnRefresh.gridy = 1;
		panel_4.add(btnRefresh, gbc_btnRefresh);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Personal Details", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("CHI");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtCHI = new JTextField();
		GridBagConstraints gbc_txtCHI = new GridBagConstraints();
		gbc_txtCHI.insets = new Insets(0, 0, 5, 5);
		gbc_txtCHI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCHI.gridx = 1;
		gbc_txtCHI.gridy = 1;
		panel.add(txtCHI, gbc_txtCHI);
		txtCHI.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("House Number");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 1;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtHouseNumber = new JTextField();
		GridBagConstraints gbc_txtHouseNumber = new GridBagConstraints();
		gbc_txtHouseNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtHouseNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHouseNumber.gridx = 3;
		gbc_txtHouseNumber.gridy = 1;
		panel.add(txtHouseNumber, gbc_txtHouseNumber);
		txtHouseNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 2;
		panel.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Line 1");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtLine1 = new JTextField();
		GridBagConstraints gbc_txtLine1 = new GridBagConstraints();
		gbc_txtLine1.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine1.gridx = 3;
		gbc_txtLine1.gridy = 2;
		panel.add(txtLine1, gbc_txtLine1);
		txtLine1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DOB");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtDOB = new JTextField();
		GridBagConstraints gbc_txtDOB = new GridBagConstraints();
		gbc_txtDOB.insets = new Insets(0, 0, 5, 5);
		gbc_txtDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDOB.gridx = 1;
		gbc_txtDOB.gridy = 3;
		panel.add(txtDOB, gbc_txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Line2");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 3;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		txtLine2 = new JTextField();
		GridBagConstraints gbc_txtLine2 = new GridBagConstraints();
		gbc_txtLine2.insets = new Insets(0, 0, 5, 0);
		gbc_txtLine2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLine2.gridx = 3;
		gbc_txtLine2.gridy = 3;
		panel.add(txtLine2, gbc_txtLine2);
		txtLine2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtGender = new JTextField();
		GridBagConstraints gbc_txtGender = new GridBagConstraints();
		gbc_txtGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGender.gridx = 1;
		gbc_txtGender.gridy = 4;
		panel.add(txtGender, gbc_txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Town");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 4;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtTown = new JTextField();
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 0);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 3;
		gbc_txtTown.gridy = 4;
		panel.add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone1");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtPhone1 = new JTextField();
		GridBagConstraints gbc_txtPhone1 = new GridBagConstraints();
		gbc_txtPhone1.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone1.gridx = 1;
		gbc_txtPhone1.gridy = 5;
		panel.add(txtPhone1, gbc_txtPhone1);
		txtPhone1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Postcode");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 5;
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtPostcode = new JTextField();
		GridBagConstraints gbc_txtPostcode = new GridBagConstraints();
		gbc_txtPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostcode.gridx = 3;
		gbc_txtPostcode.gridy = 5;
		panel.add(txtPostcode, gbc_txtPostcode);
		txtPostcode.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone2");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtPhone2 = new JTextField();
		GridBagConstraints gbc_txtPhone2 = new GridBagConstraints();
		gbc_txtPhone2.insets = new Insets(0, 0, 0, 5);
		gbc_txtPhone2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone2.gridx = 1;
		gbc_txtPhone2.gridy = 6;
		panel.add(txtPhone2, gbc_txtPhone2);
		txtPhone2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Incidents", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{286, 286, 1, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);
		
		JList<Incident> IncidentsList = new JList<Incident>(model);
		scrollPane_1.setViewportView(IncidentsList);
		
		JButton btnViewIncident = new JButton("View Details");
		btnViewIncident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				selectedIncident = (Incident) IncidentsList.getSelectedValue();
				
				IncidentView.NewScreen(selectedIncident, selectedResponse);
				
			}
		});
		GridBagConstraints gbc_btnViewIncident = new GridBagConstraints();
		gbc_btnViewIncident.insets = new Insets(0, 0, 0, 5);
		gbc_btnViewIncident.gridx = 1;
		gbc_btnViewIncident.gridy = 1;
		panel_2.add(btnViewIncident, gbc_btnViewIncident);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Medical notes", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 1;
		panel_3.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 3;
		panel_3.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 5;
		panel_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 7;
		panel_3.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnRequests = new JButton("Requests");
		btnRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//TODO Remove button - not needed anymore
			}
		});

		GridBagConstraints gbc_btnRequests = new GridBagConstraints();
		gbc_btnRequests.insets = new Insets(0, 0, 5, 5);
		gbc_btnRequests.gridx = 2;
		gbc_btnRequests.gridy = 1;
		panel_1.add(btnRequests, gbc_btnRequests);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 1;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridx = 8;
		gbc_btnUpdate.gridy = 1;
		panel_1.add(btnUpdate, gbc_btnUpdate);
	}
	
	public void clearFields() {
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
	
	public void populateFields(Response response) {
		
	txtCHI.setText(response.getRequest().getIncident().getPatient().getChiNumber());	
	txtName.setText(response.getRequest().getIncident().getPatient().getName());
	txtDOB.setText(response.getRequest().getIncident().getPatient().getDob());
	txtGender.setText(response.getRequest().getIncident().getPatient().getGender());
	txtPhone1.setText(response.getRequest().getIncident().getPatient().getPhone1());
	txtPhone2.setText(response.getRequest().getIncident().getPatient().getPhone2());
	txtHouseNumber.setText(response.getRequest().getIncident().getPatient().getHouseNumber());
	txtLine1.setText(response.getRequest().getIncident().getPatient().getLine1());
	txtLine2.setText(response.getRequest().getIncident().getPatient().getLine2());
	txtTown.setText(response.getRequest().getIncident().getPatient().getTown());
	txtPostcode.setText(response.getRequest().getIncident().getPatient().getPostcode());
	
	
	
		
	}
	

	
}
