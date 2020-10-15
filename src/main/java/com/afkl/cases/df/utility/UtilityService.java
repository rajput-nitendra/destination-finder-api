package com.afkl.cases.df.utility;

import com.afkl.cases.df.config.ApplicationEndpoints;
import com.afkl.cases.df.config.AuthConfig;
import com.afkl.cases.df.model.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UtilityService {
    private final AuthConfig authConfig;
    private final RestTemplate restTemplate;
    private final ApplicationEndpoints applicationEndpoints;

    public String getAccessToken() {
        String credentials = authConfig.getClientId() + ":" + authConfig.getClientSecret();
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCredentials);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", authConfig.getGrantType());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);

        AuthenticationResponse response = restTemplate.postForObject(applicationEndpoints.getAccessTokenUri(), requestEntity, AuthenticationResponse.class);

        assert response != null;
        return response.getAccess_token();
    }
}
