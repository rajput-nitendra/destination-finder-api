package com.afkl.cases.df.service;

import com.afkl.cases.df.config.ApplicationEndpoints;
import com.afkl.cases.df.model.Location;
import com.afkl.cases.df.model.LocationWrapper;
import com.afkl.cases.df.utility.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final RestService restService;
    private final ApplicationEndpoints applicationEndpoints;
    private final ObjectMapper objectMapper;

    @Override
    public List<Location> getAllLocations() throws JsonProcessingException {

        ResponseEntity<String> responseEntity = restService.get(applicationEndpoints.getAirportsUri());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            LocationWrapper locationWrapper = objectMapper.readValue(responseEntity.getBody(), LocationWrapper.class);
            return locationWrapper.get_embedded().getLocations();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Location> searchByTerm(String term) throws JsonProcessingException {
        String uri = UriComponentsBuilder.fromUriString(applicationEndpoints.getAirportsUri())
                .queryParam("term", term).build().toUriString();

        ResponseEntity<String> responseEntity = restService.get(uri);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            LocationWrapper locationWrapper = objectMapper.readValue(responseEntity.getBody(), LocationWrapper.class);
            return locationWrapper.get_embedded().getLocations();
        }
        return Collections.emptyList();
    }
}
