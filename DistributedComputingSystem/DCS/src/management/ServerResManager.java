package management;

import java.net.InetAddress;
import java.util.ArrayList;

import def.Worker;

public class ServerResManager {
	private static ServerResManager serverResManager = new ServerResManager();
	private InetAddress serverIP;
	private NetworkInterface networkInterface;
	ArrayList<Worker> workerList = new ArrayList<>();

	public ServerResManager() {
		System.out.println("[ServerResManager.java] ServerResManager()");

		try {
			serverIP = InetAddress.getLocalHost();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("[ServerResManager.java] Err");
		}
	}

	public InetAddress getServerIP() {
		return serverIP;
	}

	public void setServerIP(InetAddress serverIP) {
		this.serverIP = serverIP;
	}

	public static ServerResManager getInstance() {
		return serverResManager;
	}

	public void serverStart(String port) {
		networkInterface = new NetworkInterface();
		networkInterface.setPORT(Integer.parseInt(port));
		networkInterface.serverCreate();
		networkInterface.start();
		
	}

	public void serverStop() {
		networkInterface.serverStop();
	}

	public void addWorker(Worker workerItem) {
		boolean flag = true;
		for (int i = 0; i < workerList.size(); i++) {
			if (workerList.get(i).getIP().equals(workerItem.getIP())) {
				flag = false;
				workerList.get(i).setHOST_NAME(workerItem.getHOST_NAME());
				workerList.get(i).setCPU_USAGE(workerItem.getCPU_USAGE());
				workerList.get(i).setCPU_CAPA(workerItem.getCPU_CAPA());
				workerList.get(i).setMEMORY_USAGE(workerItem.getMEMORY_USAGE());
				workerList.get(i).setMEMORY_CAPA(workerItem.getMEMORY_CAPA());
			}
		}

		if (flag == true) {
			workerList.add(workerItem);
		}
	}

	public ArrayList getWorkerList() {
		return this.workerList;
	}

	public void RemoveWorkerItem(String name, String ip) {

		for (int i = 0; i < workerList.size(); i++) {

			if (workerList.get(i).getIP().equals(ip) 
					&& workerList.get(i).getHOST_NAME().equals(name)) {
				
				workerList.remove(workerList.get(i));
				break;
			}

		}
	}

}
