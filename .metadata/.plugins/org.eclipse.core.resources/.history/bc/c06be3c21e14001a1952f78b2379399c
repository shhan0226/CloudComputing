package v1;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		float FreeMem = 0;
		float TotalMem = 0;
		String Memory = "";

//		long start = System.currentTimeMillis();
		long startTime = System.nanoTime();


		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				String CPU = String.format("%.2f", (double) value * 100);
				System.out.println("CPU USE: " + CPU);
			}
		}


//		long end = System.currentTimeMillis();
//		System.out.println("Resutl: " + (end - start) / (double) 1000 + "s");
		long endTime = System.nanoTime();		
		System.out.println("Code took " + (endTime - startTime) /(double)1000000 + " seconds");

	}

}
