package com.ws.studynetty.GroupChat.protocol.request;

import com.ws.studynetty.GroupChat.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.GroupChat.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}