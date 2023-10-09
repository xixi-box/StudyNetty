package com.ws.studynetty.send_receive.protocol.request;


import com.ws.studynetty.send_receive.protocol.Packet;
import com.ws.studynetty.send_receive.protocol.command.Command;
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