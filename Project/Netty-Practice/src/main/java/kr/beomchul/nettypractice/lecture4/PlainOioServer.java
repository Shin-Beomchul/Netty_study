package kr.beomchul.nettypractice.lecture4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {

	public void serve(int port) throws IOException {
		final ServerSocket socket = new ServerSocket(port);

		try {
			for (;;) {

				final Socket clientSocet = socket.accept();
				System.out.println("Accepted Connect From " + clientSocet);

				new Thread(new Runnable() { // 연결을 처리할 새로운 스레드 생성

					@Override
					public void run() {

						OutputStream out;
						try {
							out = clientSocet.getOutputStream();
							out.write("Hi i'am Server\r\n".getBytes(
									Charset.forName("UTF-8"))); // 클라잉너트로 메시지 출력
							out.flush();
							clientSocet.close();//연결을 닫음

						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								clientSocet.close();
							} catch (IOException ex) {
								// 종료 시 무시함
							}

						}

					}
				}).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
