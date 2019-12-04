package exeTime_v5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Date today = new Date();
		// SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		// SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		//
		// System.out.println("Date: "+date.format(today));
		// System.out.println("Time: "+time.format(today));
		for (int i = 0; i < 3; i++) {
			Date today = new Date();

			System.out.println(today);

			long time2 = System.nanoTime();
			System.out.println(time2);
		}

	}

}