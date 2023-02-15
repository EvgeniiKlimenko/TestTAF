package org.faska.api.coindesk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CoinDeskApi {
    private static final String COIN_DESK_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public void headCoinDeskInfo() {
        RestAssured.when()
                .head(COIN_DESK_URL).prettyPeek()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public CoinDeskResponse getCoinDesk() {
        Response rawResp = RestAssured.given()
                .contentType("application/javascript")
                .when()
                .get(COIN_DESK_URL).prettyPeek()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract().response();

        String rawBody = rawResp.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(rawBody, CoinDeskResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Response optionsCoinDeskInfo() {
        return RestAssured.when()
                .options(COIN_DESK_URL).prettyPeek()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.HTML)
                .extract().response();
    }
}
