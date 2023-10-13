package com.ws.studynetty.GroupChat.protocol.response;

import com.ws.studynetty.GroupChat.protocol.Packet;

import static com.ws.studynetty.GroupChat.protocol.command.Command.HEARTBEAT_RESPONSE;

public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}