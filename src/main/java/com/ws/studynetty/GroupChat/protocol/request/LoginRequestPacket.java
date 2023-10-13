package com.ws.studynetty.GroupChat.protocol.request;


import com.ws.studynetty.GroupChat.protocol.Packet;
import com.ws.studynetty.GroupChat.protocol.command.Command;
import lombok.Data;


@Data
public class LoginRequestPacket extends Packet {

    private String username;

    private String password;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}