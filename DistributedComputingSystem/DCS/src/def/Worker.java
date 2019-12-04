package def;

import java.io.Serializable;
import java.net.InetAddress;

public class Worker implements Serializable {
	
	//private static final long serialVersionUID = 1L;	

	private String CPU_CAPA = "";
	private String MEMORY_CAPA = "";
	
	private String CPU_USAGE = "";
	private String MEMORY_USAGE = "";
	
	private String IP = "";
	private String HOST_NAME = "";
	
	private InetAddress myComputer;
	
	
	public String getCPU_CAPA() {
		return CPU_CAPA;
	}
	public void setCPU_CAPA(String cPU_CAPA) {
		CPU_CAPA = cPU_CAPA;
	}
	public String getMEMORY_CAPA() {
		return MEMORY_CAPA;
	}
	public void setMEMORY_CAPA(String mEMORY_CAPA) {
		MEMORY_CAPA = mEMORY_CAPA;
	}
	public String getCPU_USAGE() {
		return CPU_USAGE;
	}
	public void setCPU_USAGE(String cPU_USAGE) {
		CPU_USAGE = cPU_USAGE;
	}
	public String getMEMORY_USAGE() {
		return MEMORY_USAGE;
	}
	public void setMEMORY_USAGE(String mEMORY_USAGE) {
		MEMORY_USAGE = mEMORY_USAGE;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getHOST_NAME() {
		return HOST_NAME;
	}
	public void setHOST_NAME(String hOST_NAME) {
		HOST_NAME = hOST_NAME;
	}
	public InetAddress getMyComputer() {
		return myComputer;
	}
	public void setMyComputer(InetAddress myComputer) {
		this.myComputer = myComputer;
	}

	


}
