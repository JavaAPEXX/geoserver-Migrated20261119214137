/* (c) 2022 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.security.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractAccesRuleDAOConcurrencyTest<D extends AbstractAccessRuleDAO> {

    protected static final int DEFAULT_LOOPS = 10000;
    private static final int THREADS = 4;
    D dao;
    private ExecutorService executors;

    @BeforeEach
    public void setUp() throws Exception {
        dao = buildDAO();

        executors = Executors.newFixedThreadPool(THREADS);
    }

    /**
     * Builds the DAO that will be tested
     *
     * @return
     */
    protected abstract D buildDAO() throws Exception;

    @AfterEach
    public void shutdown() {
        executors.shutdown();
    }

    @Test
    public void testConcurrentModifications() throws Exception {
        // REST operations change the contents of the DAO by using
        List<Callable<Void>> manipulators = IntStream.range(1, getLoops())
                .mapToObj(c -> (Callable<Void>) () -> manipulate(c))
                .collect(Collectors.toList());

        // run, just check there were no exceptions and no assertion failures
        List<Future<Void>> futures = executors.invokeAll(manipulators);
        for (Future<Void> future : futures) {
            future.get();
        }
    }

    protected int getLoops() {
        // go a little easier, this is writing on the file system
        return DEFAULT_LOOPS;
    }

    /**
     * Performs a read/write manipulation on the DAO contents
     *
     * @param c
     * @return
     */
    protected abstract Void manipulate(int c) throws IOException;
}
