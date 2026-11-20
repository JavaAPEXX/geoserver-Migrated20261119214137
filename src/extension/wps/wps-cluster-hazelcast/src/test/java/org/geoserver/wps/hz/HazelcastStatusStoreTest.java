/* (c) 2017 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.wps.hz;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.test.TestHazelcastInstanceFactory;
import org.geoserver.wps.AbstractProcessStoreTest;
import org.geoserver.wps.ProcessStatusStore;
import org.junit.jupiter.api.AfterEach;

/**
 * Tests the hazelcast based process status store with a single hazelcast instance
 *
 * @author Andrea Aime - GeoSolutions
 */
public class HazelcastStatusStoreTest extends AbstractProcessStoreTest {

    private TestHazelcastInstanceFactory factory;

    @Override
    protected ProcessStatusStore buildStore() {
        // build a hazelcast instance isolated from the network
        Config config = new Config();
        config.addMapConfig(new MapConfig(HazelcastStatusStore.EXECUTION_STATUS_MAP));
        factory = new TestHazelcastInstanceFactory(1);
        HazelcastInstance instance = factory.newHazelcastInstance(config);
        HazelcastLoader loader = new HazelcastLoader(instance);
        return new HazelcastStatusStore(loader);
    }

    @AfterEach
    public void shutdown() {
        factory.shutdownAll();
    }
}
