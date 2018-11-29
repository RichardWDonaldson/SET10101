package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;

import model.Ambulance;
import model.Incident;
import model.Model;
import model.Request;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controller.Controller;

public class AmbulanceFinderView {
ArrayList<Ambulance> ambulance = new ArrayList<Ambulance>();
Controller controller = new Controller();
static Incident selectedIncident;
Model model = new Model();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AmbulanceFinderView window = new AmbulanceFinderView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
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
		
		System.out.println("Opening Ambulance Finder View");
		selectedIncident = incident;
		System.out.println(selectedIncident.toString());
		controller.initialize();
		ambulance = controller.getAmbulance();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JList<Object> list = new JList<Object>(ambulance.toArray());
		
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		frame.getContentPane().add(list, gbc_list);
		
		JButton btnNewButton = new JButton("Send Request");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Ambulance selectedAmbulance = (Ambulance) list.getSelectedValue();
	
				System.out.println(selectedAmbulance.toString() + "\n\n" + selectedIncident.toString());
				
				Request request = new Request(selectedAmbulance, selectedIncident);
				
				controller.addRequest(request);

				frame.dispose();
				
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
