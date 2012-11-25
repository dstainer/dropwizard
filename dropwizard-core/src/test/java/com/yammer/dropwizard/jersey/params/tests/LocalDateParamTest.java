package com.yammer.dropwizard.jersey.params.tests;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.failBecauseExceptionWasNotThrown;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.yammer.dropwizard.jersey.params.LocalDateParam;

public class LocalDateParamTest {

	@Test
	public void validDateReturnsLocalDate() {
		
		final String date = "2012-11-21";
		final LocalDate expectedDate = new LocalDate(date);
		
		final LocalDateParam localDateParam = new LocalDateParam(date);
		LocalDate actualDate = localDateParam.get();
		
		assertThat(actualDate)
			.isEqualTo(expectedDate);
	}

	@Test
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
	public void invalidDateValueThrowsException() {
		try {
			new LocalDateParam("foo");
			failBecauseExceptionWasNotThrown(WebApplicationException.class);
		} catch (WebApplicationException e) {
            final Response response = e.getResponse();

            assertThat(response.getStatus())
                    .isEqualTo(400);

            assertThat((String) response.getEntity())
                    .isEqualTo("\"foo\" is not a valid date, or date format (yyyy-mm-dd).");
			
		}
	}
	
	@Test
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
	public void invalidDateFormatThrowsException() {
		try {
			new LocalDateParam("11-21-2012");
			failBecauseExceptionWasNotThrown(WebApplicationException.class);
		} catch (WebApplicationException e) {
            final Response response = e.getResponse();

            assertThat(response.getStatus())
                    .isEqualTo(400);

            assertThat((String) response.getEntity())
                    .isEqualTo("\"11-21-2012\" is not a valid date, or date format (yyyy-mm-dd).");
			
		}
	}
	
}
