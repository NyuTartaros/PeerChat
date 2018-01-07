package nyu.peerchat.ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


import java.io.File;

import nyu.peerchat.clientServices.ClientChatService;
import nyu.peerchat.entity.Contact;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3066520925528180096L;
	private JScrollPane scrollPane;
	private JPanel sendBtnPanel;
	private JButton sendBtn;
	private JTextArea textArea;
	private JToolBar chatToolBar;
	private JButton fileBtn;
	
	private ClientChatService clientChatService;
	private MessagePanel messagePanel;
	
	private Contact currentContact;
	
	public EditPanel(MessagePanel messagePanel){
		this.messagePanel = messagePanel;
		setBackground(Color.WHITE);
		setBounds(0, 0, 503, 185);
		setBorder(null);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				scrollPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				scrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		chatToolBar = new JToolBar();
		chatToolBar.setEnabled(false);
		chatToolBar.setFloatable(false);
		chatToolBar.setBounds(0, 0, 503, 35);
		chatToolBar.setBackground(Color.WHITE);
		add(chatToolBar);
		
		fileBtn = new JButton("");
		fileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser("发送文件");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(messagePanel);
				if(result == JFileChooser.CANCEL_OPTION) {
					return;
				}
				File filename = fileChooser.getSelectedFile();
				if(filename.canRead()) {
					clientChatService.sendFile(new DataHandler(new FileDataSource(filename)));
				}else {
					JOptionPane.showMessageDialog(messagePanel, "文件无法打开。");
				}
			}
		});
		ImageIcon fileBtnIcon = new ImageIcon(".\\icons\\folder.png");
//		fileBtnIcon.setImage(fileBtnIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		fileBtn.setIcon(fileBtnIcon);
		fileBtn.setBackground(Color.WHITE);
		chatToolBar.add(fileBtn);
		
		scrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 35, 503, 110);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
					sendMessage(textArea.getText());
				}
			}
		});
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textArea.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		textArea.setFont(new Font("宋体", Font.PLAIN, 13));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setTabSize(4);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(0, 0, 503, 145);
		textArea.setBorder(null);
		scrollPane.setViewportView(textArea);
		
		sendBtnPanel = new JPanel();
		sendBtnPanel.setBackground(Color.WHITE);
		sendBtnPanel.setBounds(0, 145, 503, 40);
		sendBtnPanel.setLayout(null);
		sendBtnPanel.setBorder(null);
		add(sendBtnPanel);
		
		sendBtn = new JButton("\u53D1\u9001");
		sendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sendMessage(textArea.getText());
			}
		});
		sendBtn.setFont(new Font("宋体", Font.PLAIN, 13));
		sendBtn.setForeground(Color.GRAY);
		sendBtn.setBounds(412, 5, 65, 29);
		sendBtn.setBackground(new Color(245, 245, 245));
		sendBtnPanel.add(sendBtn);
		
	}
	
	public void setCurrentContact(Contact currentContact){
		this.currentContact = currentContact;
	}
	
	public void setClientChatServices(ClientChatService clientChatService){
		this.clientChatService = clientChatService;
	}
	
	private void sendMessage(String message) {
		clientChatService.sendMessage(textArea.getText());
		messagePanel.selfMessage(textArea.getText());
		textArea.setText("");
	}
}
