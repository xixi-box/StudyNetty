package com.ws.studynetty.GroupChat.protocol.response;

import com.ws.studynetty.GroupChat.protocol.Packet;
import com.ws.studynetty.GroupChat.protocol.command.Command;
import lombok.Data;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/10/12 15:51
 */
@Data
public class JoinGroupResponsePacket extends Packet {
    private boolean success;
    private String groupId;
    private String reason;

    /**
     * @return
     */
    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
