package com.ws.studynetty.DeclarationPeriodOfChannelHandler.attribute;

import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}