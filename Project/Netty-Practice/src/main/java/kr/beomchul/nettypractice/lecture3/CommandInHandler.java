package kr.beomchul.nettypractice.lecture3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class CommandInHandler extends SimpleChannelInboundHandler<ByteBuf>{
	
	 
	//핸들러 활성화 시
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}
	
	//들어오는 데이터를 읽을 때
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("Client recevived :: "+ msg.toString(CharsetUtil.UTF_8));
	}

	// 예외 발생
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
	cause.printStackTrace();
	ctx.close();
	}
	
	

}
