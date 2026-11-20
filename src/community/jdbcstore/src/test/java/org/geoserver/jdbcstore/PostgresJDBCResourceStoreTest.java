/* (c) 2015 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.jdbcstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 * @author Kevin Smith, Boundless
 * @author Niels Charlier
 */
@Disabled
public class PostgresJDBCResourceStoreTest extends AbstractJDBCResourceStoreTest {

    @BeforeEach
    public void setUp() throws Exception {
        support = new PostgresTestSupport();
    }
}
