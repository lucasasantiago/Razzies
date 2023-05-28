package com.texoit.razzies.entity.dto;

import jakarta.persistence.Entity;

public interface AwareRangeDTO {
    String getProducerName();
    Integer getInterval();
    Integer getPreviousWin();
    Integer getFollowingWin();
}
