package com.texoit.razzies.utility;

import com.texoit.razzies.model.MovieModel;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

@UtilityClass
public class CSVUtility {

    static String[] HEADERs = { "Year", "Title", "Studios", "Producers", "Winner" };

    private static final String WORD_YES = "yes";

    public static List<MovieModel> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'));) {

            List<MovieModel> movieList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                movieList.add(MovieModel.builder()
                                .year(Integer.parseInt(csvRecord.get(0)))
                                .title(csvRecord.get(1))
                                .studios(stringToList(csvRecord.get(2)))
                                .producers(stringToList(csvRecord.get(3)))
                                .winner(isWinnerAnalyzer(csvRecord.get(4)))
                                .build());
            }

            return movieList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private static List<String> stringToList(String list) {
        if (ObjectUtils.isEmpty(list)) {
            return new ArrayList<>();
        } else {
            return Arrays.stream(list.split(",\\sand\\s|\\sand\\s|,")).map(String::trim).collect(Collectors.toList());
        }
    }

    private static Boolean isWinnerAnalyzer(String isWinner){

        if (ObjectUtils.isEmpty(isWinner)) {
            return Boolean.FALSE;
        } else if (WORD_YES.equals(StringUtils.lowerCase(isWinner))){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
