package com.ws.studynetty.send_receive.protocol.response;


import com.ws.studynetty.send_receive.protocol.Packet;
import com.ws.studynetty.send_receive.protocol.command.Command;
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