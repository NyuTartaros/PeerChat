package nyu.peerchat.ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class LeftPanel extends JPanel {
	
	private JToolBar toolBar;
	private JButton chatBtn;
	private JButton contactsBtn;
	private Object mainWindow;
	
	public LeftPanel(Object mainWindow){
		this.mainWindow = mainWindow;
		setSize(60,586);
		setBackground(new Color(42, 43, 46));
		setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 10, 40, 408);
		toolBar.setBackground(new Color(42, 43, 46));
		add(toolBar);
		
		chatBtn = new JButton("");
		chatBtn.setIcon(new ImageIcon(".\\icons\\chat.png"));
		chatBtn.setBackground(new Color(42, 43, 46));
		chatBtn.setSize(40, 38);
		toolBar.add(chatBtn);
		
		contactsBtn = new JButton("");
		contactsBtn.setIcon(new ImageIcon(".\\icons\\contacts.png"));
		contactsBtn.setBackground(new Color(42, 43, 46));
		contactsBtn.setSize(40, 38);
		toolBar.add(contactsBtn);
	}
}
