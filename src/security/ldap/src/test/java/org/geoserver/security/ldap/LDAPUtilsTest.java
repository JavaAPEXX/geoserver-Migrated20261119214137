/* (c) 2023 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.security.ldap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/** @author Eddy Scheper */
public class LDAPUtilsTest {
    @Test
    public void testSearchString() {
        Assert.assertEquals("", LDAPUtils.escapeSearchString(""));
        Assert.assertEquals("Smith", LDAPUtils.escapeSearchString("Smith"));
        Assert.assertEquals("Smith\\\\, John", LDAPUtils.escapeSearchString("Smith\\, John"));
    }
}
