package nyu.peerchat.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class MainWindow {
	
	/**
	 * 基于P2P匿名通信的高仿微信
	 * @version 0.1-dev 
	 * @author NyuTartaros
	 */

	private JFrame mainFrame;
	private JSplitPane splitPane;
	private NamecardPanel namecardPanel;
	private ChatPanel chatPanel;
	private LeftPanel leftPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setBounds(200,70,820,615);
//		frame.setLocationRelativeTo(null);
//		frame.setSize(820, 615);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setBackground(new Color(231, 229, 229));
		
		namecardPanel = new NamecardPanel(mainFrame);
		chatPanel = new ChatPanel(mainFrame);
		
		leftPanel = new LeftPanel(mainFrame);
		mainFrame.getContentPane().add(leftPanel);
		
		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBounds(60, 0, 754, 586);
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(250);
		splitPane.setLeftComponent(namecardPanel);
		splitPane.setRightComponent(chatPanel);
		splitPane.setBackground(new Color(231, 229, 229));
		splitPane.setBorder(null);
		SplitPaneUI ui = splitPane.getUI();    
		if (ui instanceof BasicSplitPaneUI) {    
		    ((BasicSplitPaneUI) ui).getDivider().setBorder(null);    
		}    
		mainFrame.getContentPane().add(splitPane);
	}
}
