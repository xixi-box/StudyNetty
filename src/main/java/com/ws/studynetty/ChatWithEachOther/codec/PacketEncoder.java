package com.ws.studynetty.ChatWithEachOther.codec;

import com.ws.studynetty.ChatWithEachOther.protocol.Packet;
import com.ws.studynetty.ChatWithEachOther.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}