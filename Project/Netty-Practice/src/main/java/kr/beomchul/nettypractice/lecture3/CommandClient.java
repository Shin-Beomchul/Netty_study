package kr.beomchul.nettypractice.lecture3;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class CommandClient extends Thread {

	private final String host;
	private final int port;
	private SocketChannel mSocketChannel;

	public CommandClient(String host, int port) {

		this.host = host;
		this.port = port;

	}

	@Override
	public void run() {

		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(group).remoteAddress(new InetSocketAddress(host, port)).channel(NioSocketChannel.class)

					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							System.err.println("클라이언트  채널 초기화");
							ch.pipeline().addLast(new CommandInHandler());
							mSocketChannel = ch;
						}
					});

			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	

	public void send(String msg) {
		final ByteBuf  bf = Unpooled.buffer(256);
		if (mSocketChannel != null && mSocketChannel.isActive()){
			bf.writeBytes(msg.getBytes());
			mSocketChannel.writeAndFlush(bf);
		}
		 
	}

}
