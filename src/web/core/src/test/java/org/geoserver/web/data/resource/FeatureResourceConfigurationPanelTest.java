/* (c) 2015 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.web.data.resource;

import org.apache.wicket.model.IModel;
import org.geoserver.catalog.FeatureTypeInfo;
import org.geoserver.data.test.MockData;
import org.geoserver.web.GeoServerWicketTestSupport;
import org.junit.jupiter.api.Test;

public class FeatureResourceConfigurationPanelTest extends GeoServerWicketTestSupport {
    @Test()
    public void testResourceUpdatedAcceptsNull() {
        FeatureResourceConfigurationPanel panel = new FeatureResourceConfigurationPanel("toto", new IModel() {
            @Override
            public FeatureTypeInfo getObject() {
                return getCatalog().getResourceByName(MockData.BRIDGES.getLocalPart(), FeatureTypeInfo.class);
            }

            @Override
            public void setObject(Object o) {
                throw new RuntimeException("Not implemented");
            }

            @Override
            public void detach() {
                throw new RuntimeException("Not implemented");
            }
        });
        panel.resourceUpdated(null);
    }
}
