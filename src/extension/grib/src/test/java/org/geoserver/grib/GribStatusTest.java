/* (c) 2016 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.grib;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class GribStatusTest {
    @Test
    public void testNetCDFStatus() {
        GribStatus status = new GribStatus();

        // these should always return "something"
        assertTrue(status.getModule().length() > 0);
        assertTrue(status.getName().length() > 0);
        assertTrue(status.getComponent().get().length() > 0);
        assertTrue(status.getMessage().get().length() > 0);

        assertTrue(status.getVersion().isPresent());
        assertTrue(status.getMessage().get().contains("isGribAvailable"));
    }
}
