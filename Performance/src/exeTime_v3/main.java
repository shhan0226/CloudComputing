package exeTime_v3;
import java.util.Collections;
public class main {

	public static void main(String[] args) {
		/*
		 * Scalar Alpha X Plus Y Single-Precision A¡¤X Plus Y (SAXPY)in the Basic
		 * Linear Algebra Subprograms (BLAS)
		 */

		int N = 1 << 26;
		float XVAL = (float) (10 * Math.random());
		float YVAL = (float) (10 * Math.random());
		float AVAL = (float) (10 * Math.random());
		float[] x = new float[N];
		float[] y = new float[N];

		double[] Result = new double[100];

		System.out.println("N: " + N);

		for (int j = 0; j < N; j++) {
			x[j] = XVAL;
			y[j] = YVAL;
		}

		for (int i = 0; i < 100; i++) {

			double startTime = System.nanoTime();
			for (int k = 0; k < N; k++) {
				y[k] += AVAL * x[k];
			}
			double endTime = System.nanoTime();
			System.out.println("Elapsed: " + (endTime - startTime) / 1000000.0 + " ms");
			Result[i] = (endTime - startTime) / 1000000.0; // nanoseonds 10e-9

			float error = 0;
			for (int l = 0; l < N; l++) {
				error += Math.abs(y[l] - (YVAL + AVAL * XVAL));
				if (error != 0) {
					i = 0;
				}
			}
			System.out.println(i + "th : Error: " + error);
		}

		double sum, max, min;
		sum = max = min = Result[0];

		for (int n = 1; n < 100; n++) {
			if (max < Result[n]) {
				max = Result[n];
			}
			if (min > Result[n]) {
				min = Result[n];
			}
			sum += Result[n];
		}
		System.out.println("Result =====>" + Double.toString((sum - max - min) / 98) + "ms");
		System.out.println("Result =====>" + String.format("%.5f", (double) (sum - max - min) / 98) + "ms");

	}

}
