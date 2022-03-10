package multiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatInOut implements Runnable {

	@Override
	public void run() {
		
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner text = null;
		
		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			text = new Scanner(System.in);
			
			System.out.println(">");
			String outMessage = text.nextLine();
			out.flush();
			System.out.println(outMessage);

			String inMessage = in.readLine();
			System.out.println("상대방: "+inMessage);

		}catch(Exception e) {
			
		}
	}	
}
