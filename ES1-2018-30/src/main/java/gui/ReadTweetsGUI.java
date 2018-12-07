package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import mainApp.TwitterFeed;

public class ReadTweetsGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadTweetsGUI window = new ReadTweetsGUI();
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
	public ReadTweetsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 685, 399);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		TextArea textArea = new TextArea();
		panel.add(textArea, BorderLayout.EAST);
		 
		
		
//		for (Status status : Feed.ReadTimeline()) {
//
//			if (status.getUser().getName() != null) {
//				String name=status.getUser().getName();
//				String text=status.getText();
//				statusesText.add(text);
//				//				System.out.println(name + ":" + text);
//				counter++;
//
//
//
//			}
//			
//			counterTotal++;
//
//		}
		TwitterFeed myFeed = new TwitterFeed();


//		List<Status> statuses = new ArrayList<Status>();
//		for(int i=0; i< myFeed.ReadTimeline().size();i++){
//			statuses.add( myFeed.ReadTimeline().get(i));
//			
//		}
		
		DefaultListModel<Set<String>> model = new DefaultListModel<Set<String>>();
				
		for(int i=0; i< TwitterFeed.ReadTimeline().size();i++){
			model.addElement( (Set<String>) TwitterFeed.ReadTimeline().get(i));
			
		}
		JList<Set<String>> statuslist=new JList<Set<String>>(model);;


		panel.add(statuslist, BorderLayout.CENTER);
		
		Panel panel_1 = new Panel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblSelecioneOTweet = new JLabel("Selecione o post \u00E0 esquerda e leia-o \u00E0 direita");
		lblSelecioneOTweet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblSelecioneOTweet);
	}

}
