/* (c) 2019 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.importer.jdbc;

import static org.hamcrest.MatcherAssert.assertThat;

import org.geoserver.importer.rest.ImportControllerTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GpkgImportControllerTest extends ImportControllerTest {

    @Test
    public void testJdbcImportStore() {
        assertThat(importer.getStore(), CoreMatchers.instanceOf(JDBCImportStore.class));
    }

    @Override
    @Disabled
    @Test
    public void testPutWithId() throws Exception {
        super.testPutWithId();
    }

    @Override
    @Disabled
    @Test
    public void testPutWithIdNoContentType() throws Exception {
        super.testPutWithIdNoContentType();
    }
}
