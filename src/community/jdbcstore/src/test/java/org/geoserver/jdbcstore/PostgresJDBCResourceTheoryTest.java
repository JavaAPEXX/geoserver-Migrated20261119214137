/* (c) 2015 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.jdbcstore;

import static org.easymock.EasyMock.*;

import org.geoserver.jdbcstore.cache.SimpleResourceCache;
import org.geoserver.jdbcstore.internal.JDBCResourceStoreProperties;
import org.geoserver.platform.resource.NullLockProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 * @author Kevin Smith, Boundless
 * @author Niels Charlier
 */
@Disabled
public class PostgresJDBCResourceTheoryTest extends AbstractJDBCResourceTheoryTest {

    JDBCResourceStore store;

    @Override
    protected JDBCResourceStore getStore() {
        return store;
    }

    @BeforeEach
    public void setUp() throws Exception {
        support = new PostgresTestSupport();

        standardData();

        JDBCResourceStoreProperties config = mockConfig(true, false);
        replay(config);

        store = new JDBCResourceStore(support.getDataSource(), config);
        store.setLockProvider(new NullLockProvider());
        store.setCache(new SimpleResourceCache(folder.getRoot()));
    }
}
