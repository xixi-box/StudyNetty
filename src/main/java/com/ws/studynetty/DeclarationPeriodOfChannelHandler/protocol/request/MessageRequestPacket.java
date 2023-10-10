package com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.request;


import com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.Packet;
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
