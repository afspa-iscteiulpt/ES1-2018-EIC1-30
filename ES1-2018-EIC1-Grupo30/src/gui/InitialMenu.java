package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InitialMenu {
	
	private JFrame frame;
	private JPanel optionsPanel;
	
	public InitialMenu() {
		buildGUI();
	}
	
	public void buildGUI() {
		frame= new JFrame("GUI");
		frame.setLayout(new BorderLayout());
		
		addPanels();
		addOptionsPanelElements();
		frame.setSize(400, 100);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void addPanels() {
		optionsPanel = new JPanel();
		optionsPanel.setLayout(new FlowLayout());
		frame.add(optionsPanel, BorderLayout.NORTH);
	}
	
	private void addOptionsPanelElements() {
		emailButton();
		twitterButton();
		facebookButton();
	}
	
	private void emailButton() {
		JButton mail = new JButton("Mail");
		optionsPanel.add(mail);
		/*searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						
					}
				});
			}
		});*/
	}
	
	private void twitterButton() {
		JButton twitter = new JButton("Twitter");
		optionsPanel.add(twitter);
		/*searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						
					}
				});
			}
		});*/
	}
	
	private void facebookButton() {
		JButton facebook = new JButton("Facebook");
		optionsPanel.add(facebook);
		/*searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						
					}
				});
			}
		});*/
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new InitialMenu();
			}
		});
	}
}
