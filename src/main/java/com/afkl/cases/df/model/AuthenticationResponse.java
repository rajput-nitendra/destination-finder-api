package com.afkl.cases.df.model;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
}
