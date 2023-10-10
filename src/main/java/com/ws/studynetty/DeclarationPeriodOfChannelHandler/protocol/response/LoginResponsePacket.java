package com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.response;


import com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.Packet;
import com.ws.studynetty.DeclarationPeriodOfChannelHandler.protocol.command.Command;
import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String username;

    private String password;
    private Boolean success;
    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}