package nyu.peerchat.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import nyu.peerchat.entity.Contact;

public class ContactListCellRender extends JLabel implements ListCellRenderer {
	public ContactListCellRender() {
	}
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,  
			   int index, boolean isSelected, boolean cellHasFocus) {
		String alias = ((Contact)value).getAlias();
		String ip = ((Contact)value).getIp();
		setText("<html><body>" + "  " + alias + "<br>" + "  " + ip + "<body></html>");
//		setSize(60, 250);
		setBackground(new Color(221, 221, 222));
		setVisible(true);
		return this;
	}
	
}
