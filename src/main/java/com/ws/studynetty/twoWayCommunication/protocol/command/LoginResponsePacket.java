package com.ws.studynetty.twoWayCommunication.protocol.command;

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
        return Command.LOGIN_REQUEST;
    }
}