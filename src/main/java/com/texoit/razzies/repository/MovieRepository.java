package com.texoit.razzies.repository;

import com.texoit.razzies.entity.MovieEntity;
import com.texoit.razzies.entity.dto.AwareRangeDTO;
import com.texoit.razzies.model.response.AwardRangeDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {


    @Query(value = "SELECT COUNT(MOVIE.LAUNCH_YEAR) awardAmount, MIN(MOVIE.LAUNCH_YEAR) previousWin, " +
            "MAX(MOVIE.LAUNCH_YEAR) followingWin, " +
            "MAX(MOVIE.LAUNCH_YEAR) - MIN(MOVIE.LAUNCH_YEAR) INTERVAL, PRODUCER.NAME producerName FROM MOVIE " +
            "INNER JOIN PRODUCER ON (PRODUCER.MOVIE_ID = MOVIE.ID) " +
            "WHERE MOVIE.WINNER = TRUE " +
            "GROUP BY PRODUCER.NAME " +
            "HAVING COUNT(MOVIE.LAUNCH_YEAR) > 1 " +
            "ORDER BY MIN(MOVIE.LAUNCH_YEAR)", nativeQuery = true)
    List<AwareRangeDTO> getProducerAwardRange();
}