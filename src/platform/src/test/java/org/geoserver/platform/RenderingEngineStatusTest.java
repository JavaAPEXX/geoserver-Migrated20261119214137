/* (c) 2017 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.platform;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class RenderingEngineStatusTest {

    @Test
    public void RenderingEngineStatusTest() {
        RenderingEngineStatus res = new RenderingEngineStatus();
        assertTrue(res.getMessage().isPresent());
    }
}
