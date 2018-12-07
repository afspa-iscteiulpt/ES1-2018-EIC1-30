package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mainApp.TwitterFeed;

import com.jgoodies.forms.layout.FormSpecs;



public class PublishTweetGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishTweetGUI window = new PublishTweetGUI();
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
	public PublishTweetGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Publish Tweet");
		frame.setBounds(100, 100, 710, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
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
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("692px"),},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("114px"),
				RowSpec.decode("114px"),
				RowSpec.decode("114px"),
				RowSpec.decode("114px"),}));
		
		
		
		JLabel lblNewLabel = new JLabel("Publish a tweet here!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel, "1, 2, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Escrever abaixo");
		panel.add(lblNewLabel_1, "1, 3, fill, fill");
		
		final JTextPane textPane = new JTextPane();
		JButton btnNewButton = new JButton("Publicar");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TwitterFeed.Post(textPane.getText());
				
			}
		});
		panel.add(textPane, "1, 4, fill, fill");
		panel.add(btnNewButton, "1, 5, fill, fill");
		frame.getContentPane().setLayout(groupLayout);
	}

}

