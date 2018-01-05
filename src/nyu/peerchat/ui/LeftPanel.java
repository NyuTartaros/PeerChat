package nyu.peerchat.ui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LeftPanel extends JPanel {
	
	private JToolBar toolBar;
	private JButton chatBtn;
	private JButton contactsBtn;
	private MainWindow mainWindow;
	private JButton headBtn;
	private JLabel lblEmpty;
	
	public LeftPanel(MainWindow mainWindow){
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
		
		headBtn = new JButton("");
		ImageIcon icon = new ImageIcon("./icons/peachHead.jpg");
		icon.setImage(icon.getImage().getScaledInstance(40, 38, Image.SCALE_DEFAULT));
		headBtn.setIcon(icon);
		headBtn.setBackground(new Color(42, 43, 46));
		headBtn.setSize(40,38);
		headBtn.setBorder(null);
		toolBar.add(headBtn);
		
		lblEmpty = new JLabel(" ");
		toolBar.add(lblEmpty);
		
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
