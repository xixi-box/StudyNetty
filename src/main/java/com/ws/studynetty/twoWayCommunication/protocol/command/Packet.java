package com.ws.studynetty.twoWayCommunication.protocol.command;

import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();
}