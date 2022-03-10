package multiThread;

public class AcceptThreadChatServer {

	public static void main(String[] args) {
		
		Thread ss = new Thread(new AcceptThreadMain(4000));
		Thread ss1 = new Thread(new AcceptThreadChat(8000));
		Thread ss2 = new Thread(new AcceptThreadChat(8001));
		Thread ss3 = new Thread(new AcceptThreadChat(8002));
		Thread ss4 = new Thread(new AcceptThreadChat(8003));
		Thread ss5 = new Thread(new AcceptThreadChat(8004));
		Thread ss6 = new Thread(new AcceptThreadChat(8005));
		Thread ss7 = new Thread(new AcceptThreadChat(8006));
		Thread ss8 = new Thread(new AcceptThreadChat(8007));
		Thread ss9 = new Thread(new AcceptThreadChat(8008));
		Thread ss10 = new Thread(new AcceptThreadChat(8009));

		System.out.println("연결대기중입니다");

		ss.start();
		ss1.start();
		ss2.start();
		ss3.start();
		ss4.start();
		ss5.start();
		ss6.start();
		ss7.start();
		ss8.start();
		ss9.start();
		ss10.start();
	}
}