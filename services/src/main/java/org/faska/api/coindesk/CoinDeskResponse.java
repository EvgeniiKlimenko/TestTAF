package org.faska.api.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinDeskResponse {
    TimeUpdatedStampDto time;
    String disclaimer;
    String chartName;
    BpiDto bpi;
}
