package nyu.peerchat.serverServicesImpl;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

import nyu.peerchat.serverServices.ServerChatService;

@javax.xml.ws.soap.MTOM
@WebService(endpointInterface="nyu.peerchat.serverServices.ServerChatService")
public class ServerChatServiceImpl implements ServerChatService {
	
	private String message;
	private DataHandler fileData;

	@Override
	public boolean sendMessage(@WebParam(name="message") String message) {
		// TODO Auto-generated method stub
		this.message = message;
		//DEBUG
		System.out.println(message);
		return true;
	}

	@Override
	public boolean sendFile(@XmlMimeType("*/*")
	@WebParam(name="fileData") DataHandler fileData) {
		// TODO Auto-generated method stub
		this.fileData = fileData;
		return true;
	}

}
