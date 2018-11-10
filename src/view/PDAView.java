package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PDAView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PDAView window = new PDAView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDAView window = new PDAView();
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
	 */
	public PDAView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
