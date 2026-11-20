/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.test;

/** @author Niels Charlier, Curtin University Of Technology */
public class InvalidColumnTestData extends AbstractAppSchemaMockData {

    /** @see org.geoserver.test.AbstractAppSchemaMockData#addContent() */
    @Override
    public void addContent() {
        addFeatureType(
                GSML_PREFIX, "GeologicUnit", "InvalidColumnGeologicUnit.xml", "InvalidColumnGeologicUnit.properties");
    }
}
