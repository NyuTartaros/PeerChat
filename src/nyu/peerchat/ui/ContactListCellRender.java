package nyu.peerchat.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
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
		setText("<html><body>" + alias + "<br>" + ip + "<body></html>");
		ImageIcon icon = new ImageIcon("./icons/contacts (1).png");
		icon.setImage(icon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		setIcon(icon);
		setBackground(new Color(221, 221, 222));
		setVisible(true);
		return this;
	}
	
}
