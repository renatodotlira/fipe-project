package com.tabelafipe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValueVehicleAnnual {

    private double preco;

    private String year;

    private String sentense;

    public void addToSentence(String s){
        sentense += s;
    }

}
