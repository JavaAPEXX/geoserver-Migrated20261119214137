/* (c) 2023 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.metadata;

import org.apache.wicket.util.file.File;
import org.geoserver.metadata.data.service.impl.ConfigurationServiceImpl;
import org.geoserver.metadata.web.MetadataTemplatesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Tests that metadata module works 'out of the box', without any configuration present yet. */
public class EmptyConfigurationTest extends AbstractWicketMetadataTest {

    @Autowired
    protected ConfigurationServiceImpl configService;

    private File metadataRenamed = new File(DATA_DIRECTORY.getDataDirectoryRoot(), "metadata.renamed");

    @BeforeEach
    public void initEmptyConfiguration() throws Exception {
        metadata.renameTo(metadataRenamed);
    }

    @AfterEach
    public void restoreConfiguration() throws Exception {
        metadataRenamed.renameTo(metadata);
        configService.reload();
    }

    @Test
    public void testRenderPage() {
        // just check if a page is rendered

        login();

        // Load the page
        MetadataTemplatesPage page = new MetadataTemplatesPage();
        tester.startPage(page);
        tester.assertRenderedPage(MetadataTemplatesPage.class);

        logout();
    }
}
