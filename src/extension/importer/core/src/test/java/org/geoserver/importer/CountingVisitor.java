/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.importer;

import org.geoserver.importer.ImportStore.ImportVisitor;

public class CountingVisitor implements ImportVisitor {

    int count = 0;

    @Override
    public void visit(ImportContext context) {
        count++;
    }

    public int getCount() {
        return count;
    }
}
