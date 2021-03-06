package nyu.peerchat.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import nyu.peerchat.entity.Contact;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NamecardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609658759234297181L;
	private JScrollPane scrollPane;
	private JList contactList;
	private Vector<Contact> contacts = new Vector<Contact>();
	private MainWindow mainWindow;
	
	public NamecardPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		// TODO Auto-generated constructor stub
		setSize(250, 586);
		setBackground(new Color(221, 221, 222));
		setBorder(null);
		setLayout(null);
		
//		//DEBUG
//		contacts.add(new Contact("Desktop-Lab", "192.168.2.100"));
//		contacts.add(new Contact("Laptop-Nyu", "10.170.13.77"));
////		contacts.add(new Contact("My Aliyun", "wiebo.net"));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 250, 586);
		scrollPane.setBackground(new Color(221, 221, 222));
		scrollPane.setBorder(null);
		add(scrollPane);
		
		contactList = new JList();
		contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contactList.setBounds(0, 0, 250, 586);
		contactList.setBackground(new Color(221, 221, 222));
		contactList.setBorder(null);
		contactList.setCellRenderer(new ContactListCellRender());
		contactList.setListData(contacts);
		contactList.setFixedCellHeight(60);
		contactList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int index = contactList.getSelectedIndex();
				Contact contact = (Contact) contactList.getModel().getElementAt(index);
				mainWindow.getChatPanel().setCurrentContact(contact);
			}
		});
//		contactList.ensureIndexIsVisible(contacts.size()-1);
		scrollPane.setViewportView(contactList);
		
	}
	
	public void renderContactList(){
		contactList.setListData(contacts);
	}
	
	public void setContacts(Vector<Contact> contacts){
		this.contacts = contacts;
		renderContactList();
	}
	
	public void addContact(Contact contact){
		contacts.add(contact);
		renderContactList();
	}
	
}
