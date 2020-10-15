package com.afkl.cases.df.model;

import com.afkl.cases.df.enums.Currency;
import lombok.Data;

@Data
public class Fare {
    private double amount;
    private Currency currency;
    private String origin;
    private String destination;
}
