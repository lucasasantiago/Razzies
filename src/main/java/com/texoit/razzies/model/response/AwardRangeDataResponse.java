package com.texoit.razzies.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AwardRangeDataResponse {

    private String producerName;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;
}
