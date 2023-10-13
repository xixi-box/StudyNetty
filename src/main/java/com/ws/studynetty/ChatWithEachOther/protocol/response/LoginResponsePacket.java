package com.ws.studynetty.ChatWithEachOther.protocol.response;


import com.ws.studynetty.ChatWithEachOther.protocol.Packet;
import com.ws.studynetty.ChatWithEachOther.protocol.command.Command;
import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String username;

    private Boolean success;
    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}