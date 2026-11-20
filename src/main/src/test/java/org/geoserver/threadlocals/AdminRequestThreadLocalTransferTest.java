/* (c) 2017 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.threadlocals;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.concurrent.ExecutionException;
import org.geoserver.security.AdminRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AdminRequestThreadLocalTransferTest extends AbstractThreadLocalTransferTest {

    @AfterEach
    public void cleanupThreadLocals() {
        AdminRequest.finish();
    }

    @Test
    public void testAdminRequest() throws InterruptedException, ExecutionException {
        // setup the state
        final Object myState = new Object();
        AdminRequest.start(myState);
        // test it's transferred properly using the base class machinery
        testThreadLocalTransfer(new ThreadLocalTransferCallable(new AdminRequestThreadLocalTransfer()) {

            @Override
            void assertThreadLocalCleaned() {
                assertNull(AdminRequest.get());
            }

            @Override
            void assertThreadLocalApplied() {
                assertSame(myState, AdminRequest.get());
            }
        });
    }
}
