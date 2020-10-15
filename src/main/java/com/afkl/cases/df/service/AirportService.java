package com.afkl.cases.df.service;

import com.afkl.cases.df.model.Location;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface AirportService {
    List<Location> getAllLocations() throws JsonProcessingException;
    List<Location> searchByTerm(String term) throws JsonProcessingException;
}
