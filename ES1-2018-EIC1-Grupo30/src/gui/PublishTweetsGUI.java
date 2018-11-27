package gui;

import java.awt.EventQueue;
import java.awt.Font;
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

import net.miginfocom.swing.MigLayout;

public class PublishTweetsGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishTweetsGUI window = new PublishTweetsGUI();
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
	public PublishTweetsGUI() {
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
		panel.setLayout(new MigLayout("", "[57px][558px,grow][52px]", "[22px][22px][][grow][]"));
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
		
		JButton btnNewButton = new JButton("Publicar");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Publish a tweet here!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Escrever abaixo");
		panel.add(lblNewLabel_1, "cell 1 2,alignx center");
		
		JTextPane textPane = new JTextPane();
		panel.add(textPane, "cell 1 3,grow");
		panel.add(btnNewButton, "cell 1 4,alignx right");
		frame.getContentPane().setLayout(groupLayout);
	}

}
