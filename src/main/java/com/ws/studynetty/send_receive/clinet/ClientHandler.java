package com.ws.studynetty.send_receive.clinet;

import com.ws.studynetty.twoWayCommunication.protocol.command.LoginRequestPacket;
import com.ws.studynetty.twoWayCommunication.protocol.command.Packet;
import com.ws.studynetty.twoWayCommunication.protocol.command.PacketCodeC;
import com.ws.studynetty.utils.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + "客户端开始登录");
        //创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("ws");
        loginRequestPacket.setPassword("123456");
        ByteBuf encode = PacketCodeC.INSTANCE.encode(loginRequestPacket);
        ctx.channel().writeAndFlush(encode);

    }

    /**
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //服务端处理登录请求
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet decode = PacketCodeC.INSTANCE.decode(requestByteBuf);
        //判断是否是登录请求的数据包
        if (decode instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) decode;
            if (loginRequestPacket.getSuccess()) {
                //标记登录成功
                LoginUtil.markAsLogin(ctx.channel());
                System.out.println(new Date() + "登陆成功");
            } else {
                System.out.println(new Date() + "登录失败,原因：" + loginRequestPacket.getReason());
            }

        }
    }
}
