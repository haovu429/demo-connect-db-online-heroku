package hcmute.edu.haovu.demo_template.time_task;

import hcmute.edu.haovu.demo_template.mail.SendMail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.TimerTask;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyTask extends TimerTask {

	private String receiveEmail = "newfuture429@gmail.com";

	@Override
	public void run() {
		System.out.println("Run my Task " + new Date());
		SendMail.sendMail(receiveEmail);
	}



}
