package management;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Worker_Manager {
	private static Worker_Manager worker_manager = new Worker_Manager();

	private Worker_Infor worker_infor = null;

	public Worker_Manager() {
		worker_infor = new Worker_Infor();
	}

	public void baseWorkerInfor() {
		if (worker_infor == null)
			return;
		try {
			InetAddress myComputer = InetAddress.getLocalHost();

			worker_infor.setIP(myComputer.getHostAddress());
			worker_infor.setHOST_NAME(myComputer.getHostName());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void setMemory(String MEMORY) {
		worker_infor.setMEMORY(MEMORY);
	}

	public void setCPU(String CPU) {
		worker_infor.setCPU(CPU);
	}

	public String getMemory() {
		return worker_infor.getMEMORY();
	}

	public String getCPU() {
		return worker_infor.getCPU();
	}

	public String getIP() {
		return worker_infor.getIP();
	}

	public String getHostName() {
		return worker_infor.getHOST_NAME();
	}

	public Worker_Infor getWorker() {
		return this.worker_infor;
	}

	public static Worker_Manager getInstance() {
		return worker_manager;
	}
}
