package com.ws.studynetty.ChatWithEachOther.protocol.request;


import com.ws.studynetty.ChatWithEachOther.protocol.Packet;
import com.ws.studynetty.ChatWithEachOther.protocol.command.Command;
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