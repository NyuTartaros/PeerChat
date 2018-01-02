package nyu.peerchat.ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class ChatPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6761468676397466048L;
	private JSplitPane splitPane;
	private MessagePanel messagePanel;
	private EditPanel editPanel;
	
	public ChatPanel() {
		setBounds(0, 0, 563, 586);
		setLayout(null);
		setBorder(null);
		
		messagePanel = new MessagePanel();
		editPanel = new EditPanel();
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 563, 586);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(400);
		splitPane.setLeftComponent(messagePanel);
		splitPane.setRightComponent(editPanel);
		splitPane.setBackground(new Color(245, 245, 245));
		splitPane.setBorder(null);
		SplitPaneUI ui = splitPane.getUI();    
		if (ui instanceof BasicSplitPaneUI) {    
		    ((BasicSplitPaneUI) ui).getDivider().setBorder(null);    
		}   
		add(splitPane);
	}
}
