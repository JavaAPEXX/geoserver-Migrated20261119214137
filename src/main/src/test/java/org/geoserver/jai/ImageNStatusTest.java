/* (c) 2026 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.jai;

import static org.junit.Assert.assertTrue;

import org.geoserver.test.GeoServerSystemTestSupport;
import org.junit.jupiter.api.Test;

public class ImageNStatusTest extends GeoServerSystemTestSupport {

    @Test
    public void testModuleStatus() {
        assertModuleStatus("imagen", "ImageN");
    }

    @Test
    public void testImageNStatus() {
        ImageNStatus status = new ImageNStatus();
        assertTrue(status.getVersion().isPresent());

        String message = status.getMessage().orElseThrow();
        assertTrue(message, message.contains("Tile cache: "));
        assertTrue(message, message.contains("Memory capacity: "));
        assertTrue(message, message.contains("Memory threshold: "));
    }
}
