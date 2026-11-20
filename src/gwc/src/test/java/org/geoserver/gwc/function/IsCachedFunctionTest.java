/* (c) 2019 Open Source Geospatial Foundation - all rights reserved
 *
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.gwc.function;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.geoserver.catalog.LayerInfo;
import org.geoserver.gwc.GWC;
import org.geoserver.gwc.GWCSynchEnv;
import org.geotools.api.filter.expression.Function;
import org.geotools.filter.FilterFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsCachedFunctionTest {

    private GWC mockGWC;

    private GWCSynchEnv mockGWCSynchEnv;

    private LayerInfo layerInfo;

    @BeforeEach
    public void setUp() throws Exception {
        mockGWC = mock(GWC.class);
        mockGWCSynchEnv = mock(GWCSynchEnv.class);
        GWC.set(mockGWC, mockGWCSynchEnv);
        layerInfo = mock(LayerInfo.class);

        when(mockGWC.hasTileLayer(eq(layerInfo))).thenReturn(true);
    }

    @AfterEach
    public void tearDown() throws Exception {
        GWC.set(null, null);
    }

    @Test
    public void testIsCachedFunction() {
        FilterFactoryImpl ff = new FilterFactoryImpl();

        Function exp = ff.function("isCached", ff.property("."));
        Boolean value = (Boolean) exp.evaluate(layerInfo);
        assertTrue(value);
    }
}
