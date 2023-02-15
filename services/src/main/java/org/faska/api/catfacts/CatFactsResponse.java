package org.faska.api.catfacts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class. Represents response from service.
 * RestAssured makes cast 'Response -> CatFactsResponse' when we call Response.extract().as(ThisModel.class).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatFactsResponse {
    public String fact;
    public String length;

    @Override
    public String toString() {
        return "CatFactsResponse obj: " + fact + ";\n length: " + length;
    }
}
