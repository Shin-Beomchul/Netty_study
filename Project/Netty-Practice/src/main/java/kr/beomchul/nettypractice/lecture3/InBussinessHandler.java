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

	// �̺�Ʈ �߻� ���� (�����ڰ� �̺�Ʈ ���� �� ����. �̺�Ʈ ������ ����� ��.)
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
		// �޽��� �޴°� ����. ó�� �� ���� �ѱ沨��? �̰� �׳� Echo�� ������ ����.
		// Echo.. �̰� �ȴ�..Out ���� ������

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
	
	
	// ���ؽ�, ��������,�����층 ,�ڹٴ� ���ؽ�,�������� ������ �ƴ϶� ����Ͷ�� ������ ��.
	

}
