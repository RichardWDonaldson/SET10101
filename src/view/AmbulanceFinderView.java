package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Ambulance;
import model.Incident;
import model.Request;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controller.Controller;
import javax.swing.JScrollPane;
import java.awt.Font;

public class AmbulanceFinderView {
ArrayList<Ambulance> ambulance = new ArrayList<Ambulance>();
Controller controller = new Controller();
static Incident selectedIncident;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(Incident incident) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
									
					AmbulanceFinderView window = new AmbulanceFinderView(incident);
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
	public AmbulanceFinderView(Incident incident) throws IOException {
		
	//	System.out.println("Opening Ambulance Finder View");
		selectedIncident = incident;
	//	System.out.println(selectedIncident.toString());
//		Boolean databaseSuccess =	controller.initialize();
//		if(!databaseSuccess) {
//			JOptionPane.showMessageDialog(frame, "Database Error - Could not connect to Database", "Critical Error", 0);
//		}
		ambulance = controller.getAmbulance();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JList<Object> list = new JList<Object>(ambulance.toArray());
		list.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(10);
		
		JButton btnNewButton = new JButton("Send Request");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Ambulance selectedAmbulance = (Ambulance) list.getSelectedValue();
	
				if(selectedAmbulance == null) {
					JOptionPane.showMessageDialog(frame, "No Ambulance Selected", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					Request request = new Request(selectedAmbulance, selectedIncident);
					
					boolean requestSuccess	= controller.addRequest(request);
					
					if(requestSuccess) {
						JOptionPane.showMessageDialog(frame, "Request submitted", "KwikMedical", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Error in Request, please try again", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
					
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
