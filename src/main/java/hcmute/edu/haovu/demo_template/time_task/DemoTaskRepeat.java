package hcmute.edu.haovu.demo_template.time_task;

import java.util.Timer;

public class DemoTaskRepeat {
	public static void main(String[] args) {
		MyTask myTask = new MyTask("newfuture429@gmail.com");
		Timer timer = new Timer();
		timer.schedule(myTask, 0, 2000);
	}

	public static void timeTaskRepeat(String receiveEmail) {
		MyTask myTask = new MyTask(receiveEmail);
		Timer timer = new Timer();
		timer.schedule(myTask, 0, 300000);
	}

}
