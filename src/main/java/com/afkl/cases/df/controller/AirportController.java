package com.afkl.cases.df.controller;

import com.afkl.cases.df.model.Location;
import com.afkl.cases.df.service.AirportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<Location>> getAllLocations() throws JsonProcessingException {
        List<Location> locations = airportService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping(params = "term")
    public ResponseEntity<List<Location>> searchByTerm(@RequestParam("term") String term)
            throws JsonProcessingException {
        List<Location> locations = airportService.searchByTerm(term);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }


}
