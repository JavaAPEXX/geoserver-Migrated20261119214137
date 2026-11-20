/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.test.onlineTest;

import org.geoserver.test.onlineTest.setup.AppSchemaReferenceMockData;
import org.geoserver.test.onlineTest.setup.ReferenceDataOracleSetup;
import org.geoserver.test.onlineTest.support.AbstractReferenceDataSetup;

/** @author Victor Tey(CSIRO Earth Science and Resource Engineering) */
public class DataReferenceWfsOracleWithJoiningTest extends DataReferenceWfsOnlineTest {

    public DataReferenceWfsOracleWithJoiningTest() throws Exception {
    }

    @Override
    protected AppSchemaReferenceMockData createTestData() {
        return new AppSchemaReferenceMockData();
    }

    @Override
    public AbstractReferenceDataSetup getReferenceDataSetup() throws Exception {
        return new ReferenceDataOracleSetup();
    }
}
