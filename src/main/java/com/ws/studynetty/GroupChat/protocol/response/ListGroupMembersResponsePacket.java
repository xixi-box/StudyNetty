package com.ws.studynetty.GroupChat.protocol.response;

import com.ws.studynetty.GroupChat.protocol.Packet;
import com.ws.studynetty.GroupChat.session.Session;
import lombok.Data;

import java.util.List;

import static com.ws.studynetty.GroupChat.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}