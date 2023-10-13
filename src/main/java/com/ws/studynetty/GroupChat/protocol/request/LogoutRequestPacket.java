package com.ws.studynetty.GroupChat.protocol.request;

import com.ws.studynetty.GroupChat.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.GroupChat.protocol.command.Command.LOGOUT_REQUEST;

@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}