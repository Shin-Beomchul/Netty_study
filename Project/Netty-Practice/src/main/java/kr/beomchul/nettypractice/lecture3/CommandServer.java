package kr.beomchul.nettypractice.lecture3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class CommandServer {

	
	private SocketChannel mSocketChannel;
	private final int port ;
	
	public CommandServer(int port) {
		this.port = port;
	}
 
	
	
	public void start() throws Exception{
		System.out.println("start!");

		final DecoHandler inDecoHandeler = new DecoHandler();
		ServerBootstrap bootStarp = new ServerBootstrap();
		EventLoopGroup group = new NioEventLoopGroup();
		
		
		bootStarp.group(group)
			.channel(NioServerSocketChannel.class)
			.localAddress(port)
			.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					
					ChannelPipeline pipe = ch.pipeline();
					
					pipe
				      .addLast(inDecoHandeler)
				      .addLast(new InBussinessHandler())
					  .addLast(new OutBoundHandler());
					
					
					
					mSocketChannel = ch;
					
					
					
				}
			});
		
		ChannelFuture f =bootStarp.bind().sync();
		f.channel().closeFuture().sync();
		
		
//		final EchoServerHandler serverHandler  = new EchoServerHandler();
//		
//		EventLoopGroup group = new NioEventLoopGroup();
//		
//		try {
//			ServerBootstrap b = new ServerBootstrap();
//			b.group(group)
//				.channel(NioServerSocketChannel.class)
//				.localAddress(new InetSocketAddress(port))
//				.childHandler(new ChannelInitializer<SocketChannel>() {
//
//					@Override
//					protected void initChannel(SocketChannel ch) throws Exception {
//					ch.pipeline().addLast(serverHandler);
//					}
//				});
//			
//			ChannelFuture f =b.bind().sync();
//			f.channel().closeFuture().sync();
//			
//		}finally {
//			group.shutdownGracefully().sync();
//		}
//		
//		
		
	}
	
	
	
}
