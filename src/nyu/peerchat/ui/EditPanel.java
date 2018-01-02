package nyu.peerchat.ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3066520925528180096L;
	private JScrollPane scrollPane;
	private JPanel sendBtnPanel;
	private JButton sendBtn;
	private JTextArea textArea;
	
	public EditPanel(){
		setBackground(Color.WHITE);
		setBounds(0, 0, 563, 185);
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
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 563, 145);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		textArea = new JTextArea();
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
		textArea.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setTabSize(4);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(0, 0, 563, 145);
		textArea.setBorder(null);
		scrollPane.setViewportView(textArea);
		
		sendBtnPanel = new JPanel();
		sendBtnPanel.setBackground(Color.WHITE);
		sendBtnPanel.setBounds(0, 145, 563, 40);
		sendBtnPanel.setLayout(null);
		sendBtnPanel.setBorder(null);
		add(sendBtnPanel);
		
		sendBtn = new JButton("\u53D1\u9001");
		sendBtn.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		sendBtn.setForeground(Color.GRAY);
		sendBtn.setBounds(472, 5, 65, 29);
		sendBtn.setBackground(new Color(245, 245, 245));
		sendBtnPanel.add(sendBtn);
		
	}
}
