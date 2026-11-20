/* (c) 2019 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.metadata.web;

import static org.junit.Assert.assertEquals;

import org.apache.wicket.MarkupContainer;
import org.geoserver.catalog.LayerInfo;
import org.geoserver.data.test.MockData;
import org.geoserver.metadata.AbstractWicketMetadataTest;
import org.geoserver.web.data.resource.ResourceConfigurationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ConditionTest extends AbstractWicketMetadataTest {

    @Override
    protected boolean setupDataDirectory() throws Exception {
        DATA_DIRECTORY.addWcs10Coverages();
        return true;
    }

    @AfterEach
    @Override
    public void stop() throws Exception {
        restoreLayers();
        super.stop();
    }

    @Test
    public void testNoFeatureCatalogueForRasters() {

        login();
        LayerInfo raster = geoServer.getCatalog().getLayerByName(MockData.USA_WORLDIMG.getLocalPart());
        ResourceConfigurationPage page = new ResourceConfigurationPage(raster, false);
        tester.startPage(page);
        navigateToMetadataTab();

        MarkupContainer c = (MarkupContainer) tester.getComponentFromLastRenderedPage(
                "publishedinfo:tabs:panel:metadataPanel:attributesPanel:attributesTablePanel:listContainer:items");
        assertEquals(14, c.size());
        logout();
    }
}
