package org.faska.domain;

import io.restassured.response.Response;
import org.faska.api.coindesk.CoinDeskApi;
import org.faska.api.coindesk.CoinDeskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinDeskService {
    @Autowired
    private final CoinDeskApi coinDeskApi;

    public CoinDeskService(CoinDeskApi coinDeskApi) {
        this.coinDeskApi = coinDeskApi;
    }

    public CoinDeskResponse getCoinDeskInfo() {
        return coinDeskApi.getCoinDesk();
    }

    public void healthCheck() {
        coinDeskApi.headCoinDeskInfo();
    }

    public List<String> getOptions() {
        Response rawResp = coinDeskApi.optionsCoinDeskInfo();
        String rawOptions = rawResp.headers().getValue("Allow");
        return List.of(rawOptions.split(","));
    }

}
