package kr.beomchul.nettypractice.lecture2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter{

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("channelRead");
		
			ByteBuf in =(ByteBuf)msg;
			System.out.println("Server Receved :: "+in.toString(CharsetUtil.UTF_8));
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
		.addListener(ChannelFutureListener.CLOSE);
		
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
				cause.printStackTrace();
				ctx.close();
				
	}
	
}
