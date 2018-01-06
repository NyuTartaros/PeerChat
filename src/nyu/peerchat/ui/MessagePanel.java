package nyu.peerchat.ui;

import javax.swing.JPanel;

import nyu.peerchat.entity.Contact;
import nyu.peerchat.entity.Message;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MessagePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1956021459675259978L;
	
	private JPanel headPanel;
	private JLabel lblAlias;
	private JLabel lblIp;
	private JPanel sentMessagePanel;
	private JScrollPane sentMessageScrollPane;
	private MessageList messageList;
//	private JTextArea sentMessageTextArea;
	
	private Contact currentContact;

	public MessagePanel() {
		setBackground(new Color(245, 245, 245));
		setBounds(0, 0, 503, 400);
		setLayout(null);
		
		headPanel = new JPanel();
		headPanel.setBounds(0, 0, 503, 70);
		headPanel.setBackground(new Color(245, 245, 245));
		headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, 
				new Color(221, 221, 222)));
		headPanel.setLayout(null);
		add(headPanel);
		
		lblAlias = new JLabel("Alias");
		lblAlias.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		lblAlias.setBounds(25, 6, 468, 34);
		headPanel.add(lblAlias);
		
		lblIp = new JLabel("IP");
		lblIp.setBounds(25, 42, 328, 15);
		headPanel.add(lblIp);
		
		sentMessagePanel = new JPanel();
		sentMessagePanel.setBounds(0, 70, 503, 330);
		sentMessagePanel.setBackground(new Color(245, 245, 245));
		sentMessagePanel.setBorder(null);
		add(sentMessagePanel);
		sentMessagePanel.setLayout(null);
		
		sentMessageScrollPane = new JScrollPane();
		sentMessageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sentMessageScrollPane.setBounds(0, 0, 503, 330);
		sentMessageScrollPane.setBackground(new Color(245, 245, 245));
		sentMessageScrollPane.setBorder(null);
		sentMessagePanel.add(sentMessageScrollPane);
		
		messageList = new MessageList();
		messageList.setBounds(0, 0, 503, 330);
		messageList.setBackground(new Color(245, 245, 245));
		sentMessageScrollPane.setViewportView(messageList);
		
//		sentMessageTextArea = new JTextArea();
//		sentMessageTextArea.setEditable(false);
//		sentMessageTextArea.setWrapStyleWord(true);
//		sentMessageTextArea.setLineWrap(true);
//		sentMessageTextArea.setBounds(0, 0, 503, 330);
//		sentMessageTextArea.setBackground(new Color(245, 245, 245));
//		sentMessageScrollPane.setViewportView(sentMessageTextArea);
	}
	
	public void setCurrentContact(Contact currentContact){
		this.currentContact = currentContact;
		this.lblAlias.setText(this.currentContact.getAlias());
		this.lblIp.setText(this.currentContact.getIp());
	}
	
	public void setCurrentMessages(Vector<Message> messages){
		messageList.setMessages(messages);
	}
	
	public void newMessage(Message message) {
		messageList.newMessage(message);
	}
	
	public void selfMessage(String message) {
		Message tmp = new Message("me", message);
		messageList.newMessage(tmp);
	}
}
