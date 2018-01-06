package nyu.peerchat.ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import nyu.peerchat.entity.Message;

public class MessageList extends JList {
	
}

class MessageListCellRender extends JLabel implements ListCellRenderer{
	
	@Override
	public  Dimension getPreferredSize() {
		Dimension size = super.getPreferredSize();
		String message = this.getText();
		double height = size.getHeight();
		double width = size.getWidth();
		int lineNum = 1 + (int)Math.ceil(message.length()/28);
		height += lineNum*18;
		return size;
	};

	@Override
	public Component getListCellRendererComponent(JList list, Object value
			, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		String sender = ((Message)value).getSender();
		String message = ((Message)value).getMessage();
		message = "<html>" + sender +":<br>" + message + "</html>";
		if( sender.equals("me")){
			setText(message);
			setIcon(new ImageIcon("./icons/peachHead-icon.png"));
			setHorizontalTextPosition(SwingConstants.LEFT);
			setHorizontalAlignment(SwingConstants.RIGHT);
		}else{
			setText(message);
			setIcon(new ImageIcon("./icons/contacts (1) icon.png"));
			setHorizontalTextPosition(SwingConstants.RIGHT);
			setHorizontalAlignment(SwingConstants.LEFT);
		}
		return null;
	}
	
}
