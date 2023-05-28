package com.texoit.razzies.controller;

import com.texoit.razzies.model.response.AwardRangeResponse;
import com.texoit.razzies.service.AwardService;
import com.texoit.razzies.service.MovieService;
import com.texoit.razzies.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AwardController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private AwardService awardService;

    @GetMapping
    public List<MovieModel> list(){
        return movieService.getMovieList();
    }

    @GetMapping("/a")
    public AwardRangeResponse getAwardRange(){
        return awardService.getAwardRange();
    }
}
