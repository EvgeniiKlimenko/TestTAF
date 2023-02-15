package org.faska.api.coindesk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private String rate_float;
}
