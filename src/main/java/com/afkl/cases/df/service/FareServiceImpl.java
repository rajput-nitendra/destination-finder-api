package com.afkl.cases.df.service;

import com.afkl.cases.df.config.ApplicationEndpoints;
import com.afkl.cases.df.exception.ApplicationException;
import com.afkl.cases.df.exception.FareCalculationException;
import com.afkl.cases.df.model.Fare;
import com.afkl.cases.df.utility.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FareServiceImpl implements FareService {
    private final RestService restService;
    private final ApplicationEndpoints applicationEndpoints;
    private final ObjectMapper objectMapper;

    @Override
    public Fare calculateFare(String origin, String destination) throws JsonProcessingException {
        String url = applicationEndpoints.getCalculateFareUri() + "/" + origin + "/" + destination;
        ResponseEntity<String> responseEntity = restService.get(url);

        switch (responseEntity.getStatusCode()) {
            case OK:
                return objectMapper.readValue(responseEntity.getBody(), Fare.class);
            case BAD_REQUEST:
                throw new FareCalculationException("Invalid source and destination");
            default:
                throw new ApplicationException("Something went wrong");
        }
    }
}
