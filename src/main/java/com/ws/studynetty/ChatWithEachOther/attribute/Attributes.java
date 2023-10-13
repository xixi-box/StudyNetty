package com.ws.studynetty.ChatWithEachOther.attribute;

import com.ws.studynetty.ChatWithEachOther.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}