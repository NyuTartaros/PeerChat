package nyu.peerchat.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import nyu.peerchat.entity.Contact;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;

public class NamecardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609658759234297181L;
	private JScrollPane scrollPane;
	private JList contactList;
	private Vector<Contact> contacts = new Vector<Contact>();
	
	public NamecardPanel() {
		// TODO Auto-generated constructor stub
		setSize(250, 586);
		setBackground(new Color(221, 221, 222));
		setBorder(null);
		setLayout(null);
		
		//DEBUG
		contacts.add(new Contact("Desktop-Lab", "192.168.2.100"));
		contacts.add(new Contact("My Aliyun", "wiebo.net"));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 250, 586);
		scrollPane.setBackground(new Color(221, 221, 222));
		scrollPane.setBorder(null);
		add(scrollPane);
		
		contactList = new JList();
		contactList.setBounds(0, 0, 250, 586);
		contactList.setBackground(new Color(221, 221, 222));
		contactList.setBorder(null);
		scrollPane.add(contactList);
		
	}
	
	public void renderContactList(){
		contactList.setListData(contacts);
	}
	
	public void addContact(Contact contact){
		contacts.add(contact);
	}
	
}
