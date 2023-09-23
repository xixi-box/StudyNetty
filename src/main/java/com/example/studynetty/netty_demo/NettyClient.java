package com.example.studynetty.netty_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NettyClient {
    private static final AtomicInteger MAX_RETRY = new AtomicInteger(5);

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap
                //指定线程模型
                .group(workerGroup)
                //指定IO模型为NIO
                .channel(NioDatagramChannel.class)
                //指定处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {

                    /**
                     * @param socketChannel
                     */
                    @Override
                    protected void initChannel(SocketChannel socketChannel) {

                    }
                });
//        bootstrap.connect("juejin.cn", 80).addListener(future -> {
//            if (future.isSuccess()) {
//                System.out.println("连接成功！");
//            } else {
//                System.err.println("连接失败！");
//            }
//
//        });
        connect(bootstrap, "juejin.cn", 80, MAX_RETRY);

    }


    private static void connect(Bootstrap bootstrap, String host, int port, AtomicInteger retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功");
            } else if (retry.get() == 0) {
                System.out.println("重试次数已用完，放弃连接");

            } else {
                //第几次连接
                int order = MAX_RETRY.get() - retry.get() - 1;
                int delay = 1 << order;
                System.err.println(new Date() + "：连接失败，第" + order + "次重连……");
                retry.decrementAndGet();
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry), delay, TimeUnit.SECONDS);

            }
        });
    }
}
