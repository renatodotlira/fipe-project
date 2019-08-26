package com.tabelafipe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {

    private String id;

    private String fipe_marca;

    private String name;

    private String marca;

    private String key;

    private String fipe_name;

    private String referencia;

    private String fipe_codigo;

    private String combustivel;

    private String ano_modelo;

    private String preco;

    private String time;

    private String veiculo;

}
