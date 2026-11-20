// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.gwc.web.diskquota;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.wicket.model.Model;
import org.geoserver.web.ComponentBuilder;
import org.geoserver.web.FormTestPage;
import org.geoserver.web.GeoServerWicketTestSupport;
import org.geowebcache.diskquota.jdbc.JDBCConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JDBCConnectionPoolPanelTest extends GeoServerWicketTestSupport {

    @BeforeEach
    public void setUp() {
        login();
    }

    @Test
    public void configPageRendersSuccessfully() {
        // start and render the test page
        JDBCConfiguration.ConnectionPoolConfiguration pool = new JDBCConfiguration.ConnectionPoolConfiguration();
        pool.setDriver("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:file:./target/quota-hsql");
        pool.setUsername("sa");
        pool.setPassword("actaulpassword");
        pool.setMinConnections(1);
        pool.setMaxConnections(1);
        pool.setMaxOpenPreparedStatements(50);
        Model<JDBCConfiguration.ConnectionPoolConfiguration> pwModel = new Model<>(pool);
        FormTestPage testPage = new FormTestPage((ComponentBuilder) id -> new JDBCConnectionPoolPanel(id, pwModel));
        tester.startPage(testPage);

        // check the password is not visible in source
        String text = tester.getLastResponseAsString();
        assertThat(text, not(containsString(pool.getPassword())));
    }
}
