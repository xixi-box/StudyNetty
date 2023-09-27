package com.ws.studynetty.twoWayCommunication.protocol.command;

import lombok.Data;

import static com.ws.studynetty.twoWayCommunication.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {
    private String message;

    /**
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
