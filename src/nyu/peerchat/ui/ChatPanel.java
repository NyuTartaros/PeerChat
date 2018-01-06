package nyu.peerchat.ui;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import nyu.peerchat.clientServices.ClientChatService;
import nyu.peerchat.entity.Contact;

public class ChatPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6761468676397466048L;
	private JSplitPane splitPane;
	private MessagePanel messagePanel;
	private EditPanel editPanel;
	private MainWindow mainWindow;
	
	private Contact currentContact;
	private ClientChatService clientChatService;
	
	public ChatPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		setBounds(0, 0, 503, 586);
		setLayout(null);
		setBorder(null);
		
		messagePanel = new MessagePanel();
		editPanel = new EditPanel();
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 503, 586);
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
	
	public Contact getCurrentContact(){
		return currentContact;
	}
	
	public void setCurrentContact(Contact currentContact){
		this.currentContact = currentContact;
		messagePanel.setCurrentContact(currentContact);
		editPanel.setCurrentContact(currentContact);
		setClientChatServices(currentContact);
	}
	
	public void setClientChatServices(Contact currentContact){
		String ip = currentContact.getIp();
		URL url;
		try {
			url = new URL("http://"+ip+":8879/chat?wsdl");
			QName sName = new QName("http://serverServicesImpl.peerchat.nyu/"
					, "ServerChatServiceImplService");
			Service service = Service.create(url, sName);
			QName pName = new QName("http://serverServicesImpl.peerchat.nyu/"
					, "ServerChatServiceImplPort");
			this.clientChatService = service.getPort(pName
					, ClientChatService.class);
			editPanel.setClientChatServices(clientChatService);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setClientChatServices(ClientChatService clientChatService){
		this.clientChatService = clientChatService;
	}
	
	public void newMessage(String message) {
		messagePanel.newMessage(message);
	}
	
}
