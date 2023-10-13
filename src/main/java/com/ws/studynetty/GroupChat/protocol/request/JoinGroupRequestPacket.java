package com.ws.studynetty.GroupChat.protocol.request;

import com.ws.studynetty.GroupChat.protocol.Packet;
import com.ws.studynetty.GroupChat.protocol.command.Command;

import lombok.Data;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/10/12 15:48
 */
@Data
public class JoinGroupRequestPacket extends Packet {
    private String groupId;

    /**
     * @return
     */
    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_REQUEST;
    }
}
