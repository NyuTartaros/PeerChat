package nyu.peerchat.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.FileHandler;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.xml.ws.Endpoint;

import nyu.peerchat.entity.Contact;
import nyu.peerchat.entity.Message;
import nyu.peerchat.serverServicesImpl.ServerChatServiceImpl;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainWindow {
	
	/**
	 * 基于P2P匿名通信的高仿微信
	 * @version 0.1-dev 
	 * @author NyuTartaros
	 */
	
	private static final int BUFFER_SIZE = 1024*1024*20;

	private JFrame mainFrame;
	private JSplitPane splitPane;
	private NamecardPanel namecardPanel;
	private ChatPanel chatPanel;
	private LeftPanel leftPanel;
	
	private String localIp;
	
	private Vector<Contact> contacts = new Vector<Contact>();
	private ArrayList<Vector<Message>> messagesList 
		= new ArrayList<Vector<Message>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException
				| InstantiationException
				| IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//DEBUG
		contacts.add(new Contact("Desktop-Lab", "192.168.2.100"));
		contacts.add(new Contact("Laptop-Nyu", "192.168.2.217"));
		contacts.add(new Contact("My Aliyun", "wiebo.net"));
		contacts.add(new Contact("隔壁小姐姐一号", "192.168.2.178"));
		contacts.add(new Contact("隔壁小姐姐二号", "192.168.1.197"));
		contacts.add(new Contact("隔壁小姐姐三号", "192.168.1.121"));
		contacts.add(new Contact("漂亮女老师", "192.168.1.203"));
		contacts.add(new Contact("校医院女护士", "192.168.1.243"));
		contacts.add(new Contact("对门情敌", "192.168.2.103"));
		contacts.add(new Contact("门卫大爷", "192.168.1.110"));
		
		try {
			localIp = getLocalIp();
			//DEBUG
			System.out.println("Chat server started at: " + localIp);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String address = "http://"+localIp+":8879/chat";
		Endpoint.publish(address, new ServerChatServiceImpl(this));
		
		mainFrame = new JFrame();
		mainFrame.setTitle("PeerChat");
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(".\\icons\\bubbles-alt-icon.png"));
		mainFrame.setResizable(false);
		mainFrame.setBounds(200,70,820,615);
//		frame.setLocationRelativeTo(null);
//		frame.setSize(820, 615);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setBackground(new Color(231, 229, 229));
		
		namecardPanel = new NamecardPanel(this);
		namecardPanel.setContacts(contacts);
		chatPanel = new ChatPanel(this);
		
		leftPanel = new LeftPanel(this);
		mainFrame.getContentPane().add(leftPanel);
		
		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBounds(60, 0, 754, 586);
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(250);
		splitPane.setLeftComponent(namecardPanel);
		splitPane.setRightComponent(chatPanel);
		splitPane.setBackground(new Color(231, 229, 229));
		splitPane.setBorder(null);
		SplitPaneUI ui = splitPane.getUI();    
		if (ui instanceof BasicSplitPaneUI) {    
		    ((BasicSplitPaneUI) ui).getDivider().setBorder(null);    
		}    
		mainFrame.getContentPane().add(splitPane);
	}
	
	public ChatPanel getChatPanel(){
		return chatPanel;
	}
	
	public NamecardPanel getNamecardPanel(){
		return namecardPanel;
	}
	
	public LeftPanel getLeftPanel(){
		return leftPanel;
	}
	
	public String getLocalIp() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();//获得本机IP  
	}
	
	public void newMessage(Message message) {
		int index = ipToIndex(message.getSender());
		Message tmp = message;
		tmp.setSender(contacts.get(index).getAlias());
		chatPanel.newMessage(tmp);
	}
	
	public int ipToIndex(String ip){
		//DEBUG
//		System.out.println("ipToIndex().ip: " + ip);
		for(int i=0; i<contacts.size(); i++){
			if(ip.equals(contacts.get(i).getIp())){
				return i;
			}
		}
		return -1;
	}
	
	public void receiveFile(String filename, DataHandler fileHandler) throws IOException {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setDialogTitle("接收文件");
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		//DEBUG
//		System.out.println("in MainWindow.receiveFile(), filename= " + filename);
		filechooser.setSelectedFile(new File(filename));
		//setFileSelectionMode()设置 JFileChooser，以允许用户只选择文件、只选择目录，或者可选择文件和目录。
		int result = filechooser.showSaveDialog(mainFrame);
		
		if(result == JFileChooser.CANCEL_OPTION){
        	return ;
		}
		File file = filechooser.getSelectedFile();
		//TODO 未能修复的BUG：filename.canWrite判断不正常
//		if(!filename.canWrite()) {
//			JOptionPane.showMessageDialog(mainFrame, "无法写入.");
//			return;
//		}

		InputStream in = fileHandler.getInputStream();
		OutputStream out = new FileOutputStream(file);
		byte[] buf = new byte[BUFFER_SIZE];
		int read;
		while( (read=in.read(buf))!=-1 ) {
			out.write(buf,0,read);
			out.flush();
		}
		in.close();
		out.close();
	}
	
}
