package cpu_v3;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RunProgram extends Thread {
	OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

	RunProgram() {
		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				} // try
				String CPU = String.format("%.2f", (double) value * 100);
				System.out.println(method.getName() + " = " + CPU + "%");
			} // if
		} // for

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
				method.setAccessible(true);
				if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) {
					Object value;
					try {
						value = method.invoke(operatingSystemMXBean);
					} catch (Exception e) {
						value = e;
					} // try
					String CPU = String.format("%.2f", (double) value * 100);
					System.out.println(method.getName() + " = " + CPU + "%");
				} // if
			} // for

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
