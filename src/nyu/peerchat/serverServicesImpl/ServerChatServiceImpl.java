package nyu.peerchat.serverServicesImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.developer.JAXWSProperties;

import nyu.peerchat.entity.Message;

//import com.sun.net.httpserver.HttpExchange;
//import com.sun.xml.internal.ws.developer.JAXWSProperties;

import nyu.peerchat.serverServices.ServerChatService;
import nyu.peerchat.ui.MainWindow;

@javax.xml.ws.soap.MTOM
@WebService(endpointInterface="nyu.peerchat.serverServices.ServerChatService")
public class ServerChatServiceImpl implements ServerChatService {
	
	private String message;
	private DataHandler fileData;
	
	private MainWindow mainWindow;
	
	@Resource
	private WebServiceContext wsContext;
	
	public ServerChatServiceImpl(MainWindow mainWindow) {
		// TODO Auto-generated constructor stub
		this.mainWindow = mainWindow;
	}

	@Override
	public boolean sendMessage(@WebParam(name="message") String message) {
		// TODO Auto-generated method stub
		this.message = message;
		//DEBUG
//		System.out.println(message);
		String ip = getClientIP();
		mainWindow.newMessage(new Message(ip, message));
		return true;
	}

	@Override
	public boolean sendFile(@WebParam(name="filename") String filename, @XmlMimeType("*/*")
	@WebParam(name="fileData") DataHandler fileData) {
		// TODO Auto-generated method stub
		this.fileData = fileData;
		//DEBUG
		System.out.println("in ServerChatServiceImpl.sendFile(), filename= " + filename);
		try {
			mainWindow.receiveFile(filename, fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private String getClientIP(){
		try {
			MessageContext mc = wsContext.getMessageContext();
			HttpExchange exchange = (HttpExchange) mc
					.get(JAXWSProperties.HTTP_EXCHANGE);
			InetSocketAddress isa = exchange.getRemoteAddress();
			//DEBUG
//			System.out.println("InetSocketAddress : " + isa);
//			System.out.println("Hostname : "
//					+ isa.getAddress().getHostAddress() + " address: "
//					+ isa.getAddress().getHostName());
			return isa.getAddress().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
