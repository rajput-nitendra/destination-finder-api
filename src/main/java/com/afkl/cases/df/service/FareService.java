package com.afkl.cases.df.service;

import com.afkl.cases.df.model.Fare;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface FareService {
    Fare calculateFare(String origin, String destination) throws JsonProcessingException;
}
