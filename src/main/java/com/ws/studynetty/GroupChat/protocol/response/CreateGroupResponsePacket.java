package com.ws.studynetty.GroupChat.protocol.response;

import com.ws.studynetty.GroupChat.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.ws.studynetty.GroupChat.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/10/12 15:08
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_RESPONSE;
    }
}
