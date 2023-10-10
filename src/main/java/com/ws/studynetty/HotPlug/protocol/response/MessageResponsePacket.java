package com.ws.studynetty.HotPlug.protocol.response;

import com.ws.studynetty.HotPlug.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.HotPlug.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
