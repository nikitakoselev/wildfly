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

package org.jboss.as.server;

import org.jboss.dmr.ModelNode;
import org.jboss.msc.service.ServiceTarget;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public interface NewOperationContext {

    /**
     * Get the operation being executed.
     *
     * @return the operation
     */
    ModelNode getOperation();

    /**
     * Get the booting server controller.
     *
     * @return the server controller
     */
    NewServerController getServerController();

    /**
     * Get the target to which new services may be added.
     *
     * @return the service target
     */
    ServiceTarget getServiceTarget();

    /**
     * Get the a view of the sub-model that this operation affects, if it does affect
     * a model element.
     *
     * @return the sub-model view, may be empty
     */
    ModelNode getSubModel();
}
