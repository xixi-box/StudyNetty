package com.ws.studynetty.clinet_login.serve;

import com.ws.studynetty.twoWayCommunication.protocol.command.LoginRequestPacket;
import com.ws.studynetty.twoWayCommunication.protocol.command.Packet;
import com.ws.studynetty.twoWayCommunication.protocol.command.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {
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
            if (valid(loginRequestPacket)) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登录失败");
            }

        }
        //服务端处理响应请求
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setVersion(decode.getVersion());
        if (valid(loginRequestPacket)) {
            loginRequestPacket.setSuccess(true);
        } else {
            loginRequestPacket.setReason("账号密码校验失败");
            loginRequestPacket.setSuccess(false);
        }
        ByteBuf encode = PacketCodeC.INSTANCE.encode(loginRequestPacket);
        ctx.channel().writeAndFlush(encode);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

}
