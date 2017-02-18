package kr.beomchul.nettypractice.lecture3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutBoundHandler extends ChannelOutboundHandlerAdapter {

	@Override
	public void read(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[Out Handle] Read");
		super.read(ctx);
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("[Out Handle] write");
		super.write(ctx, msg, promise);
	}

	@Override
	public void flush(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[Out Handle] Flush");
		super.flush(ctx);
	}
	
}
