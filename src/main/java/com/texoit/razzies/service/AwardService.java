package com.texoit.razzies.service;

import com.texoit.razzies.entity.dto.AwareRangeDTO;
import com.texoit.razzies.mapper.AwardMapper;
import com.texoit.razzies.model.response.AwardRangeResponse;
import com.texoit.razzies.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AwardService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AwardMapper awardMapper;

    public AwardRangeResponse getAwardRange(){
        List<AwareRangeDTO> awareRangeDTOList = movieRepository.getProducerAwardRange();
        return buildAwardRangeResponse(awareRangeDTOList);
    }

    private AwardRangeResponse buildAwardRangeResponse(List<AwareRangeDTO> awareRangeDTOList) {
        Integer maxInterval = awareRangeDTOList.stream().max(Comparator.comparing(AwareRangeDTO::getInterval)).get().getInterval();
        Integer minInterval = awareRangeDTOList.stream().min(Comparator.comparing(AwareRangeDTO::getInterval)).get().getInterval();

        List<AwareRangeDTO> maxValues = awareRangeDTOList.stream().filter(a -> a.getInterval() == maxInterval).collect(Collectors.toList());
        List<AwareRangeDTO> minValues = awareRangeDTOList.stream().filter(a -> a.getInterval() == minInterval).collect(Collectors.toList());

        return AwardRangeResponse.builder()
                .lowestAwardRange(awardMapper.toAwareRangeDataResponseList(minValues))
                .higherAwardRange(awardMapper.toAwareRangeDataResponseList(maxValues))
                .build();
    }
}
