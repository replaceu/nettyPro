package com.atguigu.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.HttpCookie;
import java.net.URI;

public class CarterHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户端数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("对应的channel=" + ctx.channel() + " pipeline=" + ctx.pipeline() + " 通过pipeline获取channel" + ctx.pipeline().channel());
        System.out.println("当前ctx的handler=" + ctx.handler());
        //todo:判断msg是不是httpRequest请求
        if (msg instanceof HttpRequest){
            System.out.println("ctx 类型="+ctx.getClass());
            System.out.println("pipeline hashcode" + ctx.pipeline().hashCode() + " TestHttpServerHandler hash=" + this.hashCode());
            System.out.println("msg 类型=" + msg.getClass());
            System.out.println("客户端地址" + ctx.channel().remoteAddress());
            HttpRequest httpRequest = (HttpRequest) msg;
            //todo:获取uri，过滤指定的资源
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了 favicon.ico, 不做响应");
                return;
            }
            //todo:回复信息给浏览器【http协议】
            ByteBuf content = Unpooled.copiedBuffer("hello，我是服务器", CharsetUtil.UTF_8);
            //todo：构造一个http的响应,即httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
            //todo:将构建好的response返回
            ctx.writeAndFlush(response);

        }
    }
}
