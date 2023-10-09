package com.ws.studynetty.utils;

import com.ws.studynetty.twoWayCommunication.protocol.command.MessageRequestPacket;
import com.ws.studynetty.twoWayCommunication.protocol.command.PacketCodeC;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NettyUtils {
    public static final Integer MAX_RETRY = 5;
    public static final int PORT = 8000;

    public static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                //连接成功之后启动控制台进程
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
                System.out.println("连接成功!");
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit
                        .SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息到服务端");
                    Scanner scanner = new Scanner(System.in);
                    String msg = scanner.nextLine();
                    MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                    messageRequestPacket.setMessage(msg);
                    ByteBuf encode = PacketCodeC.INSTANCE.encode(messageRequestPacket);
                    channel.writeAndFlush(encode);
                }
            }
        }).start();
    }

    public static void bind(final ServerBootstrap serverBootstrap, final int port) {
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
