package com.ws.studynetty.GroupChat.server.handle;

import com.ws.studynetty.GroupChat.protocol.request.MessageRequestPacket;
import com.ws.studynetty.GroupChat.protocol.response.MessageResponsePacket;
import com.ws.studynetty.GroupChat.session.Session;
import com.ws.studynetty.GroupChat.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    public final static MessageRequestHandler INSTANCE = new MessageRequestHandler();

    private MessageRequestHandler() {

    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        //获得对方发送的消息
        Session session = SessionUtil.getSession(ctx.channel());
        //通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());
        //获得消息接受方的channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        //将消息发送给接受方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
        }
    }
}