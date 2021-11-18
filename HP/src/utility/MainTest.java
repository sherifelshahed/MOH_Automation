package utility;

public class MainTest {

	public static void main(String[] args) {
		
		login l = new login();
		l.invoke_browser();
		Notification_Setup nt = new Notification_Setup();
		l.Login_to_BMS("Digital1","digital1@staging");
		l.Notification_Setup("SMS","TestingEss",true);


	}
}
