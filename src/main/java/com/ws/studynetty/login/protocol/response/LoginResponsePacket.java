package com.ws.studynetty.login.protocol.response;

import com.ws.studynetty.login.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.login.protocol.command.Command.LOGIN_RESPONSE;


@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}