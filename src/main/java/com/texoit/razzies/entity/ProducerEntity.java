package com.texoit.razzies.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Producer")
public class ProducerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    public ProducerEntity(){}

    public ProducerEntity(String name, MovieEntity movie) {
        this.name = name;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }
}
