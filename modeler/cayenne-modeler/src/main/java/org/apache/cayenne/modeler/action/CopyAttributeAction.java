/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.modeler.action;

import java.util.Arrays;

import org.apache.cayenne.configuration.ConfigurationNode;
import org.apache.cayenne.map.Attribute;
import org.apache.cayenne.map.EmbeddableAttribute;
import org.apache.cayenne.modeler.Application;
import org.apache.cayenne.modeler.ProjectController;

/**
 * Action for copying attribute(s)
 */
public class CopyAttributeAction extends CopyAction implements MultipleObjectsAction {

    private final static String ACTION_NAME = "Copy Attribute";

    /**
     * Name of action if multiple attrs are selected
     */
    private final static String ACTION_NAME_MULTIPLE = "Copy Attributes";

    public static String getActionName() {
        return ACTION_NAME;
    }

    public String getActionName(boolean multiple) {
        return multiple ? ACTION_NAME_MULTIPLE : ACTION_NAME;
    }

    public CopyAttributeAction(Application application) {
        super(ACTION_NAME, application);
    }

    /**
     * Returns <code>true</code> if last object in the path contains a removable
     * attribute.
     */
    @Override
    public boolean enableForPath(ConfigurationNode object) {
        if (object == null) {
            return false;
        }
        boolean isEnable = object instanceof Attribute;
        if (!isEnable) {
            isEnable = object instanceof EmbeddableAttribute;
        }

        return isEnable;
    }

    @Override
    public Object copy(ProjectController mediator) {
        Object[] attrs = getProjectController().getCurrentObjAttributes();
        if (attrs == null || attrs.length == 0) {
            attrs = getProjectController().getCurrentDbAttributes();
        }
        if (attrs == null || attrs.length == 0) {
            attrs = getProjectController().getCurrentEmbAttributes();
        }

        if (attrs != null && attrs.length > 0) {
            return Arrays.asList(attrs);
        }

        return null;
    }
}
