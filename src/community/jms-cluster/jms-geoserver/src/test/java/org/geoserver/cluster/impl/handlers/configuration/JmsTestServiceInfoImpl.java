/* (c) 2017 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.cluster.impl.handlers.configuration;

import org.geoserver.config.impl.ServiceInfoImpl;

/** Simple test service implementation. */
public class JmsTestServiceInfoImpl extends ServiceInfoImpl implements JmsTestServiceInfo {
    @Override
    public String getType() {
        return "Jms";
    }
}
