package com.ws.studynetty.GroupChat.protocol.request;

import com.ws.studynetty.GroupChat.protocol.Packet;

import static com.ws.studynetty.GroupChat.protocol.command.Command.HEARTBEAT_REQUEST;


public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}