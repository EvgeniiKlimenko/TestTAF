package org.faska.api.coindesk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeUpdatedStampDto {
    private String updated;
    private String updatedISO;
    private String updateduk;
}
