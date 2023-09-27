package com.ws.studynetty.twoWayCommunication.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


import static com.ws.studynetty.utils.NettyUtils.MAX_RETRY;
import static com.ws.studynetty.utils.NettyUtils.connect;

public class NettyClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap
                //指定线程模型
                .group(workerGroup)
                //指定IO模型为NIO
                .channel(NioSocketChannel.class)
                //指定处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {

                    /**
                     * @param socketChannel
                     */
                    @Override
                    protected void initChannel(SocketChannel socketChannel) {
                        socketChannel.pipeline().addLast(new FirstClientHandler());
                    }
                });
        connect(bootstrap, HOST, PORT, MAX_RETRY);

    }
}
