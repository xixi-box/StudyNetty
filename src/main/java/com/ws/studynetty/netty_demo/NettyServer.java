package com.ws.studynetty.netty_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {
    public static void main(String[] args) {
        //表示监听端口，接收新连接的线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //表示处理每一个连接的数据读写的线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        //引导服务端的启动工作
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap
                //配置线程组
                .group(bossGroup, workerGroup)
                //指定服务端的IO模型为nio
                .channel(NioServerSocketChannel.class)
                //连接业务的处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    /**
                     * @param nioSocketChannel
                     */
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) {
                    }
                });
        bind(serverBootstrap, 1000);
//        serverBootstrap.bind(8000).addListener(new GenericFutureListener<Future<? super
//                Void>>() {
//
//            /**
//             * @param future
//             * @throws Exception
//             */
//            @Override
//            public void operationComplete(Future<? super Void> future) throws Exception {
//                if (future.isSuccess()) {
//                    System.out.println("端口绑定成功！");
//                } else {
//                    System.err.println("端口绑定失败！");
//                }
//
//            }
//        });

    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口［" + port + "］绑定成功！");
            } else {
                System.err.println("端口［" + port + "］绑定失败！");
                bind(serverBootstrap, port + 1);
            }
        });

    }
}