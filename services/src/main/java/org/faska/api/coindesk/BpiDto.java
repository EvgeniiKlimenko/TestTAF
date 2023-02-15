package org.faska.api.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BpiDto {
    @JsonProperty("USD")
    CurrencyDto usd;
    @JsonProperty("GBP")
    CurrencyDto gbp;
    @JsonProperty("EUR")
    CurrencyDto eur;
}
