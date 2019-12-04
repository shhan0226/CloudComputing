package exeTime_v1;

public class main {
	
	private static int sum() {
		int sum = 0;
		for (int j = 0; j < 10 * 1000; j++) {
			sum += j;
		}
		return sum;
	}

	
	public static void main(String[] args) {	
		
		long t1 = System.nanoTime();

		int result = 0;
		for (int i = 0; i < 1000 * 1000; i++) { // sole loop
			result += sum();
		}

		long t2 = System.nanoTime();
		System.out.println("Execution time: " + ((t2 - t1) * 1e-9) + " seconds to compute result = " + result);
	}


}
