package com.ws.studynetty.ChatWithEachOther.protocol.response;


import com.ws.studynetty.ChatWithEachOther.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.send_receive.protocol.command.Command.MESSAGE_RESPONSE;


@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

    private String message;

    /**
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
