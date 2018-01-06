package nyu.peerchat.ui;

import javax.swing.JPanel;

import nyu.peerchat.entity.Contact;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	private JTextArea sentMessageTextArea;
	
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
		sentMessageScrollPane.setBounds(0, 0, 503, 330);
		sentMessageScrollPane.setBackground(new Color(245, 245, 245));
		sentMessageScrollPane.setBorder(null);
		sentMessagePanel.add(sentMessageScrollPane);
		
		sentMessageTextArea = new JTextArea();
		sentMessageTextArea.setWrapStyleWord(true);
		sentMessageTextArea.setLineWrap(true);
		sentMessageTextArea.setBounds(0, 0, 503, 330);
		sentMessageTextArea.setBackground(new Color(245, 245, 245));
		sentMessageScrollPane.setViewportView(sentMessageTextArea);
	}
	
	public void setCurrentContact(Contact currentContact){
		this.currentContact = currentContact;
		this.lblAlias.setText(this.currentContact.getAlias());
		this.lblIp.setText(this.currentContact.getIp());
	}
	
	public void newMessage(String message) {
		String ms = sentMessageTextArea.getText();
		String nowMessage = ms + currentContact.getAlias() + ":\n\r    " + message + "\n\r\n";
		sentMessageTextArea.setText(nowMessage);
	}
	
	public void selfMessage(String message) {
		String ms = sentMessageTextArea.getText();
		String nowMessage = ms + "me:\n\r    " + message + "\n\r\n";
		sentMessageTextArea.setText(nowMessage);
	}
}
