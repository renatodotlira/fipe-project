package com.tabelafipe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValueVehicleAnnualDto {

    private double preco;

    private String year;

    private String sentense;

    public void addToSentence(String s){
        sentense += s;
    }

}
