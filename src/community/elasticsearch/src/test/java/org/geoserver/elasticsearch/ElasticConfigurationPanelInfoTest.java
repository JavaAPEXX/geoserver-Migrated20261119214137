// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.elasticsearch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.easymock.EasyMock;
import org.geoserver.catalog.DataStoreInfo;
import org.geoserver.catalog.FeatureTypeInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElasticConfigurationPanelInfoTest {

    private static final String ELASTIC_SEARCH = "ElasticSearch";
    private ElasticConfigurationPanelInfo info;

    @BeforeEach
    public void setupInfo() {
        info = new ElasticConfigurationPanelInfo();
        info.setSupportedTypes(Arrays.asList("ElasticSearch"));
    }

    @Test
    public void canHandleNullTolerance() {
        DataStoreInfo ds = EasyMock.createNiceMock(DataStoreInfo.class);
        FeatureTypeInfo ft = EasyMock.createNiceMock(FeatureTypeInfo.class);
        EasyMock.expect(ft.getStore()).andReturn(ds);
        EasyMock.replay(ft, ds);

        assertFalse(info.canHandle(ft));
    }

    @Test
    public void canHandle() {
        DataStoreInfo ds = EasyMock.createNiceMock(DataStoreInfo.class);
        FeatureTypeInfo ft = EasyMock.createNiceMock(FeatureTypeInfo.class);
        EasyMock.expect(ft.getStore()).andReturn(ds);
        EasyMock.expect(ds.getType()).andReturn(ELASTIC_SEARCH);
        EasyMock.replay(ft, ds);

        assertTrue(info.canHandle(ft));
    }
}
