package nyu.peerchat.entity;

public class Contact {
	
	private String alias;
	private String ip;
	
	public Contact(String alias, String ip){
		this.alias = alias;
		this.ip = ip;
	}
	
	public void setAlias(String alias){
		this.alias = alias;
	}
	
	public String getAlias(){
		return alias;
	}
	
	public void setIp(String ip){
		this.ip = ip;
	}
	
	public String getIp(){
		return ip;
	}

}
