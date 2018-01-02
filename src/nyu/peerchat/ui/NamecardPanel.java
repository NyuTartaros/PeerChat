package nyu.peerchat.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import nyu.peerchat.entity.Contact;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JList;

public class NamecardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609658759234297181L;
	private JScrollPane scrollPane;
	private JList list;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public NamecardPanel() {
		// TODO Auto-generated constructor stub
		setSize(250, 586);
		setBackground(new Color(221, 221, 222));
		setBorder(null);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 250, 586);
		scrollPane.setBackground(new Color(221, 221, 222));
		scrollPane.setBorder(null);
		add(scrollPane);
		
		list = new JList();
		list.setBounds(0, 0, 250, 586);
		list.setBackground(new Color(221, 221, 222));
		list.setBorder(null);
		scrollPane.add(list);
		
	}
}
