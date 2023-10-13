package com.ws.studynetty.GroupChat.protocol.request;

import com.ws.studynetty.GroupChat.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.ws.studynetty.GroupChat.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/10/12 15:02
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
