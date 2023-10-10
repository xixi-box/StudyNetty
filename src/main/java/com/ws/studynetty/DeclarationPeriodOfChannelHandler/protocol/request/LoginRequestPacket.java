package com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.request;


import com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.Packet;
import com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.command.Command;
import lombok.Data;


@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;
    private Boolean success;
    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}