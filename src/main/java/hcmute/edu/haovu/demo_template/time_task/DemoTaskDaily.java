package hcmute.edu.haovu.demo_template.time_task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class DemoTaskDaily {
	public static void main(String[] args) {
		MyTask myTask = new MyTask();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 5);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Date dateSchedule = calendar.getTime();
		long period = 24l * 60l * 60l * 1000l;
		
		Timer timer = new Timer();
		timer.schedule(myTask, dateSchedule, period);
	}

}
