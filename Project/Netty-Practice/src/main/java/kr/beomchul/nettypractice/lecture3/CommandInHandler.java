package kr.beomchul.nettypractice.lecture3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class CommandInHandler extends SimpleChannelInboundHandler<ByteBuf>{
	
	 
	//�ڵ鷯 Ȱ��ȭ ��
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}
	
	//������ �����͸� ���� ��
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("Client recevived :: "+ msg.toString(CharsetUtil.UTF_8));
	}

	// ���� �߻�
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
	cause.printStackTrace();
	ctx.close();
	}
	
	

}
