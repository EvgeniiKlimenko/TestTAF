package org.faska.domain;

import io.restassured.response.Response;
import org.faska.api.catfacts.CatFactApi;
import org.faska.api.catfacts.CatFactsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is a mid level service between low level service class and tests' implementations.
 * Works with responses, filtering response data, additional preparations for request,
 * complex requests and all actions like these live here.
 */
@Service
public class CatFactsService {

    @Autowired
    private final CatFactApi catFactApi;

    public CatFactsService(CatFactApi catFactApi) {
        this.catFactApi = catFactApi;
    }

    public CatFactsResponse getCatFacts() {
        return catFactApi.getCatFacts();
    }

    public List<String> optionsCatFacts() {
        Response rawResp = catFactApi.optionsCatFacts();
        String options = rawResp.headers().getValue("Allow");
        return List.of(options.split(","));
    }

    public void headCatFacts() {
        catFactApi.headCatFacts();
    }
}
