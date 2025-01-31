package management;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;

import def.Worker;

public class WorkerResManager {
	private static WorkerResManager workerResManager = new WorkerResManager();
	private Worker worker;
	private UsageCheck update;
	private ConnectToServer connectToServer;

	public WorkerResManager() {
		System.out.println("[WorkerResManager.java] WorkerResManager()");
		worker = new Worker();
		update = new UsageCheck();
		WorkerInit();
	}

	public static WorkerResManager getInstance() {
		return workerResManager;
	}

	public void update_start() {
		update.startUpdate();
	}

	public void update_stop() {
		update.stopUpdate();
	}

	public void WorkerInit() {
		System.out.println("[WorkerResManager.java] WorkerInit()");

		try {
			worker.setMyComputer(InetAddress.getLocalHost());
			worker.setHOST_NAME(worker.getMyComputer().getHostName());
			worker.setIP(worker.getMyComputer().getHostAddress());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		float FreeMem = 0;
		float TotalMem = 0;
		String Memory = "";

		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);

			if (method.getName().startsWith("getFreePhysicalMemorySize") && Modifier.isPublic(method.getModifiers())) {
				Object value;

				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				FreeMem = ((float) ((long) value / 1024) / 1024) / 1024;

			} else if (method.getName().startsWith("getTotalPhysicalMemorySize")
					&& Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				TotalMem = ((float) ((long) value / 1024) / 1024) / 1024;
			}

			Memory = String.format("%.2f", TotalMem);
			worker.setMEMORY_CAPA(Memory);
			Memory = String.format("%.2f", TotalMem - FreeMem);
			worker.setMEMORY_USAGE(Memory);

			if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				String CPU = String.format("%.2f", (double) value * 100);
				worker.setCPU_USAGE(CPU);

			}
		}
	}

	public Worker getWorker() {
		return this.worker;
	}

	public String getCPU_CAPA() {
		return worker.getCPU_CAPA();
	}

	public void setCPU_CAPA(String cPU_CAPA) {
		worker.setCPU_CAPA(cPU_CAPA);
	}

	public String getMEMORY_CAPA() {
		return worker.getMEMORY_CAPA();
	}

	public void setMEMORY_CAPA(String mEMORY_CAPA) {
		worker.setMEMORY_CAPA(mEMORY_CAPA);
	}

	public String getCPU_USAGE() {
		return worker.getCPU_USAGE();
	}

	public void setCPU_USAGE(String cPU_USAGE) {
		worker.setCPU_USAGE(cPU_USAGE);
	}

	public String getMEMORY_USAGE() {
		return worker.getMEMORY_USAGE();
	}

	public void setMEMORY_USAGE(String mEMORY_USAGE) {
		worker.setMEMORY_USAGE(mEMORY_USAGE);
	}

	public String getIP() {
		return worker.getIP();
	}

	public void setIP(String iP) {
		worker.setIP(iP);
	}

	public String getHOST_NAME() {
		return worker.getHOST_NAME();
	}

	public void setHOST_NAME(String hOST_NAME) {
		worker.setHOST_NAME(hOST_NAME);
	}

	public InetAddress getMyComputer() {
		return worker.getMyComputer();
	}

	public void setMyComputer(InetAddress myComputer) {
		worker.setMyComputer(myComputer);
	}

	public void ConnectToServer() {
		System.out.println("[WorkerResManager.java] ConnectToServer()" + worker.getMyComputer().getHostAddress().trim());
		connectToServer = new ConnectToServer(worker.getMyComputer().getHostAddress().trim());
	}

	public void disconnectServer() {
		System.out.println("[WorkerResManager.java] disconnectServer()");
		connectToServer.disconnectServer();

	}
}
