package kr.beomchul.nettypractice.lecture4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class PlainNioServer {

	public void serve(int port) throws IOException{
		
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket ssocket = serverChannel.socket();
		
		InetSocketAddress address = new InetSocketAddress(port);
		ssocket.bind(address);//서버를 선택된 포트로 바인딩.
		
		Selector selector = Selector.open();// 채널을 처리할 셀럭터를 염
		serverChannel.register(selector, SelectionKey.OP_ACCEPT); //연결을 수락할 ServerSocket을 셀렉터에 등록
		final ByteBuffer msg = ByteBuffer.wrap("Hi i'am Server\r\n".getBytes());
		
		for(;;){
			try {
				selector.select();
			} catch (IOException e) {
				//예외 처리
				break;
				
			}
			Set<SelectionKey> readkeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator =readkeys.iterator();
			
			while (iterator.hasNext()) {
				SelectionKey key =iterator.next();
				iterator.remove();
				try{
					if(key.isAcceptable()){ //입네트가 수락할 수 있는 새로운 연결인지 확인
						ServerSocketChannel server =
								(ServerSocketChannel)key.channel();
						SocketChannel client = server.accept();
						client.configureBlocking(false);
						//클라이언트를 수락하고 셀렉터에 등록
						client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ,msg.duplicate());
						System.out.println("Accepted connection from "+client);
						
					}
					if(key.isWritable()){// 소켓에 데이터를 기록 할 수 있는지 확인
						SocketChannel client =
								(SocketChannel)key.channel();
						
						ByteBuffer buffer= 
								(ByteBuffer)key.attachment();
					
					
						while(buffer.hasRemaining()){
							if(client.write(buffer) == 0){
								break;
							}
						}
						client.close();
					}
					
				}catch(IOException e){
					key.cancel();
					try{
						key.channel().close();
					}catch(IOException cex){
						//종료 시 무시함
					}
					
				}
				
			}
			
		}
		
		
		
		
	}
}
