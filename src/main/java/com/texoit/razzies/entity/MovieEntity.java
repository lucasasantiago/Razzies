package com.texoit.razzies.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Integer launchYear;
    private String title;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudioEntity> studios = new ArrayList<>();
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProducerEntity> producers = new ArrayList<>();
    private Boolean winner;

    public MovieEntity(){}

    public MovieEntity(Integer launchYear, String title, List<ProducerEntity> producers, Boolean winner) {
        this.launchYear = launchYear;
        this.title = title;
        this.producers = producers;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(Integer launchYear) {
        this.launchYear = launchYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudioEntity> getStudios() {
        return studios;
    }

    public void setStudios(List<StudioEntity> studios) {
        this.studios = studios;
    }

    public List<ProducerEntity> getProducers() {
        return producers;
    }

    public void setProducers(List<ProducerEntity> producers) {
        this.producers = producers;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
