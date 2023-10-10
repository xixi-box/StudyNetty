package com.ws.studynetty.HotPlug.protocol.request;

import com.ws.studynetty.HotPlug.protocol.Packet;
import lombok.Data;

import static com.ws.studynetty.HotPlug.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
