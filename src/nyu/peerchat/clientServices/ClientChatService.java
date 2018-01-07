package nyu.peerchat.clientServices;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService(targetNamespace = "http://serverServices.peerchat.nyu/")  
public interface ClientChatService {
	
	@WebMethod
	public boolean sendMessage(@WebParam(name="message") String message);
	
	@WebMethod
	public boolean sendFile(@WebParam(name="filename") String filename, @XmlMimeType("*/*")
	@WebParam(name="fileData") DataHandler fileData);
	
}
