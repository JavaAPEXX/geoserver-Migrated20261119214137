/* (c) 2022 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.test;

/** This class is responsible for containing utility methods for GeoPackage tests. */
public class GeoPackageUtil {

    /**
     * Checks if the running test is geopkg test.
     *
     * @return true if the running test is geopkg.
     */
    public static boolean isGeopkgTest() {
        String onlineTestId = System.getProperty("testDatabase");
        if (onlineTestId != null && "geopkg".equals(onlineTestId)) {
            return true;
        }
        return false;
    }
}
