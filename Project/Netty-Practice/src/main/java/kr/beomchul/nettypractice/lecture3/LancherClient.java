package kr.beomchul.nettypractice.lecture3;

import java.util.Scanner;

public class LancherClient {

	
	public static void main(String[] args) throws Exception {


		CommandClient client = new CommandClient("127.0.0.1", 12345);
		client.start();
		
		Scanner s = new Scanner(System.in);
		for(;;){
			System.out.println("Enter Your Message...");
			
			String comm = s.nextLine();
			System.out.println("Client Message :: "+ comm);
	
			client.send(comm);
		}
		

		//bind
//		String host = args[0];
//		int port = Integer.parseInt(args[1]);
	

	}
}
