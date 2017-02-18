package kr.beomchul.nettypractice.lecture3;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

public class DecoHandler extends ByteToMessageDecoder {

	
	 
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		System.out.println("[Deco] decode :: "+in.toString(CharsetUtil.UTF_8));
		
		
		String decoStr= in.toString(CharsetUtil.UTF_8);
		System.out.println("[Deco] decodedStr :: "+ decoStr);
		ctx.fireChannelRead(decoStr);
		
		//out에 써야 넘어감.
		
		
		
		

	}

}
