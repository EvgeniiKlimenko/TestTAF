package org.faska.tests;

import org.faska.api.catfacts.CatFactsResponse;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatFactsTest extends AbstractTestContextTests {
    private static final List<String> EXPECTED_OPTIONS = List.of("GET", "HEAD");

    @Test(description = "Test OPTIONS request to service")
    public void catFactsOptionsCheckTest() {
        List<String> availableOptions = catFactsService.optionsCatFacts();
        assertThat(availableOptions)
                .containsAll(EXPECTED_OPTIONS);
        System.out.println("<==== OPTIONS is done!\n");
    }

    @Test(description = "Test OPTIONS request to service")
    public void catFactsHeadRequestTest() {
        catFactsService.headCatFacts();
        System.out.println("<==== HEAD is done!\n");
    }

    @Test(description = "Test GET request to service")
    public void catFactsGetFactTest() {
        CatFactsResponse facts = catFactsService.getCatFacts();

        System.out.println("<==== GET is done!\n");
    }

}
