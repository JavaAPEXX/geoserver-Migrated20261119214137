// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.smartdataloader.postgis;

import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class MeteoStationsPostGISTestSetUp extends PostGISTestSetUp {

    protected final String meteoSqlScriptFileName;

    public MeteoStationsPostGISTestSetUp() {
        this("meteo_db.sql");
    }

    public MeteoStationsPostGISTestSetUp(String sqlScriptFileName) {
        this.meteoSqlScriptFileName = sqlScriptFileName;
    }

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setUpData();
    }

    @Override
    protected void setUpData() throws Exception {
        super.setUpData();

        String sql = IOUtils.toString(
                getClass().getResourceAsStream("./mockdata/" + meteoSqlScriptFileName), Charset.defaultCharset());
        run(sql);
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        dropSchema();
        if (!getDataSource().getConnection().isClosed())
            getDataSource().getConnection().close();
    }
}
