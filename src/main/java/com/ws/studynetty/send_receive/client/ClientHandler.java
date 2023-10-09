package com.ws.studynetty.send_receive.client;

import com.ws.studynetty.send_receive.protocol.Packet;
import com.ws.studynetty.send_receive.protocol.PacketCodeC;
import com.ws.studynetty.send_receive.protocol.request.LoginRequestPacket;
import com.ws.studynetty.send_receive.protocol.response.LoginResponsePacket;
import com.ws.studynetty.send_receive.protocol.response.MessageResponsePacket;
import com.ws.studynetty.send_receive.util.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


import java.util.Date;
import java.util.UUID;

/**
 *
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端开始登录");
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("ws");
        loginRequestPacket.setPassword("123456");

        // 编码
        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);

        // 写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        System.out.println(packet.getClass());
        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            //判断是否登录成功
            if (loginResponsePacket.getSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
                LoginUtil.markAsLogin(ctx.channel());
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
        }
    }
}