package com.ws.studynetty.HotPlug.protocol.request;

import com.ws.studynetty.HotPlug.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ws.studynetty.HotPlug.protocol.command.Command.MESSAGE_REQUEST;


@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
