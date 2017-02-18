package kr.beomchul.nettypractice.lecture3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;

public class InBussinessHandler extends ChannelInboundHandlerAdapter {
	int cnt;

	// 이벤트 발생 가능 (개발자가 이벤트 보낼 수 있음. 이벤트 보내면 여기로 옴.)
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String decodedStr = (String) msg;
		System.out.println("[Deco] -> [InHandler] channelRead -> " + decodedStr);

		final ByteBuf bf = Unpooled.buffer(256);
		if (decodedStr.equals("get")) {
			bf.writeBytes("Get is good".getBytes());

		} else if (decodedStr.equals("set")) {
			bf.writeBytes("Set is soso".getBytes());
		} else {
			bf.writeBytes("only commd set/get".getBytes());
		}

		synchronized (this) {

		}

		ctx.write(bf).addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				// TODO Auto-generated method stub

				synchronized (this) {

				}
			}
		});
		// 메시지 받는건 성공. 처리 후 어케 넘길꺼냐? 이건 그냥 Echo에 지나지 않음.
		// Echo.. 이건 안댐..Out 으로 보내야

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[Deco] -> [InHandler] channelReadComplete");
		ctx.flush();

		synchronized (this) {
			
		}
		// ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
		
		synchronized (Object.class) {
			
		}
	}
	
	
	// 뮤텍스, 세마포어,스케쥴링 ,자바는 뮤텍스,세마포어 개념이 아니라 모니터라는 개념을 씀.
	

}
