package com.example.tabelafipe.model;

import com.example.tabelafipe.dto.ValueVehicleAnnualDto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.tabelafipe.util.Utils.formatPercent;

public class SetValueVehicleAnnual {

    private List<ValueVehicleAnnualDto> valueVehicleAnnualDtos = new ArrayList<>();

    private DecimalFormat formatator = new DecimalFormat("#,##0.00");

    public void add(Vehicle vehicle){
        ValueVehicleAnnualDto valueVehicleAnnualDto = new ValueVehicleAnnualDto();
        valueVehicleAnnualDto.setPreco(vehicle.getPrecoDouble());
        valueVehicleAnnualDto.setSentense(getSentence(vehicle));
        valueVehicleAnnualDto.setYear(vehicle.getAnoModelo());
        valueVehicleAnnualDtos.add(valueVehicleAnnualDto);
    }

    /**
     *Monta as frases que serão exibidas no frontend e salva em uma lista de ValueVehicleAnnualDto,
     * há uma verificação se a lista já possui outros elementos, se houver, então atualiza o último elemento
     * da lista, acrescentando uma vírgula ao final da sentença no elemento. Também é usado os dados
     * do último elemento da lista para fazer os cálculos de depreciação no elemento atual em relação
     * ao elemento anterior
     *
     * @param vehicle
     * @return
     */
    private String getSentence(Vehicle vehicle){
        String sentence;
        if(valueVehicleAnnualDtos.size() > 0) {
            ValueVehicleAnnualDto lastElement = getLastElement();
            lastElement.addToSentence(",");
            sentence = createSentenceWithComparison(vehicle, lastElement);
        }else{
            sentence = createSentence(vehicle);
        }
        return sentence;
    }

    public List<String> getValueVehicleAnnualDtos(){
        List<String> sentences = new ArrayList<>();
        valueVehicleAnnualDtos.forEach(depreciationDto -> sentences.add(depreciationDto.getSentense()));
        return sentences;
    }

    private ValueVehicleAnnualDto getLastElement(){
        return valueVehicleAnnualDtos.get(valueVehicleAnnualDtos.size()-1);
    }

    private String createSentence(Vehicle vehicle){
        return "Valor em " + vehicle.getAnoModelo() + " -> " + vehicle.getPreco();
    }

    private String createSentenceWithComparison(Vehicle vehicle, ValueVehicleAnnualDto lastElement){
        String sentence = createSentence(vehicle);
        double diference = lastElement.getPreco() - vehicle.getPrecoDouble();
        double percent = (diference * 100) / lastElement.getPreco();
        sentence += " alteração de R$ " + formatator.format(diference);
        sentence += " (" + formatPercent(percent) + "%) em relação a " + lastElement.getYear();
        return sentence;
    }
}
