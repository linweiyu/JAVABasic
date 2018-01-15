package Basic.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext cx, Object msg){
        ByteBuf in = (ByteBuf) msg;
        try{
//            while(in.isReadable()){
//                System.out.println((char) in.readByte());
//                System.out.flush();
//            }
            System.out.println(in.toString(CharsetUtil.UTF_8));
            // if do write operation. It will automatic release
            cx.write(msg);
            cx.flush();
        }finally {
//            ReferenceCountUtil.release(msg);
//            ((ByteBuf) msg).release();
            //in.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
