package com.texoit.razzies.mapper;

import com.texoit.razzies.entity.MovieEntity;
import com.texoit.razzies.entity.StudioEntity;
import com.texoit.razzies.entity.dto.AwareRangeDTO;
import com.texoit.razzies.model.MovieModel;
import com.texoit.razzies.model.response.AwardRangeDataResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(imports = {List.class}, componentModel = "spring")
public interface AwardMapper {

    @Mapping(target = "producerName", expression = "java(dto.getProducerName())")
    @Mapping(target = "interval", expression = "java(dto.getInterval())")
    @Mapping(target = "previousWin", expression = "java(dto.getPreviousWin())")
    @Mapping(target = "followingWin", expression = "java(dto.getFollowingWin())")
    AwardRangeDataResponse toAwardRangeEntity(AwareRangeDTO dto);

    default List<AwardRangeDataResponse> toAwareRangeDataResponseList(List<AwareRangeDTO> dtoList){
        List<AwardRangeDataResponse> awardRangeDataResponseList = new ArrayList<>();
        for (AwareRangeDTO dto: dtoList) {
            awardRangeDataResponseList.add(AwardRangeDataResponse.builder()
                                                .producerName(dto.getProducerName())
                                                .interval(dto.getInterval())
                                                .previousWin(dto.getPreviousWin())
                                                .followingWin(dto.getFollowingWin())
                                                .build());
        }
        return awardRangeDataResponseList;
    }
}
