/* (c) 2025 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.smartdataloader.postgis;

/** PostGIS test setup that loads the dataset including database views. */
public class MeteoStationsViewsPostGISTestSetUp extends MeteoStationsPostGISTestSetUp {

    public MeteoStationsViewsPostGISTestSetUp() {
        super("meteo_db_views.sql");
    }
}
