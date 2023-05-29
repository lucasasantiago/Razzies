package com.texoit.razzies.controller;

import com.texoit.razzies.model.response.AwardRangeResponse;
import com.texoit.razzies.service.AwardService;
import com.texoit.razzies.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class AwardController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private AwardService awardService;

    @GetMapping("/producer-award")
    public AwardRangeResponse getAwardRange(){
        log.info("Starting AwardController getAwardRange method");
        return awardService.getAwardRange();
    }
}
