package com.ws.studynetty.GroupChat.attribute;

import com.ws.studynetty.GroupChat.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}