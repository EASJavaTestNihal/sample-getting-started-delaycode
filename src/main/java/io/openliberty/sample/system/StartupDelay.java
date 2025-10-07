/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/

package io.openliberty.sample.system;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class StartupDelay {
    
    private static final Logger LOGGER = Logger.getLogger(StartupDelay.class.getName());
    
    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        LOGGER.info("Starting application deployment delay of 60 seconds for MP_Health testing...");
        try {
            // 60-second delay
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe("Deployment delay was interrupted: " + e.getMessage());
        }
        LOGGER.info("Deployment delay complete, application continuing startup");
    }
}
