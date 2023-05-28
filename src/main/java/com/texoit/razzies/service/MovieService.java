package com.texoit.razzies.service;

import com.texoit.razzies.mapper.MovieMapper;
import com.texoit.razzies.model.MovieModel;
import com.texoit.razzies.repository.MovieRepository;
import com.texoit.razzies.utility.CSVUtility;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class MovieService {

    private List<MovieModel> movieList;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Value("classpath:/input/movielist.csv")
    private Resource inputResource;

    @PostConstruct
    private void init(){
        log.info("Starting MovieService init method.");

        try {
            movieList = CSVUtility.csvToTutorials(inputResource.getInputStream());
        } catch (IOException ex) {
            log.error("Error at MovieService init method. Exception: {}", ex);
            throw new RuntimeException(ex);
        }

        movieRepository.saveAll(movieMapper.toMovieEntityList(movieList));
    }

    public List<MovieModel> getMovieList(){
        return movieList;
    }

}
