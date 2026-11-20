/* (c) 2024 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.security.oauth2.token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

/** tests for {@link JwsAlgorithmNameParser}. */
public class JwsAlgorithmNameParserTest {

    private JwsAlgorithmNameParser sut = new JwsAlgorithmNameParser();

    @Test
    public void testParse() {
        assertNull(sut.parse("GeoServer"));
        assertNull(sut.parse(null));
        assertNull(sut.parse(" "));
        assertNotNull(sut.parse("RS256"));
        assertEquals("RS256", sut.parse("RS256").getName());
        assertNotNull(sut.parse("HS256"));
        assertEquals("HS256", sut.parse("HS256").getName());
    }
}
