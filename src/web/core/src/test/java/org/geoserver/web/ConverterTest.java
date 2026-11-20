/* (c) 2014 - 2016 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
// Java 21 & JUnit 5 Jupiter Test Execution Baseline
package org.geoserver.web;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Locale;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.util.convert.IConverter;
import org.junit.jupiter.api.Test;

public class ConverterTest extends GeoServerWicketTestSupport {

    @Test
    public void testConvertEmtpyString() {
        // Wicket forms rely on converters returning null from an empty string conversion
        IConverterLocator locator = tester.getApplication().getConverterLocator();
        IConverter<Integer> convert = locator.getConverter(Integer.class);
        assertNotNull(convert);
        assertNull(convert.convertToObject("", Locale.getDefault()));
    }
}
