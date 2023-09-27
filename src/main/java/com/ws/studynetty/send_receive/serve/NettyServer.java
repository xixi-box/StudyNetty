package com.ws.studynetty.send_receive.serve;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import static com.ws.studynetty.utils.NettyUtils.PORT;
import static com.ws.studynetty.utils.NettyUtils.bind;

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
                        nioSocketChannel.pipeline().addLast(new ServerHandler());
                    }
                });
        bind(serverBootstrap, PORT);

    }


}