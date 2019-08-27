package com.tabelafipe.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.tabelafipe.util.Utils.formatPercent;

public class SetValueVehicleAnnual {

    private List<ValueVehicleAnnual> valueVehicleAnnuals = new ArrayList<>();

    private DecimalFormat formatator = new DecimalFormat("#,##0.00");

    public void add(Vehicle vehicle){
        ValueVehicleAnnual valueVehicleAnnual = new ValueVehicleAnnual();
        valueVehicleAnnual.setPreco(vehicle.getPrecoDouble());
        valueVehicleAnnual.setSentense(getSentence(vehicle));
        valueVehicleAnnual.setYear(vehicle.getAnoModelo());
        valueVehicleAnnuals.add(valueVehicleAnnual);
    }

    /**
     *Monta as frases que serão exibidas no frontend e salva em uma lista de ValueVehicleAnnual,
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
        if(valueVehicleAnnuals.size() > 0) {
            ValueVehicleAnnual lastElement = getLastElement();
            lastElement.addToSentence(",");
            sentence = createSentenceWithComparison(vehicle, lastElement);
        }else{
            sentence = createSentence(vehicle);
        }
        return sentence;
    }

    public List<String> getValueVehicleAnnuals(){
        List<String> sentences = new ArrayList<>();
        valueVehicleAnnuals.forEach(depreciationDto -> sentences.add(depreciationDto.getSentense()));
        return sentences;
    }

    private ValueVehicleAnnual getLastElement(){
        return valueVehicleAnnuals.get(valueVehicleAnnuals.size()-1);
    }

    private String createSentence(Vehicle vehicle){
        return "Valor em " + vehicle.getAnoModelo() + " -> " + vehicle.getPreco();
    }

    private String createSentenceWithComparison(Vehicle vehicle, ValueVehicleAnnual lastElement){
        String sentence = createSentence(vehicle);
        double diference = lastElement.getPreco() - vehicle.getPrecoDouble();
        double percent = (diference * 100) / lastElement.getPreco();
        sentence += " alteração de R$ " + formatator.format(diference);
        sentence += " (" + formatPercent(percent) + "%) em relação a " + lastElement.getYear();
        return sentence;
    }
}
