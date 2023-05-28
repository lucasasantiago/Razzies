package com.texoit.razzies.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AwardRangeResponse {

    @JsonProperty("min")
    private List<AwardRangeDataResponse> lowestAwardRange;
    @JsonProperty("max")
    private List<AwardRangeDataResponse> higherAwardRange;
}
