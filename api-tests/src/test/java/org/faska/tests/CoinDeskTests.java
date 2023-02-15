package org.faska.tests;

import org.assertj.core.api.Assertions;
import org.faska.api.coindesk.CoinDeskResponse;
import org.testng.annotations.Test;

import java.util.List;

public class CoinDeskTests extends AbstractTestContextTests {
    private static final List<String> EXPECTED_OPTIONS = List.of("GET");

    @Test(description = "Check options of service")
    public void coinDeskOptionsTest() {
        List<String> options = coinDeskService.getOptions();
        Assertions.assertThat(options)
                .containsAll(EXPECTED_OPTIONS);
    }

    @Test(description = "Response should contain expected data about bitcoin")
    public void checkBitCoinIndex() {
        CoinDeskResponse resp = coinDeskService.getCoinDeskInfo();
        Assertions.assertThat(resp).isNotNull();
    }

    @Test(description = "Check HEAD request of service as a health check")
    public void coinDeskHealthCheckTest() {
        coinDeskService.healthCheck();
    }
}
