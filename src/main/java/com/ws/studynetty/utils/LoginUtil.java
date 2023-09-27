package com.ws.studynetty.utils;

import com.ws.studynetty.twoWayCommunication.protocol.command.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginArr = channel.attr(Attributes.LOGIN);
        return loginArr.get() != null;
    }
}
