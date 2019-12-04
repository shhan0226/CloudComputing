package ui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import def.Worker;
import management.ServerResManager;

public class ServerTableView extends Thread {
	private ServerResManager serverResManager;
	private DefaultTableModel model;
	ArrayList<Worker> workerList;
	private boolean flag;

	public ServerTableView(DefaultTableModel model) {
		System.out.println("[ServerTableView.java] ServerTableView()");
		this.model = model;
		flag = true;
	}

	public void run() {

		try {
			while (flag) {
				System.out.println("[ServerTableView.java] run...");
				model.setNumRows(0);
				serverResManager = ServerResManager.getInstance();
				workerList = serverResManager.getWorkerList();
				for (int i = 0; i < workerList.size(); i++) {
					String str_arr[] = { workerList.get(i).getHOST_NAME(), workerList.get(i).getIP(),
							workerList.get(i).getCPU_USAGE(), workerList.get(i).getCPU_CAPA(),
							workerList.get(i).getMEMORY_USAGE(), workerList.get(i).getMEMORY_CAPA() };

					model.addRow(str_arr);
				}
				sleep(1000);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ServerTableView.java] run err");
			e.printStackTrace();
		}
	}

	public void stoped() {
		try {
			sleep(1000);
			System.out.println("[ServerTableView.java] stoped()");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("[ServerTableView.java] stoped err");
			e.printStackTrace();
		}
		flag = false;
	}

}
