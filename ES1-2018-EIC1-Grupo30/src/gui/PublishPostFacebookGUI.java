package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class PublishPostFacebookGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishPostFacebookGUI window = new PublishPostFacebookGUI();
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
	public PublishPostFacebookGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Publish Facebook Post");
		frame.setBounds(100, 100, 710, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[57px][558px,grow][52px]", "[22px][22px][][grow][]"));
		
		JLabel lblSendTo = new JLabel("Send To:");
		panel.add(lblSendTo, "cell 0 0,alignx left,aligny center");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,alignx right,aligny top");
		textField.setColumns(50);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
		);
		
		JLabel lblSubject = new JLabel("Subject: ");
		panel.add(lblSubject, "cell 0 1,alignx left,aligny center");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 1,alignx left,aligny top");
		textField_1.setColumns(50);
		
		JLabel lblMessage = new JLabel("Message:");
		panel.add(lblMessage, "cell 0 3");
		
		JTextPane textPane = new JTextPane();
		panel.add(textPane, "cell 1 3,grow");
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton, "cell 1 4,alignx right");
		frame.getContentPane().setLayout(groupLayout);
	}

}
