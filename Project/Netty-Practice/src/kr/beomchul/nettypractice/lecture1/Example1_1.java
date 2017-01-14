package kr.beomchul.nettypractice.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Example1_1 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try{
			
			serverSocket = new ServerSocket(7777);
		
			while(true){
				System.out.println("접속 대기 Blocking..");
				Socket clientSocket = serverSocket.accept();
				System.out.println("클라이언트 접속함  ");
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
				
				String request; 
				while((request = in.readLine()) != null){
					if(request.equals("done")){
						break;
					}
					
					System.out.println(request);
					out.println(request);
					
				}
				System.out.println("while을 빠져나오지 못함.");
				 
			}
		}finally {
			if(serverSocket != null){
				serverSocket.close();
			}
		}
	}
}