package com.texoit.razzies.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieModel {

    private Integer year;
    private String title;
    private List<String> studios;
    private List<String> producers;
    private Boolean winner;
}
