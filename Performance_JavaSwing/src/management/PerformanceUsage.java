package management;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ui.StatusView;

public class PerformanceUsage implements Runnable {

	private Thread update = null;

	public void startUpdate() {
		if (update != null)
			return;

		this.update = new Thread(this);

		if (update.isAlive())
			return;

		update.start();
	}

	public void stropUpdate() {
		if (update != null)
			if (update.isAlive()) {
				update.interrupt();
			}

		update = null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.interrupted()) {
			OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
			try {
				for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
					method.setAccessible(true);
					if (method.getName().startsWith("getFreePhysicalMemorySize")
							&& Modifier.isPublic(method.getModifiers())) {
						Object value;
						try {
							value = method.invoke(operatingSystemMXBean);
						} catch (Exception e) {
							value = e;
						}
						String Memory = String.format("%.2f", ((float) ((long) value / 1024) / 1024) / 1024);
						// System.out.println(method.getName() + " = " + Memory
						// + "GB");
						Worker_Manager.getInstance().setMemory(Memory);
					}

					else if (method.getName().startsWith("getSystemCpuLoad")
							&& Modifier.isPublic(method.getModifiers())) {
						Object value;
						try {
							value = method.invoke(operatingSystemMXBean);
						} catch (Exception e) {
							value = e;
						}
						String CPU = String.format("%.2f", (double) value * 100);
						// System.out.println(method.getName() + " = " + CPU +
						// "%");
						Worker_Manager.getInstance().setCPU(CPU);
					}

				}
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			// StatusView.getInstance().repaint(); //스레드 실행중에 다시 그리기

		}
	}

}
