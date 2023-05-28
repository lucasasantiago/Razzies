package com.texoit.razzies.mapper;

import com.texoit.razzies.entity.MovieEntity;
import com.texoit.razzies.entity.ProducerEntity;
import com.texoit.razzies.entity.StudioEntity;
import com.texoit.razzies.model.MovieModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(imports = {List.class}, componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "launchYear", source = "model.year")
    @Mapping(target = "title", source = "model.title")
    @Mapping(target = "studios", ignore = true)
    @Mapping(target = "producers", ignore = true)
    @Mapping(target = "winner", source = "model.winner")
    MovieEntity toMovieEntity(MovieModel model);

    default List<StudioEntity> toStudioList(List<String> list, MovieEntity movieEntity){
        List<StudioEntity> studioList = new ArrayList<>();
        for (String studio: list) {
            studioList.add(new StudioEntity(studio, movieEntity));
        }
        return studioList;
    }

    default List<ProducerEntity> toProducerList(List<String> list, MovieEntity movieEntity){
        List<ProducerEntity> producerList = new ArrayList<>();
        for (String producer: list) {
            producerList.add(new ProducerEntity(producer, movieEntity));
        }
        return producerList;
    }

    default List<MovieEntity> toMovieEntityList(List<MovieModel> movieList) {
        List<MovieEntity> movieEntityList = new ArrayList<>();
        for (MovieModel movie: movieList) {
            MovieEntity movieEntity = toMovieEntity(movie);
            movieEntity.setStudios(toStudioList(movie.getStudios(), movieEntity));
            movieEntity.setProducers(toProducerList(movie.getProducers(), movieEntity));
            movieEntityList.add(movieEntity);
        }
        return movieEntityList;
    }
}
