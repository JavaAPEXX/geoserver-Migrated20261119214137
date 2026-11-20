// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.taskmanager.data;

import java.io.Serializable;
import org.geoserver.taskmanager.data.impl.BatchImpl;
import org.geoserver.taskmanager.data.impl.BatchRunImpl;

public interface LatestBatchRun extends Serializable {

    BatchRunImpl getBatchRun();

    BatchImpl getBatch();
}
