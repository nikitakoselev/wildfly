/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.clustering.jgroups.subsystem;

import java.util.HashMap;
import java.util.Map;

import org.jboss.as.clustering.controller.Attribute;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;

public enum XMLAttribute {
    // must be first
    UNKNOWN(""),

    ALGORITHM(DigestAuthTokenResourceDefinition.Attribute.ALGORITHM),
    CHANNEL(RemoteSiteResourceDefinition.Attribute.CHANNEL),
    CLIENT_SOCKET_BINDING(SocketProtocolResourceDefinition.Attribute.CLIENT_SOCKET_BINDING),
    CLUSTER(ChannelResourceDefinition.Attribute.CLUSTER),
    DATA_SOURCE(JDBCProtocolResourceDefinition.Attribute.DATA_SOURCE),
    @Deprecated DEFAULT_EXECUTOR("default-executor"),
    DEFAULT("default"),
    DIAGNOSTICS_SOCKET_BINDING(TransportResourceDefinition.Attribute.DIAGNOSTICS_SOCKET_BINDING),
    KEEPALIVE_TIME(ThreadPoolResourceDefinition.DEFAULT.getKeepAliveTime()),
    KEY_ALIAS(EncryptProtocolResourceDefinition.Attribute.KEY_ALIAS),
    KEY_STORE(EncryptProtocolResourceDefinition.Attribute.KEY_STORE),
    MACHINE(TransportResourceDefinition.Attribute.MACHINE),
    MAX_THREADS(ThreadPoolResourceDefinition.DEFAULT.getMaxThreads()),
    MIN_THREADS(ThreadPoolResourceDefinition.DEFAULT.getMinThreads()),
    MODULE(AbstractProtocolResourceDefinition.Attribute.MODULE),
    NAME(ModelDescriptionConstants.NAME),
    @Deprecated OOB_EXECUTOR("oob-executor"),
    OUTBOUND_SOCKET_BINDINGS(SocketDiscoveryProtocolResourceDefinition.Attribute.OUTBOUND_SOCKET_BINDINGS),
    QUEUE_LENGTH("queue-length"),
    RACK(TransportResourceDefinition.Attribute.RACK),
    @Deprecated SHARED("shared"),
    SITE(TransportResourceDefinition.Attribute.SITE),
    SOCKET_BINDING(MulticastProtocolResourceDefinition.Attribute.SOCKET_BINDING),
    STACK(ChannelResourceDefinition.Attribute.STACK),
    STATISTICS_ENABLED(ChannelResourceDefinition.Attribute.STATISTICS_ENABLED),
    @Deprecated THREAD_FACTORY("thread-factory"),
    @Deprecated TIMER_EXECUTOR("timer-executor"),
    TYPE(ModelDescriptionConstants.TYPE),
    ;

    private final String name;

    XMLAttribute(Attribute attribute) {
        this(attribute.getDefinition().getXmlName());
    }

    XMLAttribute(String name) {
        this.name = name;
    }

    /**
     * Get the local name of this element.
     *
     * @return the local name
     */
    public String getLocalName() {
        return this.name;
    }

    private static final Map<String, XMLAttribute> attributes = new HashMap<>();

    static {
        for (XMLAttribute attribute : values()) {
            String name = attribute.getLocalName();
            if (name != null) {
                attributes.put(name, attribute);
            }
        }
    }

    public static XMLAttribute forName(String localName) {
        XMLAttribute attribute = attributes.get(localName);
        return (attribute != null) ? attribute : UNKNOWN;
    }
}
