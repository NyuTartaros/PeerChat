package nyu.peerchat.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import nyu.peerchat.entity.Message;

public class MessageList extends JList {
	
	private Vector<Message> messages = new Vector<Message>();
	
	public MessageList(){
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setCellRenderer(new MessageListCellRender());
		setBorder(null);
		setFixedCellHeight(50);
	}
	
	public void setMessages(Vector<Message> messages){
		this.messages = messages;
		setListData(messages);
		ensureIndexIsVisible(messages.size());
	}
	
	public void newMessage(Message message){
		messages.add(message);
		setListData(messages);
		//DEBUG
//		System.out.println("messages.size(): " + messages.size());
//		for(int i=0; i<messages.size(); i++){
//			System.out.println("sender: " + messages.get(i).getSender());
//			System.out.println("message: " + messages.get(i).getMessage());
//		}
		ensureIndexIsVisible(messages.size()-1);
	}
	
}

class MessageListCellRender extends JLabel implements ListCellRenderer{
	
	@Override
	public  Dimension getPreferredSize() {
		Dimension size = super.getPreferredSize();
		String message = this.getText();
		double height = 60;
		double width = size.getWidth();
		int lineNum = 1 + (int)Math.ceil(message.length()/28);
		height += lineNum*18;
		return size;
	};

	//TODO 实现自动换行
	//http://blog.csdn.net/zhhtao89/article/details/50179695
	//http://blog.csdn.net/jinlanhai/article/details/46783329
	@Override
	public Component getListCellRendererComponent(JList list, Object value
			, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		String sender = ((Message)value).getSender();
		String message = ((Message)value).getMessage();
		message = "<html>" + message + "</html>";
		int iconTextGap = 16;
		setFont(new Font(".黑体-日本语", 0, 15));
		if( sender.equals("me")){
			setText(message);
			setIcon(new ImageIcon("./icons/peachHead-icon.png"));
			setHorizontalTextPosition(SwingConstants.LEFT);
			setHorizontalAlignment(SwingConstants.RIGHT);
			setIconTextGap(iconTextGap);
		}else{
			setText(message);
			setIcon(new ImageIcon("./icons/contacts (1) icon.png"));
			setHorizontalTextPosition(SwingConstants.RIGHT);
			setHorizontalAlignment(SwingConstants.LEFT);
			setIconTextGap(iconTextGap);
		}
		return this;
	}
	
}
