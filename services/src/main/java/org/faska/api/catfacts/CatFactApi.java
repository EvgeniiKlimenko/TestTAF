package org.faska.api.catfacts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * This is a low level service to communicate with service
 */
@Service
public class CatFactApi {

    private static final String CAT_FACTS_URL = "https://catfact.ninja/fact";

    public Response optionsCatFacts() {
        return RestAssured.when()
                .options(CAT_FACTS_URL)
                .prettyPeek()
                .then().assertThat()// assertThat() is not necessary, used just for readability (in my opinion)
                .contentType(ContentType.HTML)
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public void headCatFacts() {
        RestAssured.when()
                .head(CAT_FACTS_URL)
                .prettyPeek()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
    }

    public CatFactsResponse getCatFacts() {
        return RestAssured.when()
                .get(CAT_FACTS_URL)
                .prettyPeek()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .as(CatFactsResponse.class);
    }
}
