package com.atguigu.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class CarterHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    /**
     * 向管道加入处理器
     * @param channel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //todo：得到管道
        ChannelPipeline pipeline = channel.pipeline();
        /*
        todo:加入一个netty提供的httpServerCodec，HttpServerCodec是netty提供的处理Http的编解码器
         */
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        //todo:2.增加一个自定义的Handler
        pipeline.addLast("CarterHttpServerHandler",new CarterHttpServerHandler());

    }
}
