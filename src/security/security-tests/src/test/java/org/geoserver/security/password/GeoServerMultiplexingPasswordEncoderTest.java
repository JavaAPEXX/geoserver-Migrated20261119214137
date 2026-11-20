/* (c) 2017 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.security.password;

import static org.junit.Assert.fail;

import org.geoserver.test.GeoServerMockTestSupport;
import org.junit.jupiter.api.Test;

public class GeoServerMultiplexingPasswordEncoderTest extends GeoServerMockTestSupport {

    @Test
    public void testEncode() {
        GeoServerMultiplexingPasswordEncoder pwe = new GeoServerMultiplexingPasswordEncoder(getSecurityManager());
        try {
            pwe.encodePassword("foo", null);
        } catch (Exception e) {
            fail("Multiplexing encoder should be capabile of encoding");
        }
    }
}
