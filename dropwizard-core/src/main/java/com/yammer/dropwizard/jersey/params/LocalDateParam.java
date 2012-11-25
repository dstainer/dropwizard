package com.yammer.dropwizard.jersey.params;

import org.joda.time.LocalDate;

/**
 * A parameter that specifically deals with date's only. The acceptable format
 * required for parameters follows the ISO8601 standard for dates and uses a 
 * yyyy-mm-dd format. All non-parsable values or values which are malformed will 
 * return a {@code 400 Bad Request} response.
 */
public class LocalDateParam extends AbstractParam<LocalDate> {
	
    public LocalDateParam(String input) {
        super(input);
    }

    @Override
    protected String errorMessage(String input, Exception e) {
        return '"' + input + "\" is not a valid date, or date format (yyyy-mm-dd).";
    }
    
    @Override
    protected LocalDate parse(String input) throws Exception {
        return new LocalDate(input);
    }
}
