/* (c) 2014 - 2015 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.csw;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.geoserver.data.test.SystemTestData;
import org.geoserver.test.DevModeEntityResolver;
import org.geoserver.util.EntityResolverProvider;
import org.geotools.util.NullEntityResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class CSWSimpleTestSupport extends CSWTestSupport {
    protected static final String BASEPATH = "csw";

    @BeforeEach
    public void setUp() throws Exception {
        EntityResolverProvider.setEntityResolver(NullEntityResolver.INSTANCE);
    }

    @AfterEach
    public void tearDown() throws Exception {
        EntityResolverProvider.setEntityResolver(DevModeEntityResolver.INSTANCE);
    }

    @Override
    protected void setUpTestData(SystemTestData testData) throws Exception {
        testData.setUpSecurity();
        System.setProperty("DefaultCatalogStore", "org.geoserver.csw.store.simple.GeoServerSimpleCatalogStore");

        // copy all records into the data directory
        File root = testData.getDataDirectoryRoot();
        File catalog = new File(root, "catalog");
        File records = new File("./src/test/resources/org/geoserver/csw/records");
        FileUtils.copyDirectory(records, catalog);
    }
}
