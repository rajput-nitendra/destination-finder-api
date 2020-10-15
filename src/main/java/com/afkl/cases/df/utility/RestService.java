package com.afkl.cases.df.utility;

import com.afkl.cases.df.exception.ApplicationException;
import com.afkl.cases.df.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestService {

    private final RestTemplate restTemplate;
    private final UtilityService utilityService;

    public ResponseEntity<String> get(String url) {
        String accessToken = utilityService.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().value() == 400) {
                throw new BadRequestException("Bad request");
            } else {
                throw new ApplicationException("Something went wrong");
            }
        }
    }
}
