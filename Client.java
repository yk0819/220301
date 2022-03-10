package multiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	public static void main(String[] args) {

		Socket socket = null;
		String IP = "localhost";
		int serverPort = 4000;
		Scanner portScanner = null;
		String userName = null;
		String answer = null;
		Scanner userNameScanner = null;
		Scanner userNameAnswer = null;
		Scanner scannerOutMessage = null;
		BufferedReader in = null;
		BufferedWriter out = null;
//		Scanner text = new Scanner(System.in);
		BufferedReader text = null;


		try {
			socket = new Socket(); // 소켓생성
			System.out.println("연결요청");
			socket.connect(new InetSocketAddress(IP, serverPort)); // 연결요청
			System.out.println("연결되었습니다");

			portScanner = new Scanner(System.in);
			String portName;

			List<String> List = new ArrayList<String>(); // JSONArray
			List.add("8000");
			List.add("8001");
			List.add("8002");
			List.add("8003");
			List.add("8004");
			List.add("8005");
			List.add("8006");
			List.add("8007");
			List.add("8008");
			List.add("8009");

			// 반복문을 이용해 ArrayList를 추출하고 그것을 JSONArray에 담는다
			JSONArray arr = new JSONArray();

			for (int i = 0; i < List.size(); i++) {
				arr.add(List.get(i));
			}
			JSONObject objList = new JSONObject();
			objList.put("PortList", arr);
			System.out.println(objList.toString()); // list 생성 완료

			// 4000 close
			System.out.println("4000번과의 접속이 끊겼습니다.");
			socket.close();

			// json에 들어가 있는 값(value)과 입력한 값이 일치하는지 확인
			System.out.print("접속하고자하는 포트 번호를 입력해주세요: ");
			portName = portScanner.nextLine();

			while (!List.contains(portName)) {
				System.out.println("입력하신 번호는 접속할 수 없습니다.");
				System.out.print("다시 한번 입력해주세요: ");
				portName = portScanner.next();
			}
			System.out.println(portName + "에 접속합니다");
			System.out.println(portName + "에 접속을 확인중입니다");
			serverPort = Integer.parseInt(portName);

			// 소켓을 끊은 다음 입력받은 값으로 소켓을 연결하는 방법....
			socket = new Socket(); // 소켓생성
			socket.connect(new InetSocketAddress(IP, serverPort)); // 연결요청
			System.out.println(serverPort + "에 접속되었습니다");

			// 닉네임 설정
			userNameScanner = new Scanner(System.in);
			userNameAnswer = new Scanner(System.in);

			System.out.print("닉네임을 입력해주세요: ");
			userName = userNameScanner.nextLine();
			System.out.println(userName + "으로 설정하시겠습니까?(Y/N)");
			answer = userNameAnswer.next(); // String으로 변환

			if (answer.equalsIgnoreCase("y")) {// 이름 확정
				System.out.println("닉네임을" + userName + "(으)로 지정하였습니다");
			} else if (answer.equalsIgnoreCase("n")) {
				System.out.print("닉네임을 입력해주세요: ");
				userName = userNameScanner.nextLine();
				System.out.println(userName + "으로 설정하시겠습니까?(Y/N)");
			} // 닉넴 끝
			
			System.out.println(userName+"님이 입장하셨습니다"); // 서버로 출력
			
			ChatInOut CIO = new ChatInOut();
			CIO.run();
			

		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다");
			System.out.println(e);
		}
		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (!socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}