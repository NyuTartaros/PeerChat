package nyu.peerchat.serverServices;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlMimeType;

@WebService  
@SOAPBinding(style = SOAPBinding.Style.RPC)  
public interface ServerChatService {
	
	@WebMethod
	public boolean sendMessage(@WebParam(name="message") String message);
	
	@WebMethod
	public boolean sendFile(@WebParam(name="filename") String filename
			, @XmlMimeType("*/*") @WebParam(name="fileData") DataHandler fileData);

}
