package com.afkl.cases.df.controller;

import com.afkl.cases.df.model.Fare;
import com.afkl.cases.df.service.FareService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class FareController {
    private final FareService fareService;

    @GetMapping(value = "/fares/{origin}/{destination}")
    public ResponseEntity<Fare> calculateFare(@PathVariable("origin") String origin,
                                              @PathVariable("destination") String destination) throws JsonProcessingException {
        Fare fare = fareService.calculateFare(origin, destination);
        return new ResponseEntity<>(fare, HttpStatus.OK);
    }
}
