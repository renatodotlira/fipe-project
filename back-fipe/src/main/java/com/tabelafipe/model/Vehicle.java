package com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private String id;

    @JsonProperty(value = "fipe_marca")
    private String fipeMarca;

    private String name;

    private String marca;

    private String key;

    @JsonProperty(value = "fipe_name")
    private String fipeName;

    private String referencia;

    @JsonProperty(value = "fipe_codigo")
    private String fipeCodigo;

    private String combustivel;

    @JsonProperty(value = "ano_modelo")
    private String anoModelo;

    private String preco;

    private String time;

    private String veiculo;

    String getPreco(){
        return this.preco;
    }

    Double getPrecoDouble(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(
                                new Locale("pt", "BR"));
        Number number = 0;
        try {
            number = numberFormat.parse(preco);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }

}
