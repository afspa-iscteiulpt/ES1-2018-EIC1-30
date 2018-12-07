package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

/**
 * This class constructs the GUI to the initial Menu of the program
 * 
 * @author Grupo 30 ES1 2018/19 ISCTE
 *
 */

public class InitialMenu {
	
	/**
	 * JFrame object	
	 */
	private JFrame frame;
	/**
	 * JPanel object	
	 */
	private JPanel optionsPanel;
	
	/**
	 * Basic constructor that runs the method buildGUI()
	 */
	public InitialMenu() {
		buildGUI();
	}
	
	
	/**
	 * Method that inicializes a frame and sets it's layout and size.
	 * It runs as well the methods addPanels() and addOptionsPanelElements();
	 */
	public void buildGUI() {
		frame= new JFrame("Menu Inicial");
		frame.getContentPane().setLayout(new BorderLayout());
		
		addPanels();
		addOptionsPanelElements();
		frame.setSize(498, 117);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Method that inicializes a JPanel and sets it's layout.
	 * It adds the content to the panels and then adds the panels to the frame.
	 */
	private void addPanels() {
		optionsPanel = new JPanel();
		optionsPanel.setLayout(new FlowLayout());
		frame.getContentPane().add(optionsPanel, BorderLayout.NORTH);
		{
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout());
			{
				JLabel Label2 = new JLabel("Ler:  ");
				panel.add(Label2);
			}
			{
				JButton btnMail = new JButton("Mail");
				panel.add(btnMail);
			}
			{
				JButton btnTwitter = new JButton("Twitter");
				panel.add(btnTwitter);
			}
			{
				JButton btnFacebook = new JButton("Facebook");
				panel.add(btnFacebook);
			}
		}
	}
	
	/**
	 * Method that runs the methods: emailButton(), twitterButton(), facebookButton()
	 */
	private void addOptionsPanelElements() {
		emailButton();
		twitterButton();
		facebookButton();
	}
	
	/**
	 * Method that creates the email button and adds it to the optionsPanel
	 */
	private void emailButton() {
		{
			JLabel Label1 = new JLabel("Publicar ou Enviar:  ");
			optionsPanel.add(Label1);
		}
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
	
	/**
	 * Method that creates the twitter button and adds it to the optionsPanel
	 */
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
	
	/**
	 * Method that creates the facebook button and adds it to the optionsPanel
	 */
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
	
	/**
	 * The main method initializes the InitialMenu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new InitialMenu();
			}
		});
	}
}
