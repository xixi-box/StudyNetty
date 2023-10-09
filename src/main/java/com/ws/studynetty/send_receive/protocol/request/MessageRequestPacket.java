package com.ws.studynetty.send_receive.protocol.request;


import com.ws.studynetty.send_receive.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.send_receive.protocol.command.Command.MESSAGE_REQUEST;


@Data
public class MessageRequestPacket extends Packet {
    private String message;

    /**
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
