package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class ReadEmailsGUI {

	private JFrame frame;
	private JTextField textFieldTo;
	private JTextField textFieldSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadEmailsGUI window = new ReadEmailsGUI();
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
	public ReadEmailsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 685, 399);
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		TextArea textArea = new TextArea();
		panel1.add(textArea, BorderLayout.EAST);
		
		List list = new List();
		panel1.add(list, BorderLayout.CENTER);
		
		Panel panel2 = new Panel();
		panel1.add(panel2, BorderLayout.NORTH);
		
		JLabel label1 = new JLabel("Selecione o email \u00E0 esquerda e leia o email \u00E0 direita");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel2.add(label1);
		
		JPanel panel3 = new JPanel();
		panel1.add(panel3, BorderLayout.SOUTH);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		
		JPanel panel4 = new JPanel();
		panel3.add(panel4);
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel LabelTo = new JLabel("From: ");
		panel4.add(LabelTo);
		
		textFieldTo = new JTextField();
		panel4.add(textFieldTo);
		textFieldTo.setColumns(20);
		
		JPanel panel5 = new JPanel();
		panel3.add(panel5);
		
		JLabel LabelSubject = new JLabel("Subject: ");
		panel5.add(LabelSubject);
		
		textFieldSubject = new JTextField();
		panel5.add(textFieldSubject);
		textFieldSubject.setColumns(20);
		
		JLabel lblNewLabel = new JLabel("Message: ");
		lblNewLabel.setBounds(33, 408, 59, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(93, 408, 556, 54);
		frame.getContentPane().add(textPane);
	}
}
